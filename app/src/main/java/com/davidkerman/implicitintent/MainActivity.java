package com.davidkerman.implicitintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private Toolbar     toolbar;
    private ImageButton icon1;
    private ImageButton icon2;
    private ImageButton icon3;

    private Intent intent;

    private String icon1code;
    private String icon2code;
    private String icon3code;

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

        intent = new Intent(this, activity_intent.class);

        SetListeners();
    }

    private void SetListeners() {
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = icon1.getDrawable();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                intent.putExtra("image", bitmap);
                intent.putExtra("image_code", icon1code);
                startActivity(intent);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = icon2.getDrawable();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                intent.putExtra("image", bitmap);
                intent.putExtra("image_code", icon2code);
                startActivity(intent);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = icon3.getDrawable();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                intent.putExtra("image", bitmap);
                intent.putExtra("image_code", icon3code);
                startActivity(intent);
            }
        });
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

            icon1code = "wap";
            icon2code = "wanp";

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.othermsgs) {
            icon1.setImageResource(R.drawable.sms);
            icon2.setImageResource(R.drawable.mail);
            icon3.setImageResource(R.drawable.msg);

            icon1code = "sms";
            icon2code = "mail";
            icon3code = "msg";

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

            icon1code = "mappcoords";
            icon2code = "mappadrs";

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.nav) {
            icon1.setImageResource(R.drawable.gm);
            icon2.setImageResource(R.drawable.wz);

            icon1code = "gm";
            icon2code = "wz";

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.web) {
            icon1.setImageResource(R.drawable.web);
            icon2.setImageResource(R.drawable.yt);

            icon1code = "web";
            icon2code = "yt";

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.INVISIBLE);

            return true;
        }

        else if (id == R.id.others) {
            icon1.setImageResource(R.drawable.camera);
            icon2.setImageResource(R.drawable.dial);
            icon3.setImageResource(R.drawable.clck);

            icon1code = "camera";
            icon2code = "dial";
            icon3code = "clck";

            icon1.setVisibility(View.VISIBLE);
            icon2.setVisibility(View.VISIBLE);
            icon3.setVisibility(View.VISIBLE);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}