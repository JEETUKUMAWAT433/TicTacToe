package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ActivityBot extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnCurrent;
    private String b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9 ;
    private byte flag = 0 , count = 0;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        here is main code

        init();
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
    public void clickBtn(View view){
        btnCurrent = (Button) view;
        count ++;
        if (btnCurrent.getText().toString().equals("")) { // Check if the button is already clicked
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
//                btnCurrent.setText("O");
//                initializeBot();
                flag = 0;
            }
        }
    }

}