package com.hr190023.salih_selim_sekerci_final.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hr190023.salih_selim_sekerci_final.Model.AndroidVersion;
import com.hr190023.salih_selim_sekerci_final.R;
import com.hr190023.salih_selim_sekerci_final.Util.GlideUtil;

public class DetailActivity extends AppCompatActivity {

    AndroidVersion androidVersion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.androidVersion = (AndroidVersion) getIntent().getSerializableExtra("AndroidVersion"); //tıklanan itemin model instancesini al
        initalizeValues();
    }


    void initalizeValues() {
        //Gelen veriye göre ön yüzü ayarla
        GlideUtil.showImageFromUrl(this, androidVersion.getImgUrl(), (ImageView) findViewById(R.id.imgE3Header));
        ((TextView) findViewById(R.id.txtTitle)).setText(androidVersion.getName());
        ((TextView) findViewById(R.id.txtContent)).setText(androidVersion.getText());
        ((TextView) findViewById(R.id.txtReleaseDate)).setText(androidVersion.getReleaseDate());
    }
}
