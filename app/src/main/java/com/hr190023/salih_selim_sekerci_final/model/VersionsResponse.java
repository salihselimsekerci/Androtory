package com.hr190023.salih_selim_sekerci_final.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VersionsResponse {
    //Dönen response içinden versions objesini alıyoruz
    @SerializedName("versions")
    @Expose
    private List<AndroidVersion> androidVersions;


    public List<AndroidVersion> getAndroidVersions() {
        return androidVersions;
    }

    public void setAndroidVersions(List<AndroidVersion> androidVersions) {
        this.androidVersions = androidVersions;
    }
}
