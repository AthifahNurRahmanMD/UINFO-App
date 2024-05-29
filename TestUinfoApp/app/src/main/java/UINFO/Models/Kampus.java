package UINFO.Models;

public class Kampus {


    public Kampus(int id, String kampus, String alamat, String status) {
        this.id = id;
        this.kampus = kampus;
        this.alamat = alamat;
        this.status = status;
    }

    public Kampus(int id, String kampus, String fakultas, String jurusan, String bkt, String golUKT13, String golUKT46,
            String golUKT78, String alamat, String status, String jalurPendaftaran) {
        this.id = id;
        this.kampus = kampus;
        this.fakultas =  fakultas;
        this.jurusan = jurusan;
        this.bkt = bkt;
        this.golUKT13 = golUKT13;
        this.golUKT46 = golUKT46;
        this.golUKT78 = golUKT78;
        this.alamat = alamat;
        this.status = status;
        this.jalurPendaftaran =  jalurPendaftaran;
    }

    public Kampus(String id, String kampus, String fakultas, String jurusan, String bkt, String golUKT13, String golUKT46,
            String golUKT78, String alamat, String status, String jalurPendaftaran) {
        this.id = Integer.parseInt(id);
        this.kampus = kampus;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
        this.bkt = bkt;
        this.golUKT13 = golUKT13;
        this.golUKT46 = golUKT46;
        this.golUKT78 = golUKT78;
        this.alamat = alamat;
        this.status = status;
        this.jalurPendaftaran = jalurPendaftaran;
    }

    private int id;

    private String kampus;
    private String fakultas;
    private String jurusan;
    private String bkt;
    private String golUKT13;
    private String golUKT46;
    private String golUKT78;
    private String alamat;
    private String status;
    private String jalurPendaftaran;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKampus() {
        return kampus;
    }
    public void setKampus(String kampus) {
        this.kampus = kampus;
    }
    public String getFakultas() {
        return fakultas;
    }
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    public String getJurusan() {
        return jurusan;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    public String getBkt() {
        return bkt;
    }
    public void setBkt(String bkt) {
        this.bkt = bkt;
    }
    public String getGolUKT13() {
        return golUKT13;
    }
    public void setGolUKT13(String golUKT13) {
        this.golUKT13 = golUKT13;
    }
    public String getGolUKT46() {
        return golUKT46;
    }
    public void setGolUKT46(String golUKT46) {
        this.golUKT46 = golUKT46;
    }
    public String getGolUKT78() {
        return golUKT78;
    }
    public void setGolUKT79(String golUKT78) {
        this.golUKT78 = golUKT78;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getJalurPendaftaran() {
        return jalurPendaftaran;
    }

    public void setJalurPendaftaran(String jalurPendaftaran) {
        this.jalurPendaftaran = jalurPendaftaran;
    }


}