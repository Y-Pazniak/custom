package com.example.custom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.outline_reorder_white_24));
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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

    private class TabsAdapter extends FragmentPagerAdapter {
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new MinskFragment();
                case 1: return new GrodnoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return getResources().getString(R.string.minsk);
                case 1: return getResources().getString(R.string.grodno);
            }
            return null;
        }
    }
}