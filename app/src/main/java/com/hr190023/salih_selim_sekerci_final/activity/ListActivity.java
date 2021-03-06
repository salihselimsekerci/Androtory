package com.hr190023.salih_selim_sekerci_final.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190023.salih_selim_sekerci_final.Adapter.VersionAdapter;
import com.hr190023.salih_selim_sekerci_final.Model.AndroidVersion;
import com.hr190023.salih_selim_sekerci_final.Model.VersionsResponse;
import com.hr190023.salih_selim_sekerci_final.R;
import com.hr190023.salih_selim_sekerci_final.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getVersions();

    }

    void getVersions() { //Versiyonları al
        final ProgressDialog progressDialog = new ProgressDialog(this); //Veriler gelene kadar bekleme diyaloğu

        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);



        new ApiClient().getServiceApi().getVersions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VersionsResponse>() {
                    List<AndroidVersion> versions = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("Retrofit", "onSubscribe");
                        progressDialog.show();
                    }

                    @Override
                    public void onNext(VersionsResponse versionsResponse) {
                        versions = versionsResponse.getAndroidVersions(); //gelen verileri al
                        Log.i("Retrofit", "onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Retrofit", "onError"+e.getMessage()); //hata gelirse log at
                        if (progressDialog != null && progressDialog.isShowing()) { // lütfen bekleyiniz diyaloğunu kapat
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Retrofit", "onComplete");
                        if (versions.size() > 0)
                            initRecycleView(versions); // gelen veriler ile recyle hazırla

                        if (progressDialog != null && progressDialog.isShowing()) {  // lütfen bekleyiniz diyaloğunu kapat
                            progressDialog.dismiss();

                        }

                    }
                });
    }

    private void initRecycleView(List<AndroidVersion> versions) {
        //recyleview datasını vb ayarla
        recyclerView = findViewById(R.id.rvVersions);
        VersionAdapter versionAdapter = new VersionAdapter(versions, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(versionAdapter);
    }

    private void cikisDiyaloguGoster(){
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.exit));

            builder.setMessage(getString(R.string.exit_sure))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss(); //diyaloğu kapat
                        }
                    })
                    .setNegativeButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) { // çıkış yap
                            finishAffinity();
                            System.exit(0);

                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();
        } catch (Exception e) {

        }
    }


    @Override
    public void onBackPressed() { //geri tuşu

        cikisDiyaloguGoster();

    }

}
