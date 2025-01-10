package com.davidkerman.implicitintent;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Toolbar     toolbar;
    private ImageButton icon1;
    private ImageButton icon2;
    private ImageButton icon3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InitializeViews();
    }

    private void InitializeViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(findViewById(R.id.toolbar));

        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.msg) {
            return true;
        }

        else if (id == R.id.wa) {
            icon1.setImageResource(R.drawable.wap);
            icon2.setImageResource(R.drawable.wanp);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.othermsgs) {
            icon1.setImageResource(R.drawable.sms);
            icon2.setImageResource(R.drawable.mail);
            icon3.setImageResource(R.drawable.msg);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.VISIBLE);

            return true;
        }

        else if (id == R.id.map) {
            return true;
        }

        else if (id == R.id.loc) {
            icon1.setImageResource(R.drawable.mappcoords);
            icon2.setImageResource(R.drawable.mappadrs);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.nav) {
            icon1.setImageResource(R.drawable.gm);
            icon2.setImageResource(R.drawable.wz);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.web) {
            icon1.setImageResource(R.drawable.web);
            icon2.setImageResource(R.drawable.yt);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.others) {
            icon1.setImageResource(R.drawable.camera);
            icon2.setImageResource(R.drawable.dial);
            icon3.setImageResource(R.drawable.clck);

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.VISIBLE);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}