package com.example.wydarzenie_w_sudetach;


import android.os.Bundle;
import android.widget.Button;
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
    }

    private void updateLikeCount() {
        likeCountText.setText(likeCount + " polubień");
    }
}