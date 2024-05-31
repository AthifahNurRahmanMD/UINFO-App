package UINFO.Models;

public class Kampus {

    private int id;
    private String kampus;
    private String fakultas;
    private String jurusan;
    private String biayaPangkal;
    private String biayaKuliahTunggal;
    private String golUKT13;
    private String golUKT46;
    private String golUKT78;
    private String alamat;
    private String status;
    private String biayaPendaftaran;
    private String jalurPendaftaran;
    
    // Constructors, getters, and setters

    public Kampus(int id, String kampus, String alamat, String status) {
        this.id = id;
        this.kampus = kampus;
        this.alamat = alamat;
        this.status = status;
    }

    // Constructor untuk biaya tunggal dan pangkal
    public Kampus(int id, String kampus, String fakultas, String jurusan, String biayaPangkal, String biayaKuliahTunggal, String golUKT13, String golUKT46, String golUKT78, String alamat, String status,String biayaPendaftaran, String jalurPendaftaran) {
        // Inisialisasi properti
        this.id = id;
        this.kampus = kampus;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
        this.biayaPangkal = biayaPangkal;
        this.biayaKuliahTunggal = biayaKuliahTunggal;
        this.golUKT13 = golUKT13;
        this.golUKT46 = golUKT46;
        this.golUKT78 = golUKT78;
        this.alamat = alamat;
        this.status = status;
        this.biayaPendaftaran = biayaPendaftaran;
        this.jalurPendaftaran = jalurPendaftaran;
    }

    public Kampus(String id, String kampus, String fakultas, String jurusan, String biaya, String golUKT13, String golUKT46,
            String golUKT78, String alamat, String status, String jalurPendaftaran) {
        this.id = Integer.parseInt(id);
        this.kampus = kampus;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
        this.golUKT13 = golUKT13;
        this.golUKT46 = golUKT46;
        this.golUKT78 = golUKT78;
        this.alamat = alamat;
        this.status = status;
        this.jalurPendaftaran = jalurPendaftaran;
    }
    
    public String getBiayaPendaftaran() {
        return biayaPendaftaran;
    }
    public void setBiayaPendaftaran(String biayaPendaftaran) {
        this.biayaPendaftaran = biayaPendaftaran;
    }
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
    // Getter dan setter untuk biaya pangkal
    public String getBiayaPangkal() {
        return biayaPangkal;
    }

    public void setBiayaPangkal(String biayaPangkal) {
        this.biayaPangkal = biayaPangkal;
    }

    // Getter dan setter untuk biaya kuliah tunggal
    public String getBiayaKuliahTunggal() {
        return biayaKuliahTunggal;
    }

    public void setBiayaKuliahTunggal(String biayaKuliahTunggal) {
        this.biayaKuliahTunggal = biayaKuliahTunggal;
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
    public void setGolUKT78(String golUKT78) {
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