package com.example.formmahasiswauas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "data";
    public static final String TB_NAME = "tb_mahasiswa";
    public static final String ID = "id";
    public static final String NIM = "nim";
    public static final String NAMA = "nama";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String KELAS = "kelas";
    public static final String AGAMA = "agama";
    public static final String TEMPAT_LAHIR = "tempat_lahir";
    public static final String TANGGAL_LAHIR = "tanggal_lahir";
    public static final String TUGAS = "tugas";
    public static final String UTS = "uts";
    public static final String UAS = "uas";
    public static final String TOTAL = "total";
    public static final String RERATA = "rerata";
    public static final String GRADE = "grade";
    public static final String CREATE_TB = "CREATE TABLE tb_mahasiswa(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nim TEXT NOT NULL, " +
            "nama TEXT NOT NULL, " +
            "jenis_kelamin TEXT NOT NULL," +
            "kelas TEXT NOT NULL," +
            "agama TEXT NOT NULL," +
            "tempat_lahir TEXT NOT NULL," +
            "tanggal_lahir TEXT NOT NULL," +
            "tugas TEXT NOT NULL," +
            "uts TEXT NOT NULL," +
            "uas TEXT NOT NULL," +
            "total TEXT NOT NULL," +
            "rerata TEXT NOT NULL," +
            "grade TEXT NOT NULL)";

    public DBHelper(@androidx.annotation.Nullable Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(CREATE_TB);

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }

    public void addRecord(ModelMahasiswa mhs){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NIM, mhs.getNim());
        values.put(NAMA, mhs.getNama());
        values.put(JENIS_KELAMIN, mhs.getJenisKelamin());
        values.put(KELAS, mhs.getKelas());
        values.put(AGAMA, mhs.getAgama());
        values.put(TEMPAT_LAHIR, mhs.getTempatLahir());
        values.put(TANGGAL_LAHIR, mhs.getTanggalLahir());
        values.put(TUGAS, mhs.getNilaiTugas());
        values.put(UTS, mhs.getNilaiUts());
        values.put(UAS, mhs.getNilaiUas());
        values.put(TOTAL, mhs.getTotalNilai());
        values.put(RERATA, mhs.getRerata());
        values.put(GRADE, mhs.getGrade());

        db.insert(TB_NAME, null, values);
        db.close();
    }

    public ModelMahasiswa getRecord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TB_NAME, new String[] {
                        ID,
                        NIM,
                        NAMA,
                        JENIS_KELAMIN,
                        KELAS,
                        AGAMA,
                        TEMPAT_LAHIR,
                        TANGGAL_LAHIR,
                        TUGAS,
                        UTS,
                        UAS,
                        TOTAL,
                        RERATA,
                        GRADE
                }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelMahasiswa mhs = new ModelMahasiswa(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                Integer.parseInt(cursor.getString(8)),
                Integer.parseInt(cursor.getString(9)),
                Integer.parseInt(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)),
                Integer.parseInt(cursor.getString(12)),
                cursor.getString(13)
                );
        // return contact
        return mhs;
    }

    // get All Record
    public ArrayList<ModelMahasiswa> getAllRecord() {
        ArrayList<ModelMahasiswa> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelMahasiswa userModels = new ModelMahasiswa(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        Integer.parseInt(cursor.getString(8)),
                        Integer.parseInt(cursor.getString(9)),
                        Integer.parseInt(cursor.getString(10)),
                        Integer.parseInt(cursor.getString(11)),
                        Integer.parseInt(cursor.getString(12)),
                        cursor.getString(13)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    //jumlah data
    public int getUserModelCount() {
        String countQuery = "SELECT  * FROM " + TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    //update
    public int updateContact(ModelMahasiswa mhs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NIM, mhs.getNim());
        values.put(NAMA, mhs.getNama());
        values.put(JENIS_KELAMIN, mhs.getJenisKelamin());
        values.put(KELAS, mhs.getKelas());
        values.put(AGAMA, mhs.getAgama());
        values.put(TEMPAT_LAHIR, mhs.getTempatLahir());
        values.put(TANGGAL_LAHIR, mhs.getTanggalLahir());
        values.put(TUGAS, mhs.getNilaiTugas());
        values.put(UTS, mhs.getNilaiUts());
        values.put(UAS, mhs.getNilaiUas());
        values.put(TOTAL, mhs.getTotalNilai());
        values.put(RERATA, mhs.getRerata());
        values.put(GRADE, mhs.getGrade());

        // updating row
        return db.update(TB_NAME, values, ID + " = ?",
                new String[] { String.valueOf(mhs.getId()) });
    }

    public void deleteModel(ModelMahasiswa mhs) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_NAME, ID + " = ?",
                new String[] { String.valueOf(mhs.getId()) });
        db.close();
    }

}