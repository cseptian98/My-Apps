package com.example.myapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import model.Teman;
import presenter.PresenterDetailTeman;
import view.ViewDetailTeman;

//16-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class DetailTeman extends AppCompatActivity implements ViewDetailTeman, View.OnClickListener {

    TextView tvName, tvNIM, tvClass, tvPhone, tvEmail, tvIg;
    PresenterDetailTeman presenter;
    Teman teman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);

        presenter = new PresenterDetailTeman(this);

        tvName = findViewById(R.id.tvNamaTeman);
        tvNIM = findViewById(R.id.tvNIMTeman);
        tvClass = findViewById(R.id.tvKelasTeman);
        tvPhone = findViewById(R.id.tvTelpTeman);
        tvEmail = findViewById(R.id.tvEmailTeman);
        tvIg = findViewById(R.id.tvIgTeman);

        presenter.getFriendsDetail();
    }

    @Override
    public void showDetail() {

        teman = getIntent().getParcelableExtra("teman");

        tvName.setText(teman.getNama());
        tvNIM.setText(teman.getNim());
        tvClass.setText(teman.getKelas());
        tvPhone.setText(teman.getTelp());
        tvEmail.setText(teman.getEmail());
        tvIg.setText(teman.getSosmed());
    }

    @Override
    public void doCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", teman.getTelp(), null));
        startActivity(i);
    }

    @Override
    public void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + teman.getEmail()));
        startActivity(i);
    }

    @Override
    public void openInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + teman.getSosmed().replace("@", "")));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layPhone:
                presenter.makeCall();
                break;
            case R.id.layEmail:
                presenter.sendEmail();
                break;
            case R.id.layIg:
                presenter.openInstagram();
                break;
        }
    }
}
