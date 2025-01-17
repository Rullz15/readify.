package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NovelActivity extends AppCompatActivity {

    private RecyclerView rvNovelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_novel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

        rvNovelList = findViewById(R.id.rvNovelList);
        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Handle tombol kembali
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(NovelActivity.this, TabActivity.class);
            startActivity(intent);
            finish(); // Menutup activity ini
        });

        // Set LayoutManager untuk RecyclerView
        rvNovelList.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom
        rvNovelList.setHasFixedSize(true);

        // Buat daftar novel
        List<Novel> novelList = new ArrayList<>();
        novelList.add(new Novel(
                "Tidak Jatuh Cinta",
                "Rayni N. Massardi & Erby S.\nSeberapa jauhkah gambar menggambarkan tulisan,\natau tulisan mungkin saja menyastrakan gambar?",
                "Rp. 85.000",
                "4.6 (1000 Ulasan)",
                R.drawable.tjc,
                "Cinta yang Berbeda. Berjarak. Demas manusia Bumi. Ia punya usaha jualan pernak-pernik unik futuristik. Tiba-tiba ia kedatangan tamu dari planet luar bernama Karmen. Karmen yang jatuh cinta pada Demas kemudian mengajaknya travelling ke luar angkasa. Sementara Demas merasa kebingungan.\n" +
                        "\n" +
                        "Ia mengira dirinya sedang halu atau tengah bermimpi atau bahkan sudah mati. Karmen ternyata ingin memiliki Demas untuk selamanya, dan mengajaknya tinggal bersama di Planet X. Demas pun sesungguhnya sangat mencintai Karmen. Tapi apa yang dirasakannya tidak seperti “cinta di atas Bumi.”\n" +
                        "\n" +
                        "Karena itulah, Demas kemudian memohon kepada Karmen agar ia segera dipulangkan kembali. Apa dan bagaimana reaksi Karmen? Mungkinkah cinta yang berbeda dan berjarak itu bisa terwujud?"
        ));

        novelList.add(new Novel(
                "Ayahku Bukan Pembohong",
                "TERE LIYE.\nSeberapa jauhkah gambar menggambarkan tulisan,\natau tulisan mungkin saja menyastrakan gambar?",
                "Rp. 90.000",
                "4.8 (1000 Ulasan)",
                R.drawable.ayahku,
                "Cerita tentang perjuangan seorang ayah yang penuh cinta dan kejujuran."
        ));

        novelList.add(new Novel(
                "23:59",
                "BRIAN KHRISNA\nSeberapa jauhkah gambar menggambarkan tulisan,\natau tulisan mungkin saja menyastrakan gambar?",
                "Rp. 90.000",
                "4.8 (1000 Ulasan)",
                R.drawable.n23,
                "Kisah penuh intrik dan misteri menjelang pergantian hari."
        ));

        novelList.add(new Novel(
                "BEK",
                "MAHFUD IKHWAN\nSeberapa jauhkah gambar menggambarkan tulisan,\natau tulisan mungkin saja menyastrakan gambar?",
                "Rp. 90.000",
                "4.8 (1000 Ulasan)",
                R.drawable.bek,
                "Cerita berlatar kehidupan urban dengan pesan sosial yang mendalam."
        ));

        // Update jumlah produk yang ditampilkan
        tvJmlProduk.setText(novelList.size() + " Produk Ditampilkan");

        // Atur Adapter ke RecyclerView
        NovelAdapter adapter = new NovelAdapter(this, novelList);
        rvNovelList.setAdapter(adapter);
    }
}
