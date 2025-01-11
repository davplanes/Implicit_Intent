package com.davidkerman.implicitintent;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_intent extends AppCompatActivity {

    private TextView  title;
    private EditText  input1;
    private EditText  input2;
    private EditText  input3;
    private Button    dial1;
    private Button    dial2;
    private Button    dial3;
    private Button    dial4;
    private Button    dial5;
    private Button    dial6;
    private Button    dial7;
    private Button    dial8;
    private Button    dial9;
    private Button    dial0;
    private Button    dialast;
    private Button    dialhash;
    private ImageView icon;
    private Button    launchbutton;
    private Button    menubutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InitializeViews();
    }

    private void InitializeViews() {
        title        = findViewById(R.id.intenttitle);
        input1       = findViewById(R.id.userinput1);
        input2       = findViewById(R.id.userinput2);
        input3       = findViewById(R.id.userinput3);
        dial1        = findViewById(R.id.dial1);
        dial2        = findViewById(R.id.dial2);
        dial3        = findViewById(R.id.dial3);
        dial4        = findViewById(R.id.dial4);
        dial5        = findViewById(R.id.dial5);
        dial6        = findViewById(R.id.dial6);
        dial7        = findViewById(R.id.dial7);
        dial8        = findViewById(R.id.dial8);
        dial9        = findViewById(R.id.dial9);
        dial0        = findViewById(R.id.dial0);
        dialast      = findViewById(R.id.dialast);
        dialhash     = findViewById(R.id.dialhash);
        icon         = findViewById(R.id.iconorphoto);
        launchbutton = findViewById(R.id.launchbutton);
        menubutton   = findViewById(R.id.menubutton);

        Bitmap bitmap = getIntent().getParcelableExtra("image");
        if (bitmap != null) {
            icon.setImageBitmap(bitmap);
        }

        String iconcode = getIntent().getStringExtra("image_code");

        switch(iconcode){
            case "camera":
                title.setText("Take a photo!");
                input1.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "clck":
                title.setText("Set an alarm clock!");
                input1.setHint("Enter the desired hour:");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "dial":
                title.setText("Dial anyone you want!\n");
                input1.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                dial1.setVisibility(View.VISIBLE);
                dial2.setVisibility(View.VISIBLE);
                dial3.setVisibility(View.VISIBLE);
                dial4.setVisibility(View.VISIBLE);
                dial5.setVisibility(View.VISIBLE);
                dial6.setVisibility(View.VISIBLE);
                dial7.setVisibility(View.VISIBLE);
                dial8.setVisibility(View.VISIBLE);
                dial9.setVisibility(View.VISIBLE);
                dial0.setVisibility(View.VISIBLE);
                dialast.setVisibility(View.VISIBLE);
                dialhash.setVisibility(View.VISIBLE);
                break;

            case "gm":
                title.setText("Navigate with Google Maps!");
                input1.setHint("Enter your starting point: ");
                input2.setHint("Enter your destination: ");
                input3.setVisibility(View.INVISIBLE);
                break;

            case "mail":
                title.setText("Write an Email!");
                input1.setHint("Enter your subject: ");
                input2.setHint("Enter your content: ");
                input3.setHint("Enter to Email adress: ");
                break;

            case "mappadrs":
                title.setText("Find any adress!");
                input1.setHint("Enter the desired adress: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "mappcoords":
                title.setText("Find any location by coordinates!");
                input1.setHint("Enter the desired latitude: ");
                input2.setHint("Enter the desired longitude: ");
                input3.setVisibility(View.INVISIBLE);
                break;

            case "msg":
                title.setText("Write a message!");
                input1.setHint("Enter your message: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "sms":
                title.setText("Write a message!");
                input1.setHint("Enter your message: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "wanp":
                title.setText("Open Whatsapp without a phone number!");
                input1.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "wap":
                title.setText("Open whatsapp with a phone number!\n");
                input1.setVisibility(View.INVISIBLE);
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                dial1.setVisibility(View.VISIBLE);
                dial2.setVisibility(View.VISIBLE);
                dial3.setVisibility(View.VISIBLE);
                dial4.setVisibility(View.VISIBLE);
                dial5.setVisibility(View.VISIBLE);
                dial6.setVisibility(View.VISIBLE);
                dial7.setVisibility(View.VISIBLE);
                dial8.setVisibility(View.VISIBLE);
                dial9.setVisibility(View.VISIBLE);
                dial0.setVisibility(View.VISIBLE);
                dialast.setVisibility(View.VISIBLE);
                dialhash.setVisibility(View.VISIBLE);
                break;

            case "web":
                title.setText("Access any web page!");
                input1.setHint("Enter the desired webpage: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "waze":
                title.setText("Get to any destination with Waze!");
                input1.setHint("Enter your desired destination: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "yt":
                title.setText("Access any YouTube video!");
                input1.setHint("Enter the desired video URL: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;
        }

    }
}