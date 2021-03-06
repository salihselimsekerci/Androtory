package com.hr190023.salih_selim_sekerci_final.Retrofit;

import com.hr190023.salih_selim_sekerci_final.Util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static OkHttpClient okHttpClient;
    private static Retrofit retrofit;
    ApiInterface serviceApi;

    private static Retrofit getRetrofit() { //retrofit ile ilgili ayarları yap, gönder

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    public ApiInterface getServiceApi() { //endpointleri belirttiğimiz dosyayı ayarlıyoruz

        if (serviceApi == null) {
            serviceApi = getRetrofit().create(ApiInterface.class);
        }

        return serviceApi;
    }


}
