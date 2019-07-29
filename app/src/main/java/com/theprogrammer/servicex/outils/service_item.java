package com.theprogrammer.servicex.outils;

public class service_item {

    int background;
    String name_service;
    int profile_photo;


    public service_item(int fond1, String service, int black_gradient, int i) {


    }
    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public int getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(int profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getInfo_service() {
        return info_service;
    }

    public void setInfo_service(String info_service) {
        this.info_service = info_service;
    }

    String info_service;
}
