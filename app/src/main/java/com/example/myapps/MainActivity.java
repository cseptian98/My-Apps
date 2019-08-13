package com.example.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.InfoAdapter;
import fragment.FragmentAbout;
import fragment.FragmentKontak;
import fragment.FragmentProfil;
import fragment.FragmentTeman;
import model.Teman;

//14-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class MainActivity extends AppCompatActivity {

    private ArrayList<Teman> list = new ArrayList<>();
    private int backButtonCount;


    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.view, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navProfil:
                    changeFragment(FragmentProfil.newInstance());
                    return true;
                case R.id.navKontak:
                    changeFragment(FragmentKontak.newInstance());
                    return true;
                case R.id.navTeman:
                    changeFragment(FragmentTeman.newInstance());
                    return true;
                case R.id.navTentang:
                    changeFragment(FragmentAbout.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(FragmentProfil.newInstance());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }




    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

}
