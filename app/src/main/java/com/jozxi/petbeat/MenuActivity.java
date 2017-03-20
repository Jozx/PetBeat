package com.jozxi.petbeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jozxi.petbeat.Objetos.Adapter;
import com.jozxi.petbeat.Objetos.NodeMcu;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    List<NodeMcu> nodeMCUList;

    Adapter adapter;

    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Instanciamos el RecyclerView del activity_main layout y lo conectamos con la MainActivity
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        nodeMCUList = new ArrayList<>();

        //Base de datos

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(nodeMCUList);

        mRecyclerView.setAdapter(adapter);


        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("NodeMcu", dataSnapshot.toString());
                nodeMCUList.removeAll(nodeMCUList);
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()){
                    NodeMcu nodeMcu = snapshot.getValue(NodeMcu.class);
                    nodeMCUList.add(nodeMcu);
                }

                adapter.notifyDataSetChanged();
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
        case R.id.logout:
            mainActivity.goLogInScreen();
            return (true);
    }
        return(super.onOptionsItemSelected(item));
    }

    public void sensorGo (View view) {
        Intent intent = new Intent(this, SensoresActivity.class);
        startActivity(intent);
    }

}
