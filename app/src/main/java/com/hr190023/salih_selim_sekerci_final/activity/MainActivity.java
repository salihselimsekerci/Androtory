package com.hr190023.salih_selim_sekerci_final.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.hr190023.salih_selim_sekerci_final.R;
import com.hr190023.salih_selim_sekerci_final.Util.GlideUtil;
import com.hr190023.salih_selim_sekerci_final.Util.Helpers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GlideUtil.setAsBackgroundFromBaseUrl(this, getString(R.string.bg_name), (ViewGroup) findViewById(R.id.mainLayout));//Arka plana resim koy



    }

    @Override
    protected void onResume() {
        super.onResume();
        checkConnection();

    }

    private void goListActivity() { //2. Ekrana git
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    private void showAlert() { // Ayarlara gitme uyarısını göster
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.no_internet_connection));

            builder.setMessage(getString(R.string.connect_internet))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.go_settings), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS)); //Ayarlara git
                        }
                    })
                    .setNegativeButton(getString(R.string.close), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) { // Uygulamayı Kapat
                            finishAffinity();
                            System.exit(0);

                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();
        } catch (Exception e) {

        }
    }


    private void checkConnection()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Helpers.isNetworkConnected(getApplicationContext())) { //interete bağlı mı
                    goListActivity();
                } else {
                    showAlert();
                }
            }
        }, 300);
    }


}
