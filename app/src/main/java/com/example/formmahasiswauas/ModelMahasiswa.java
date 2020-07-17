package com.example.formmahasiswauas;

public class ModelMahasiswa {

    private int id;
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String kelas;
    private String agama;
    private String tempatLahir;
    private String tanggalLahir;
    private int nilaiTugas;
    private int nilaiUts;
    private int nilaiUas;
    private int totalNilai;
    private int rerata;
    private String grade;

    public ModelMahasiswa(int id, String nim, String nama, String jenisKelamin, String kelas, String agama, String tempatLahir, String tanggalLahir, int nilaiTugas, int nilaiUts, int nilaiUas, int totalNilai, int rerata, String grade) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.kelas = kelas;
        this.agama = agama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
        this.totalNilai = totalNilai;
        this.rerata = rerata;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getKelas() {
        return kelas;
    }

    public String getAgama() {
        return agama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public int getNilaiTugas() {
        return nilaiTugas;
    }

    public int getNilaiUts() {
        return nilaiUts;
    }

    public int getNilaiUas() {
        return nilaiUas;
    }

    public int getTotalNilai() {
        return totalNilai;
    }

    public int getRerata() {
        return rerata;
    }

    public String getGrade() {
        return grade;
    }
}
