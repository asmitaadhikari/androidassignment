package com.example.presidents;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {
        CircleImageView img;
        TextView tvName, tvDetail;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

            img = findViewById(R.id.imgPres);
            tvName = findViewById(R.id.txtName);
            tvDetail = findViewById(R.id.txtDesc);

            Bundle bundle = getIntent().getExtras();
            if(bundle != null){
                int imgId = bundle.getInt("image");
                String name = bundle.getString("name");
                String desc = bundle.getString("detail");

                img.setImageResource(imgId);
                tvName.setText(name);
                tvDetail.setText(desc);

                ActionBar bar = getSupportActionBar();
                bar.setTitle(name);
            }

        }
}
