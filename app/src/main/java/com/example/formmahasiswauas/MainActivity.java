package com.example.formmahasiswauas;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSimpan, btnLihatData;
    EditText nim, nama, tempatLahir, tanggalLahir, nilaiTugas, nilaiUTS, nilaiUAS;
    TextView thasil;
    RadioGroup rgjk;
    Spinner spinnerKelas, spinnerAgama;

    DBHelper dbHelper;
    ModelMahasiswa mhs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inisialisasi
        btnSimpan = (Button) findViewById(R.id.simpan);
        btnLihatData = (Button) findViewById(R.id.btn_data);
        nim = (EditText) findViewById(R.id.nim);
        nama = (EditText) findViewById(R.id.nama);
        thasil = (TextView) findViewById(R.id.hasil);
        rgjk = (RadioGroup) findViewById(R.id.jk);
        spinnerKelas = (Spinner) findViewById(R.id.kelas);
        spinnerAgama = (Spinner) findViewById(R.id.agama);
        tempatLahir = (EditText) findViewById(R.id.tempatlahir);
        tanggalLahir = (EditText) findViewById(R.id.tanggallahir);
        nilaiTugas = (EditText) findViewById(R.id.nTugas);
        nilaiUTS = (EditText) findViewById(R.id.nUTS);
        nilaiUAS = (EditText) findViewById(R.id.nUAS);


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nimText = String.valueOf(nim.getText().toString());
                String namaText = String.valueOf(nama.getText().toString());
                String tempatLahirText = String.valueOf(tempatLahir.getText().toString());
                String tanggalLahirText = String.valueOf(tanggalLahir.getText().toString());

                int gender = rgjk.getCheckedRadioButtonId();
                RadioButton jk = (RadioButton) findViewById(gender);
                String jkText = String.valueOf(jk.getText().toString());
                int tugas = Integer.parseInt(nilaiTugas.getText().toString());
                int uts = Integer.parseInt(nilaiUTS.getText().toString());
                int uas = Integer.parseInt(nilaiUAS.getText().toString());
                String grade = "";
                int total = tugas + uts + uas;
                int nRata = total / 3;
                if (nRata > 80) {
                    grade = "A";
                } else if (nRata > 70) {
                    grade = "B";
                } else if (nRata > 60) {
                    grade = "C";
                } else if (nRata > 50) {
                    grade = "D";
                } else {
                    grade = "E";
                }

//                String stringTeks =
//                        "NIM  : " + nimText + "\n" +
//                        "Nama : " + namaText + "\n" +
//                        "Jenis Kelamin : " + jkText + "\n"+
//                        "Kelas : " + spinnerKelas.getSelectedItem().toString() + "\n"+
//                        "Agama : " + spinnerAgama.getSelectedItem().toString() + "\n"+
//                        "Tempat Lahir    : " + tempatLahirText + "\n"+
//                        "Tanggal Lahir   : " + tanggalLahirText + "\n" +
//                        "Nilai Tugas     : " + tugas + "\n"+
//                        "Nilai UTS       : " + uts + "\n" +
//                        "Nilai UAS       : " + uas + "\n" +
//                        "Total Nilai     : " + total + "\n"+
//                        "Nilai Rata Rata :  " + nRata + "\n" +
//                        "Grade           : " + grade + "\n" +
//                         "======================================";
//                thasil.setText(stringTeks);

                dbHelper = new DBHelper(getApplicationContext());
                mhs = new ModelMahasiswa(
                        1,
                        nimText,
                        namaText,
                        jkText,
                        spinnerKelas.getSelectedItem().toString(),
                        spinnerAgama.getSelectedItem().toString(),
                        tempatLahirText,
                        tanggalLahirText,
                        tugas,
                        uts,
                        uas,
                        total,
                        nRata,
                        grade
                );

                dbHelper.addRecord(mhs);

                Toast.makeText(MainActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                nama.setText(null);
                nim.setText(null);
                thasil.setText(null);
                tempatLahir.setText(null);
                tanggalLahir.setText(null);
                nilaiTugas.setText(null);
                nilaiUTS.setText(null);
                nilaiUAS.setText(null);
            }

        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);
            }
        });
    }


}
