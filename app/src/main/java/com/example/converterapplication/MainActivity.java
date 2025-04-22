package com.example.converterapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//                    this will tell java file my xml file has some components
EditText inputvalue;
Button converterBtn;
TextView outputvalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//                       we will combine the variable with the java file
        inputvalue = findViewById(R.id.input);
        converterBtn = findViewById(R.id.convertbtn);
        outputvalue = findViewById(R.id.output);
//
        converterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float kg = Float.parseFloat(inputvalue.getText().toString());
                double pounds = kg*2.20;
                outputvalue.setText(String.format("%.2f pounds", pounds));

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}