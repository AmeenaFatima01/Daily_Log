package com.example.daily_log;

public class Student {
    private String Date;
    private String Salah;
    private boolean Jammat;
    private String rakat;
    private boolean Tahajud;

    public Student(String Date, String Salah, boolean jammat,String rakat,boolean tahajud) {
        this.Date = Date;
        this.Salah = Salah;
        this.Jammat = jammat;
        this.rakat=rakat;
        this.Tahajud=tahajud;
    }

    public void setDate(String date) {
        this.Date = date;
    }
    public void setRakat(String rakat) {
        this.rakat = rakat;
    }
    public void setSalah(String Salah) {
        this.Salah = Salah;
    }
    public String getSalah() {
        return Salah;
    }
    public String getDate() {
        return Date;
    }
    public String getRakat() {
        return rakat;
    }
    public boolean isJammat() {
        return Jammat;
    }
    public boolean isTahajud() {
        return Tahajud;
    }
    public void setJammat(boolean jammat) {
         Jammat = jammat;
    }
    public void setTahajud(boolean tahajud) {
        Tahajud = tahajud;
    }
    public String toString() {
        return "Student [Date=" + Date + ", Salah=" + Salah + ", Jammat=" + Jammat +", Rakat=" + rakat + ", Tahajud=" + Tahajud +"]";
    }
}

