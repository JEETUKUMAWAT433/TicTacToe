package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.tictactoe.R;

public class GameActivity extends AppCompatActivity {
    protected Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    protected String b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9 ;
    protected byte flag = 0 , count = 0;;

    Button  btn_play_with_friend;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Set up window insets listener for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        init();


    }

    private void init() {
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
        Button btnCurrent = (Button) view;
        count ++;
        if (btnCurrent.getText().toString().equals("")) { // Check if the button is already clicked
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
                btnCurrent.setText("O");
                flag = 0;
            }
        }

        if(count > 4){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            // Horizontal conditions
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                Toast.makeText(this, b1 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b1);
            }
            else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                Toast.makeText(this, b4 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b4);

            }
            else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                Toast.makeText(this, b7 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b7);

            }

// Vertical conditions
            else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                Toast.makeText(this, b1 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b1);

            }
            else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                Toast.makeText(this, b2 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b2);

            }
            else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                Toast.makeText(this, b3 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b3);

            }

// Diagonal conditions
            else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                Toast.makeText(this, b1 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b1);
            }
            else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                Toast.makeText(this, b3 + " is the winner!", Toast.LENGTH_SHORT).show();
                showWinnerDialog(b3);

            }

        }
        if (count == 9) {
            showDrawDialog(); // Call a method to display a draw message
        }


    }
    protected void showWinnerDialog(String winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder.setTitle("Game Over");
                builder.setMessage(winner + " is the winner!");

                // Add a button to restart the game
                builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame(); // Call a method to restart the game
                    }
                });

                // Make the alert dialog non-cancelable (so it won't disappear when tapping outside)
                builder.setCancelable(false);
                // Show the dialog
                builder.show();
            }
        } , 1500);

    }

    // Method to restart the game
    private void restartGame() {
        // Reset all the buttons to their initial state
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;
    }

    protected void showDrawDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder.setTitle("Game Over");
                builder.setMessage("It's a draw!");

                // Add a button to restart the game
                builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame(); // Restart the game
                    }
                });

                builder.setCancelable(false);
                builder.show();
            }
        } , 1500);

    }

}

