package com.example.custom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class SendMessageActivity extends AppCompatActivity {
    private EditText title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.outline_reorder_white_24));
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.services_menu:
                intent = new Intent(this, ServicesActivity.class);
                startActivity(intent);
                break;

            case R.id.contacts_menu:
                intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
                break;

            case R.id.about_us_menu:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.specialists_menu:
                intent = new Intent(this, EmployeesActivity.class);
                startActivity(intent);
                break;

            case R.id.complaint_menu: {
                Uri address = Uri.parse("https://www.google.com/maps/place/%D0%AE%D1%80%D1%82%D1%8D%D0%BA%D1%81-%D0%9D%D0%B0%D1%80/@53.9327104,27.5557092,15z/data=!4m7!3m6!1s0x0:0x3690d3ce31f1a8b6!8m2!3d53.9325604!4d27.5557094!9m1!1b1");
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {

                    Log.d("Intent", "???? ???????????????????? ???????????????????? ??????????????????!");
                }
                break;
            }

            case R.id.message_menu: {
                intent = new Intent(this, SendMessageActivity.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickServices(View view) {
        title = findViewById(R.id.message_title);
        message = findViewById(R.id.message_description);
        String messageString = message.getText().toString();

        if (messageString.equals("")) {
            Toast toast = Toast.makeText(this, "???????????? ?????????????????? ???????????????????? ????????????", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@custom.by"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, title.getText().toString());
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageString);
            startActivity(Intent.createChooser(emailIntent, "???????????????? ????????????..."));
        }
    }
}