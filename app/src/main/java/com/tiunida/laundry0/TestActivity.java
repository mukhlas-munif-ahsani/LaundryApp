package com.tiunida.laundry0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tiunida.laundry0.ActivityOrderDetail.View.OrderDetailActivity;

public class TestActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        text = findViewById(R.id.textViewtes);
        String message = getIntent().getStringExtra("message");
        String from_user = getIntent().getStringExtra("from_user_id");
        text.setText("From = " + from_user + " Message = " + message);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, OrderDetailActivity.class);
                intent.putExtra("id",message);
                startActivity(intent);
            }
        });
//        Intent intent = new Intent(TestActivity.this, OrderDetailActivity.class);
//        startActivity(intent);
    }
}
