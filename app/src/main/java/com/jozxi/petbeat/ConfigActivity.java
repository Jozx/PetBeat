package com.jozxi.petbeat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class ConfigActivity extends AppCompatActivity {

    private static final String TAG = "ConfigActivity";
    private EditText editText;
    private int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        getIntent().getExtras().getString("token");

        editText = (EditText) findViewById(R.id.editText);

    }


    public void enviar (View view) {
        String idNode = editText.getText().toString();
        DatabaseReference idAndroid = FirebaseDatabase.getInstance().getReference().child(idNode).child("id_android");
        DatabaseReference id_node = FirebaseDatabase.getInstance().getReference().child(idNode).child("id");
        DatabaseReference id_animal = FirebaseDatabase.getInstance().getReference().child(idNode).child("tipo_animal");

        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_perro);
        boolean estado = radioButton.isChecked();

        if (estado) {
            flag = 1;
        }
        else
        {
            flag = 2;
        }


        idAndroid.setValue(getIntent().getExtras().getString("token"));
        id_node.setValue(idNode);
        id_animal.setValue(flag);

        Log.i(TAG, "idNode " + idNode);
        Log.d(TAG, "idAndroid " + (getIntent().getExtras().getString("token")));
        Log.d(TAG, "id_animal " + flag);

        FirebaseMessaging.getInstance().subscribeToTopic(idNode);
        Log.d(TAG, "Subscribed to " + idNode);

        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Dispositivo Agregado " +
                                "- Favor vaya atras", Toast.LENGTH_SHORT);

        toast1.show();

    }
}
