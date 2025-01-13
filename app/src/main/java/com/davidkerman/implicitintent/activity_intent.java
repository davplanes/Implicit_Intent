package com.davidkerman.implicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
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

import java.util.regex.Pattern;

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

    private String    iconcode;
    private Intent    intent;


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

        iconcode = getIntent().getStringExtra("image_code");

        Bitmap bitmap = getIntent().getParcelableExtra("image");
        if (bitmap != null) {
            icon.setImageBitmap(bitmap);
        }

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
                input2.setHint("Enter the desired minute:");
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
                input1.setHint("Enter your destination: ");
                input2.setHint("Enter your destination's city: ");
                input3.setHint("Enter your destination's country: ");
                break;

            case "mail":
                title.setText("Write an Email!");
                input1.setHint("Enter your subject: ");
                input2.setHint("Enter your content: ");
                input3.setHint("Enter to Email address: ");
                break;

            case "mappadrs":
                title.setText("Find any adress!");
                input1.setHint("Enter the street name: ");
                input2.setHint("Enter the house number: ");
                input3.setHint("Enter the city name: ");
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
                input1.setHint("Enter the phone number you want to message to: ");
                input2.setHint("Enter your message: ");
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
                input1.setHint("Enter the desired webpage URL: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;

            case "wz":
                title.setText("Get to any destination with Waze!");
                input1.setHint("Enter your destination: ");
                input2.setHint("Enter your destination's city: ");
                input3.setHint("Enter your destination's country: ");
                break;

            case "yt":
                title.setText("Access any YouTube video!");
                input1.setHint("Enter the desired video ID: ");
                input2.setVisibility(View.INVISIBLE);
                input3.setVisibility(View.INVISIBLE);
                break;
        }

        SetListeners();
    }

    private void SetListeners() {
        dial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial1.getText().toString());
            }
        });

        dial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial2.getText().toString());
            }
        });

        dial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial3.getText().toString());
            }
        });

        dial4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial4.getText().toString());
            }
        });

        dial5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial5.getText().toString());
            }
        });

        dial6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial6.getText().toString());
            }
        });

        dial7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial7.getText().toString());
            }
        });

        dial8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial8.getText().toString());
            }
        });

        dial9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dial9.getText().toString());
            }
        });

        dial0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.getText().toString().endsWith("\n"))
                    title.append("+");
                else{
                    title.append(dial0.getText().toString());
                }
            }
        });

        dialast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dialast.getText().toString());
            }
        });

        dialhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.append(dialhash.getText().toString());
            }
        });

        launchbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View view) {
                switch (iconcode){
                    case "camera":
                        Toast.makeText(activity_intent.this, "Not available at the moment", Toast.LENGTH_LONG).show();
                        break;

                    case "clck":
                        try {
                            int hours = Integer.parseInt(input1.getText().toString());
                            int minutes = Integer.parseInt(input2.getText().toString());

                            intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
                            intent.putExtra(AlarmClock.EXTRA_HOUR, hours);
                            intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

                            startActivity(intent);
                        } catch (NumberFormatException e) {
                            Toast.makeText(activity_intent.this, "Please enter valid hours and minutes", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "dial":
                        String phone = title.getText().toString().substring(22);

                        if (phone != null && Pattern.matches("^\\+?[0-9]{10,15}$", phone)){
                            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(activity_intent.this, "Invalid phone number format", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "gm":
                        String loc = input1.getText().toString();
                        String city = input2.getText().toString();
                        String country = input3.getText().toString();

                        if (loc.isEmpty() && city.isEmpty() && country.isEmpty()){
                            Toast.makeText(activity_intent.this, "Please enter at least one parameter", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            loc = loc.replaceAll("\\s+", "+");
                            city = city.replaceAll("\\s+", "+");
                            country = country.replaceAll("\\s+", "+");

                            Uri gmmIntentUri = Uri.parse("google.navigation:q="+ loc + ",+" + city + "+" + country);
                            intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            intent.setPackage("com.google.android.apps.maps");
                            startActivity(intent);
                        }
                        break;

                    case "mail":
                        String subject = input1.getText().toString();
                        String content = input2.getText().toString();
                        String toemail = input3.getText().toString();

                        if (subject.isEmpty() && content.isEmpty() && toemail.isEmpty())
                            Toast.makeText(activity_intent.this, "At least one field must be filled", Toast.LENGTH_SHORT).show();

                        else{
                            intent = new Intent(Intent.ACTION_SEND);
                            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toemail});
                            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                            intent.putExtra(Intent.EXTRA_TEXT, content);
                            intent.setType("message/rfc822");
                            startActivity(Intent.createChooser(intent, "Choose Email client: "));
                        }
                        break;

                    case "mappadrs":
                        String streetname = input1.getText().toString();
                        String housenumber = input2.getText().toString();
                        String citya = input3.getText().toString(); //String city already exists before

                        if (streetname.isEmpty() && housenumber.isEmpty() && citya.isEmpty())
                            Toast.makeText(activity_intent.this, "At least one field must be filled", Toast.LENGTH_SHORT).show();

                        else{
                            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + streetname + " Street " + housenumber + ", " + citya);
                            intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            intent.setPackage("com.google.android.apps.maps");
                            startActivity(intent);
                        }
                        break;

                    case "mappcoords":
                        String latitude = input1.getText().toString();
                        String longitude = input2.getText().toString();

                        try{
                            double latitudeval = Double.parseDouble(latitude);
                            double longitudeval = Double.parseDouble(longitude);

                            if (latitudeval < -90 || latitudeval > 90)
                                Toast.makeText(activity_intent.this, "Latitude must be within the range of -90 to +90", Toast.LENGTH_SHORT).show();
                            else if (longitudeval < -180 || longitudeval > 180)
                                Toast.makeText(activity_intent.this, "Longitude must be within the range of -180 to +180", Toast.LENGTH_SHORT).show();
                            else{
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + latitude + "," + longitude);
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                            }
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(activity_intent.this, "Please enter numbers or decimals for coordinates", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "msg":
                        String message = input1.getText().toString();

                        if (message.isEmpty())
                            Toast.makeText(activity_intent.this, "Please enter your message", Toast.LENGTH_SHORT).show();

                        else{
                            intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT, message);

                            startActivity(Intent.createChooser(intent, "Share Message"));
                        }
                        break;

                    case "sms":
                        String phonenum = input1.getText().toString();
                        String sms = input2.getText().toString();

                        if (phonenum != null && Pattern.matches("^\\+?[0-9]{10,15}$", phonenum)){
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("sms:" + phonenum));
                            intent.putExtra("sms_body", sms);

                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(activity_intent.this, "Invalid phone number format", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "wanp":
                        try{
                            intent = new Intent(Intent.ACTION_MAIN);
                            intent.setPackage("com.whatsapp");

                            startActivity(intent);
                        }

                        catch(Exception e){
                            Toast.makeText(activity_intent.this, "Whatsapp isn't installed, redirecting to Play Store.", Toast.LENGTH_SHORT).show();
                            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
                            startActivity(intent);
                        }
                        break;

                    case "wap":
                        String contact = title.getText().toString().substring(36);

                        if (contact != null && Pattern.matches("^\\+?[0-9]{10,15}$", contact)){
                            try{
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + contact));
                                startActivity(intent);
                            }

                            catch (Exception e){
                                Toast.makeText(activity_intent.this, "Whatsapp isn't installed, redirecting to Play Store.", Toast.LENGTH_SHORT).show();
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
                                startActivity(intent);
                            }
                        }

                        else{
                            Toast.makeText(activity_intent.this, "Invalid phone number format", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "web":
                        String url = input1.getText().toString();

                        if(url.startsWith("https://")){
                            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(activity_intent.this, "Invalid website format. It must begin with \"https://\".", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "wz":
                        String wazeloc = input1.getText().toString();
                        String wazecity = input2.getText().toString();
                        String wazecountry = input3.getText().toString();

                        if (wazeloc.isEmpty() && wazecity.isEmpty() && wazecountry.isEmpty()){
                            Toast.makeText(activity_intent.this, "Please enter at least one parameter", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            wazeloc = wazeloc.replaceAll("\\s+", "+");
                            wazecity = wazecity.replaceAll("\\s+", "+");
                            wazecountry = wazecountry.replaceAll("\\s+", "+");

                            try{
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://waze.com/ul?q="+ wazeloc + ",+" + wazecity + ",+" + wazecountry));
                                intent.setPackage("com.google.android.apps.maps");
                                startActivity(intent);
                            }

                            catch(Exception e){
                                Toast.makeText(activity_intent.this, "Waze isn't installed, redirecting to Play Store.", Toast.LENGTH_SHORT).show();
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.waze"));
                                startActivity(intent);
                            }

                        }
                        break;

                    case "yt":
                        String id = input1.getText().toString();

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + id));

                        startActivity(intent);

                        break;
                }
            }
        });

        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(activity_intent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}