package com.hr190023.salih_selim_sekerci_final.Retrofit;


import com.hr190023.salih_selim_sekerci_final.Model.VersionsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    //hangi endpoint hangi fonksiyon onu ayarlıyoruz

    @GET("versions.json")
    Observable<VersionsResponse> getVersions();

}
