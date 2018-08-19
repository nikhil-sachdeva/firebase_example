package nik.services;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by nikhil on 19/08/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {




    ArrayList<Services> result = new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    public RecyclerAdapter(){

    }

    public RecyclerAdapter (ArrayList<Services> result,Context context){
        this.context=context;
        this.result=result;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_layout,parent,false);
        final Holder holder = new Holder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                Intent in = new Intent(context,DetailsActivity.class);
                in.putExtra("pos",position);
                in.putExtra("service",result.get(position));
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }
        });
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(result.get(position).getName());
        holder.bn.setText((Integer.toString(result.get(position).getBN())));
        holder.status.setText(result.get(position).getStatus());
        holder.date_time.setText(result.get(position).getDate_time());


    }

    public  ArrayList<Services> getReuslt(){
        return result;
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public class Holder extends RecyclerView.ViewHolder{
        TextView name;
        TextView bn;
        TextView status;
        TextView date_time;
        public Holder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            bn=(TextView)itemView.findViewById(R.id.bn);
            status=(TextView)itemView.findViewById(R.id.status);
            date_time=(TextView)itemView.findViewById(R.id.date_time);
        }
    }

}
