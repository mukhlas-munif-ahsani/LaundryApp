package com.tiunida.laundry0.FragmentHistory.Model;

public class Model {
    String a_time, a_waktu_selesai;

    String h_accepted2, h_delivered2, h_delivered2Confirm, h_done2, h_on_proses2, h_paid2, h_paid2Confirm, a_price2, a_diskon, a_jenis;

    public Model(){

    }

    public Model(String a_time, String a_waktu_selesai, String h_accepted2, String h_delivered2, String h_delivered2Confirm, String h_done2, String h_on_proses2, String h_paid2, String h_paid2Confirm, String a_price2, String a_diskon, String a_jenis) {
        this.a_time = a_time;
        this.a_waktu_selesai = a_waktu_selesai;
        this.h_accepted2 = h_accepted2;
        this.h_delivered2 = h_delivered2;
        this.h_delivered2Confirm = h_delivered2Confirm;
        this.h_done2 = h_done2;
        this.h_on_proses2 = h_on_proses2;
        this.h_paid2 = h_paid2;
        this.h_paid2Confirm = h_paid2Confirm;
        this.a_price2 = a_price2;
        this.a_diskon = a_diskon;
        this.a_jenis = a_jenis;
    }

    public String getH_delivered2Confirm() {
        return h_delivered2Confirm;
    }

    public String getH_paid2Confirm() {
        return h_paid2Confirm;
    }

    public String getA_jenis() {
        return a_jenis;
    }

    public String getA_diskon() {
        return a_diskon;
    }

    public String getA_price2() {
        return a_price2;
    }

    public String getH_accepted2() {
        return h_accepted2;
    }

    public String getH_delivered2() {
        return h_delivered2;
    }

    public String getH_done2() {
        return h_done2;
    }

    public String getH_on_proses2() {
        return h_on_proses2;
    }

    public String getH_paid2() {
        return h_paid2;
    }

    public String getA_time() {
        return a_time;
    }

    public String getA_waktu_selesai() {
        return a_waktu_selesai;
    }
}
