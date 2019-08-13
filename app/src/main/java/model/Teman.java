package model;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

import android.os.Parcel;
import android.os.Parcelable;

public class Teman implements Parcelable {
    private String nim, nama, kelas, email, sosmed, telp;


    public Teman(String nim, String nama, String kelas, String email,String sosmed, String telp){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.email = email;
        this.sosmed = sosmed;
        this.telp = telp;
    }
    public Teman(){

    }

    protected Teman(Parcel in){
        nim = in.readString();
        nama = in.readString();
        kelas = in.readString();
        email = in.readString();
        sosmed = in.readString();
        telp = in.readString();
    }

    public static final Creator<Teman> CREATOR = new Creator<Teman>() {
        @Override
        public Teman createFromParcel(Parcel in) {
            return new Teman(in);
        }

        @Override
        public Teman[] newArray(int size) {
            return new Teman[size];
        }
    };


    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.nim);
        dest.writeString(this.nama);
        dest.writeString(this.kelas);
        dest.writeString(this.email);
        dest.writeString(this.sosmed);
        dest.writeString(this.telp);
    }
}
