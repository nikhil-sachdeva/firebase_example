package nik.services;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
ArrayList<Services> result = new ArrayList<>();
RecyclerView list;

    private static final String TAG = "wow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("My Orders");

        list=(RecyclerView)findViewById(R.id.list);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Services");




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()){

                    Log.d(TAG, "onDataChange: times");
                    Services services = new Services();
                    for(DataSnapshot node : data.getChildren() ){

                        if(node.getKey().equals("name")){
                            services.setName(node.getValue().toString());
                            Log.d(TAG, "onDataChange: lol"+node.getValue());
                        }
                        if(node.getKey().equals("BN")){
                            services.setBN(Integer.parseInt(node.getValue().toString()));
                        }
                        if(node.getKey().equals("Cost")){
                            services.setCost(node.getValue().toString());
                        }
                        if(node.getKey().equals("address")){
                            services.setAddress(node.getValue().toString());
                        }
                        if(node.getKey().equals("status")){
                            services.setStatus(node.getValue().toString());
                        }
                        if(node.getKey().equals("date-time")){
                            services.setDate_time(node.getValue().toString());
                        }
                        if(node.getKey().equals("details")){
                            services.setDetails(node.getValue().toString());
                        }
                        if(node.getKey().equals("where")){
                            services.setWhere(node.getValue().toString());
                        }

                    }
                    result.add(services);

                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(result,getApplicationContext());
                list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                list.hasFixedSize();
                list.addItemDecoration(new DividerItemDecoration(getApplicationContext()));
                list.setItemAnimator(new DefaultItemAnimator());
                list.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    public class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private Drawable mDivider;

        public DividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.list_bg);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }

}
