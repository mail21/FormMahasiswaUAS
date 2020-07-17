package com.example.formmahasiswauas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Deskripsi extends AppCompatActivity {

    TextView tvDes;
    DBHelper dbHelper;

    String deskripsi;
    Button btnDel;
    ModelMahasiswa mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        tvDes = findViewById(R.id.tv_deskrispsi);
        btnDel = findViewById(R.id.btn_delete);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

        dbHelper = new DBHelper(getApplicationContext());
        mhs = dbHelper.getRecord(id);

        deskripsi =
                        "NIM  : " + mhs.getNim() + "\n" +
                        "Nama : " + mhs.getNama() + "\n" +
                        "Jenis Kelamin : " + mhs.getJenisKelamin() + "\n"+
                        "Kelas : " + mhs.getKelas() + "\n"+
                        "Agama : " + mhs.getAgama() + "\n"+
                        "Tempat Lahir    : " + mhs.getTempatLahir() + "\n"+
                        "Tanggal Lahir   : " + mhs.getTanggalLahir() + "\n" +
                        "Nilai Tugas     : " + mhs.getNilaiTugas() + "\n"+
                        "Nilai UTS       : " + mhs.getNilaiUts() + "\n" +
                        "Nilai UAS       : " + mhs.getNilaiUas() + "\n" +
                        "Total Nilai     : " + mhs.getTotalNilai() + "\n"+
                        "Nilai Rata Rata :  " + mhs.getRerata() + "\n" +
                        "Grade           : " + mhs.getGrade() + "\n" +
                         "======================================";

        tvDes.setText(deskripsi);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                dbHelper.deleteModel(mhs);
                Toast.makeText(getApplicationContext(), "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                finish();
                startActivity(intent);
            }
        });


    }
}
