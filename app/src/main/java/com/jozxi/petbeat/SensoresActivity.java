package com.jozxi.petbeat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jozxi.petbeat.Objetos.NodeMcu;

public class SensoresActivity extends AppCompatActivity {

    private TextView pulsoTextView;
    private TextView tempTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        //Base de datos

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        pulsoTextView = (TextView) findViewById(R.id.pulso);
        tempTextView = (TextView) findViewById(R.id.temperatura);


        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("NodeMcu", dataSnapshot.toString());

                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()){
                    NodeMcu nodeMcu = snapshot.getValue(NodeMcu.class);
                    pulsoTextView.setText(String.valueOf(nodeMcu.getHeartBeat()));
                    tempTextView.setText(String.valueOf(nodeMcu.getTemperature()));
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Error base de datos", databaseError.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {

        case R.id.back:
            finish();
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }

}
