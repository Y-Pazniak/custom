package com.example.custom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.outline_reorder_white_24));
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

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

                    Log.d("Intent", "Не получается обработать намерение!");
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
        Intent intent = null;
        switch (view.getId()){
            case R.id.services_button_main:
                intent = new Intent(this, ServicesActivity.class);
                break;
            case R.id.contacts_button_main:
                intent = new Intent(this, ContactsActivity.class); break;
            case R.id.about_button_main:
                intent = new Intent(this, AboutActivity.class); break;
            case R.id.employees_button_main:
                intent = new Intent(this, EmployeesActivity.class); break;
            case R.id.employees_button_main1:
                intent = new Intent(this, EmployeesActivity.class); break;
        }
        startActivity(intent);
    }

    public void onClickDone(View view) {
    }
}