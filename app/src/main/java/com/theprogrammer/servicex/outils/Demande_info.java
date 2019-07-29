package com.theprogrammer.servicex.outils;

public class Demande_info {

    private Service_outils service_outils;

    private String id_service;
    private String id_users;
    private String montant;
    private String spinner_select;

    public Demande_info(String id_service, String id_users, String montant, String spinner_select) {
        this.id_service = id_service;
        this.id_users = id_users;
        this.montant = montant;
        this.spinner_select = spinner_select;
    }

    public Service_outils getService_outils() {
        return service_outils;
    }

    public void setService_outils(Service_outils service_outils) {
        this.service_outils = service_outils;
    }

    public String getId_service() {
        return id_service;
    }

    public void setId_service(String id_service) {
        this.id_service = id_service;
    }

    public String getId_users() {
        return id_users;
    }

    public void setId_users(String id_users) {
        this.id_users = id_users;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getSpinner_select() {
        return spinner_select;
    }

    public void setSpinner_select(String spinner_select) {
        this.spinner_select = spinner_select;
    }
}
