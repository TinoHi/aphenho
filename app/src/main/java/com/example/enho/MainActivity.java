package com.example.enho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView)findViewById(R.id.tvCountdown);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar);
        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar2);

        Bitmap circularBitmap = ImageConvert.getRoundedCornerBitmap(bitmap, 500);
        Bitmap circularBitmap2 = ImageConvert.getRoundedCornerBitmap(bitmap2, 500);


        ImageView circularImageView = (ImageView) findViewById(R.id.imgAvatarmale);
        circularImageView.setImageBitmap(circularBitmap);

        ImageView circularImageView2 = (ImageView) findViewById(R.id.imgAvatarfemale);
        circularImageView2.setImageBitmap(circularBitmap2);

        CountDownTimer w= new CountDownTimer(60000*60*24, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvCount.setText("Seconds remaining: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                tvCount.setText("Seconds remaining: 0");
            }
        }.start();
    }
}
