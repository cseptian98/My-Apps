package com.example.myapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import model.Teman;
import presenter.PresenterTambahTeman;
import view.ViewTambahTeman;

//17-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class TambahTeman extends AppCompatActivity implements ViewTambahTeman {

        EditText etName, etNIM, etClass, etPhone, etEmail, etIG;
        PresenterTambahTeman presenter;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);

        presenter = new PresenterTambahTeman(this);

        etName = findViewById(R.id.etName);
        etNIM = findViewById(R.id.etNIM);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
                finish();
                break;
        case R.id.nav_done:
                Teman teman = new Teman(
                        etNIM.getText().toString(),
                        etName.getText().toString(),
                        etClass.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString(),
                        etPhone.getText().toString()
                        );
                presenter.tambahTeman(teman);
                break;
        }

        return super.onOptionsItemSelected(item);
        }

@Override
public void saveData(Teman teman) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("newFriend", teman);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
        }


}
