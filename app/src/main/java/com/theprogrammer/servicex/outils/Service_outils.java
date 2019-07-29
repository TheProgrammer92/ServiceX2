package com.theprogrammer.servicex.outils;

public class Service_outils {

    private String service_name;
    private String service_info;
    private int service_id;

    public Service_outils(String service_name, String service_info, int service_id) {
        this.service_name = service_name;
        this.service_info = service_info;
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_info() {
        return service_info;
    }

    public void setService_info(String service_info) {
        this.service_info = service_info;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
