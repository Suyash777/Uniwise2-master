package com.example.uniwise;

public class User {
    public String id;
    public String storemail;
    public String storePswd;
    public String storeusnm;
    public String storePhn;
    public String storeEnroll;

    public User() {
    }

    public String getStoreusnm() { return storeusnm; }

    public String getStorePhn() { return storePhn; }

    public String getStoreEnroll() { return storeEnroll; }

    public String getStoremail() {
        return storemail;
    }

    public String getStorePswd() {
        return storePswd;
    }


    public void setStoremail(String storemail) {
        this.storemail = storemail;
    }

    public void setStorePswd(String storePswd) {
        this.storePswd = storePswd;
    }

    public void setStoreusnm(String storeusnm) { this.storeusnm = storeusnm; }

    public void setStorePhn(String storePhn) { this.storePhn = storePhn; }

    public void setStoreEnroll(String storeEnroll) { this.storeEnroll = storeEnroll; }


    public User(String id, String storemail, String storePswd, String storeusnm, String storePhn, String storeEnroll) {
        this.id = id;
        this.storemail = storemail;
        this.storePswd = storePswd;
        this.storeusnm = storeusnm;
        this.storePhn = storePhn;
        this.storeEnroll = storeEnroll;
    }
}
