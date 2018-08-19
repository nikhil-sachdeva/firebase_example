package nik.services;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    TextView name;
    TextView date_time;
    TextView status;
    TextView address;
    TextView cost;
    TextView where;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        details=(TextView)findViewById(R.id.details);
        name=(TextView)findViewById(R.id.name);
        cost=(TextView)findViewById(R.id.cost);
        date_time=(TextView)findViewById(R.id.date_time);
        status=(TextView)findViewById(R.id.status);
        address=(TextView)findViewById(R.id.address);
        where=(TextView)findViewById(R.id.where);


        Intent in = getIntent();
        Services services = (Services) in.getSerializableExtra("service");
        details.setText(services.getDetails());
        name.setText(services.getName());
        cost.setText(services.getCost());
        date_time.setText(services.getDate_time());
        address.setText(services.getAddress());
        where.setText(services.getWhere());
        status.setText(services.getStatus());
        getSupportActionBar().setTitle("BN : "+Integer.toString(services.getBN()));
       // details.setText(services.getDetails());

    }
}
