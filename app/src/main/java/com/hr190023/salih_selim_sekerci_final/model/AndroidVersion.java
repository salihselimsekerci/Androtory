package com.hr190023.salih_selim_sekerci_final.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AndroidVersion implements Serializable {
    //Versiyonlar için model dosyası
    @SerializedName("name")
    private String name;

    @SerializedName("version")
    private String version;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("text")
    private String text;

    @SerializedName("logo_url")
    private String logoUrl;

    @SerializedName("img_url")
    private String imgUrl;

    public AndroidVersion() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
