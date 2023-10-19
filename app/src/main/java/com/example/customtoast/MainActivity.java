package com.example.customtoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView toast_btn;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast_btn = findViewById(R.id.toast_btn);
        btn = findViewById(R.id.btn);

        Log.d("log show", "here we are going to show logs");






        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                view = getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.view_container));
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                Log.d("click show", "here we are going to show logs");
            }
        });


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Terms & Conditions");
        alertDialog.setTitle("Alert!");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"yes", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"yes alert dialog work",Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
    }
}