package com.example.wydarzenie_w_sudetach;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int likeCount = 0;
    private TextView likeCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeCountText = findViewById(R.id.likeCountText);
        Button likeButton = findViewById(R.id.likeButton);
        Button dislikeButton = findViewById(R.id.dislikeButton);


        likeButton.setOnClickListener(v -> {
            likeCount++;
            updateLikeCount();
        });


        dislikeButton.setOnClickListener(v -> {
            if (likeCount > 0) {
                likeCount--;
                updateLikeCount();
            }
        });
        TextView text_2 = findViewById(R.id.obszar);
        findViewById(R.id.zapisz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = ((EditText) findViewById(R.id.form1)).getText().toString().trim();


                String pass = ((EditText) findViewById(R.id.form2)).getText().toString().trim();
                String passConf = ((EditText) findViewById(R.id.form3)).getText().toString().trim();


                if (!email.contains("@")) {
                    text_2.setText("Obszar komunikatów: \n E-mail nie zawiera @");
                }
                else if (!pass.equals(passConf)) {
                    text_2.setText("Obszar komunikatów: \n Hasła się różnią");
                } else {
                    text_2.setText("Obszar komunikatów: \n Zarejestrowano: "+ email);

                }
            }
        });
        findViewById(R.id.zobacz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.form1)).getText().toString().trim();
                text_2.setText("Obszar komunikatów: " + email);
            }


        });
    }

    private void updateLikeCount() {
        likeCountText.setText(likeCount + " polubień");
    }
}