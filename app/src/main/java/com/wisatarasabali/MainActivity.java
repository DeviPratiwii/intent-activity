package com.wisatarasabali;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recViewKuliner;

    //
    private ArrayList<Masakan> listMasakan;

    private MasakanAdapter.RVMasakanListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recViewKuliner=findViewById(R.id.RecyclerViewMasakan);

        isiData();
        setOnClickListener();

        recViewKuliner.setAdapter(new MasakanAdapter(listMasakan,listener));
        recViewKuliner.setLayoutManager(new LinearLayoutManager(this));

    }
    private void setOnClickListener() {
        listener= new MasakanAdapter.RVMasakanListener() {
            @Override
            public void onClick(View views, int position) {
                //mengirimkan data lewat intent
                Intent intent = new Intent(getApplicationContext(), detail_masakan.class);
                intent.putExtra("namaMasakan", listMasakan.get(position).getNamaMasakan());
                intent.putExtra("deskripsi", listMasakan.get(position).getDescMasakan());
                intent.putExtra("harga", listMasakan.get(position).getHargaMasakan());
                intent.putExtra("gambar_id",listMasakan.get(position).getIdPhoto());
                startActivity(intent);
            }
        };
    }

    private void isiData(){
        this.listMasakan=new ArrayList<>();
        //
        listMasakan.add(new Masakan(
                "Ayam Betutu",
                "Ayam Betutu adalah ayam yang dimasak dengan rempah-rempah " +
                        "dan bumbu khas Bali. Ayam ini dimasak dalam waktu yang lama hingga " +
                        "rempah-rempah meresap ke dalam daging, " +
                        "memberikan cita rasa yang khas dan lezat.",
                "Rp50.000/ekor",
                R.drawable.ayam_betutu
        ));

        listMasakan.add(new Masakan(
                "Lawar",
                "Lawar adalah hidangan Bali yang terdiri dari daging cincang " +
                        "(biasanya babi atau ayam) yang dicampur dengan kelapa parut, " +
                        "rempah-rempah, dan bumbu khas Bali." +
                        "Lawar memiliki rasa yang kompleks dan biasanya disajikan" +
                        "sebagai lauk pauk.",
                "Rp15.000",
                R.drawable.lawar_bali
        ));

        listMasakan.add(new Masakan(
                "Tipat Blayag",
                "Tipat Blayag merupakan makanan khas Bali dari Buleleng, " +
                        "berupa ketupat yang dibuat menggunakan daun enau atau daun aren," +
                        "disajikan dengan urap, suwiran ayam, telur rebus, dan lainnya serta " +
                        "disiram dengan kuah yang khas.",
                "Rp15.000",
                R.drawable.tipat_blayag
        ));

        listMasakan.add(new Masakan(
                "Rujak Kuah Pindang",
                "Rujak Kuah Pindang ini memang unik karena tidak disajikan dengan " +
                        "bumbu rujak biasa, melainkan dengan kuah pindang ikan tuna " +
                        "yang dibuat pedas. Isiannya pun seperti rujak biasanya, seperti " +
                        "irisan mangga muda atau buah lainnya.",
                "Rp7.000",
                R.drawable.rujak_kuahpindang
        ));

        listMasakan.add(new Masakan(
                "Serombotan",
                "Serombotan, makanan khas Bali yang cocok untuk vegetarian, " +
                        "terdiri dari beragam sayuran seperti kacang panjang, bayam, kangkung, " +
                        "dan terong bulat. Dibumbui dengan bumbu kacang yang lezat",
                "Rp5.000",
                R.drawable.serombotan_bali
        ));

        listMasakan.add(new Masakan(
                "Sate Lilit",
                "Sate Lilit adalah sate tradisional Bali yang terbuat dari " +
                        "daging cincang yang dibungkus di sekitar lidi serai atau bambu, " +
                        "kemudian dipanggang.",
                "Rp10.000/porsi",
                R.drawable.sate_lilit
        ));

        listMasakan.add(new Masakan(
                "Babi Guling",
                "\n" +
                        "Babi Guling adalah hidangan dengan kulit babi yang renyah, dan dagingnya " +
                        "empuk dengan cita rasa yang kaya",
                "Rp35.000/porsi",
                R.drawable.babi_guling
        ));
    }
}