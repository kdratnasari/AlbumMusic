package com.ratnasari.example.albummusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private ArrayList<String> NamaAlbum = new ArrayList<>();
    private ArrayList<String> NamaPenyanyi = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailAlbum = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();

        if (savedInstanceState == null) {
            setActionBarTitle("Music Album");
            showRecyleList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            setMode(stateMode);
        }
    }

    private void initImageBitmaps() {
        LinkGambar.add("https://www.warningmagz.com/wp-content/uploads/2016/08/Tulus.jpg");
        NamaAlbum.add("Monokrom");
        NamaPenyanyi.add("Album Musik Muhammad Tulus");
        DetailAlbum.add("Monokrom adalah album ketiga dari penyanyi Tulus. Album ini diliris pada tanggal 3 Agustus 2016. " +
                "1.\t\"Manusia Kuat\"  \t3:05\n" +
                "2.\t\"Pamit\"  \t3:53\n" +
                "3.\t\"Ruang Sendiri\"  \t4:29\n" +
                "4.\t\"Tukar Jiwa\"  \t3:50\n" +
                "5.\t\"Tergila-gila\"  \t3:52\n" +
                "6.\t\"Cahaya\"  \t3:16\n" +
                "7.\t\"Langit Abu-abu\"  \t3:23\n" +
                "8.\t\"Mahakarya\"  \t3:00\n" +
                "9.\t\"Lekas\"  \t3:14\n" +
                "10.\t\"Monokrom\"  \t3:35\n");

        LinkGambar.add("https://upload.wikimedia.org/wikipedia/id/a/a7/Raisa_handmade.jpeg");
        NamaAlbum.add("Handmade");
        NamaPenyanyi.add("Album Musik Raisa Andriana");
        DetailAlbum.add("Handmade adalah album ketiga oleh penyanyi Indonesia, Raisa. Album ini dirilis pada 20 April 2016 oleh Juni Records." +
                "1.\t\"Intro - Handmade\"  \t1:25\n" +
                "2.\t\"Kali Kedua\"  \t4:17\n" +
                "3.\t\"Percayalah\" (menampilkan Afgan)\t4:24\n" +
                "4.\t\"Sang Rembulan\"  \t3:49\n" +
                "5.\t\"Tentang Cinta\"  \t3:52\n" +
                "6.\t\"Jatuh Hati\"  \t3:27\n" +
                "7.\t\"Letting You Go\"  \t4:35\n" +
                "8.\t\"Usai di Sini\"  \t4:43\n" +
                "9.\t\"Love You Longer\"  \t3:15\n" +
                "10.\t\"Biarkanlah\"  \t3:47\n" +
                "11.\t\"Nyawa dan Harapan\"  \t4:48");

        LinkGambar.add("https://ecs7.tokopedia.net/img/cache/700/product-1/2017/9/1/0/0_bdf97dbf-871d-4c17-9b5d-3e305f8330ae_720_720.jpg");
        NamaAlbum.add("Paradox");
        NamaPenyanyi.add("Album Musik Isyana Saraswati");
        DetailAlbum.add("Paradox merupakan album musik kedua karya Isyana Sarasvati. Dirilis pada 1 September 2017." +
                "1.\t\"Echo\"  \t•\t\t3:27\n" +
                "2.\t\"Terpesona\"  \t3:18\n" +
                "3.\t\"Nada Cinta\"  \t3:44\n" +
                "4.\t\"Lembaran Buku\"  \t4:26\n" +
                "5.\t\"Mad\"  \t3:38\n" +
                "6.\t\"Anganku Anganmu\" \4:30\n" +
                "7.\t\"Winter Song\"  \t3:21\n" +
                "8.\t\"That's It, I'm Done\"  \t3:03\n" +
                "9.\t\"Sekali Lagi\" \4:37\n" +
                "10.\t\"Gelora\"  \t3:18\n");

        LinkGambar.add("https://i1.wp.com/www.trinityproduction.com/wp-content/uploads/2018/03/Afgan-Dekade_Itunes-Cover.jpg?resize=762%2C762");
        NamaAlbum.add("Dekade");
        NamaPenyanyi.add("Album Musik Afgan Syahreza");
        DetailAlbum.add("Dekade merupakan sebuah album studio kelima karya Afgan. Dirilis pada tahun 2018." +
                "1.\t\"Love Again\"  \n" +
                "2.\t\"Sudah\"  \n" +
                "3.\t\"Heaven\" (feat. Isyana Sarasvati dan Rendy Pandugo)\n" +
                "4.\t\"Take Me Back\" (feat. Ramengvrl)\n" +
                "5.\t\"Sadis\" (Dekade version)\n" +
                "6.\t\"Bukan Cinta Biasa\" (Dekade version)\n" +
                "7.\t\"Bawalah Cintaku\" (feat. Sheila Majid)\n" +
                "8.\t\"Knock Me Out\"  \n" +
                "9.\t\"Kunci Hati\"  \n" +
                "10.\t\"Percayalah\" (feat. Raisa)\n" +
                "11.\t\"Panah Asmara\"  \n" +
                "12.\t\"Setia Menunggu\"  \n" +
                "13.\t\"Kamu Yang Kutunggu\" (feat. Rossa)\n" +
                "14.\t\"Jodoh Pasti Bertemu\"  \n");

        LinkGambar.add("https://t2.genius.com/unsafe/593x0/https%3A%2F%2Fimages.genius.com%2Fec6a6b4e1b537d47ac72cd79e79673f1.640x640x1.jpg");
        NamaAlbum.add("Oxygen");
        NamaPenyanyi.add("Album Musik Maudy Ayunda");
        DetailAlbum.add("Oxygen merupakan sebuah album dari Maudy Ayunda. Dirilis pada tahun 15 Februari 2018" +
                "\"1.\\t\\\"Kini dan Selamanya\\\"  \\t3:17\\n\" +\n" +
                "\"2.\\t\\\"Aku Sedang Mencintaimu\\\"  \\t4:10\\n\" +\n" +
                "\"3.\\t\\\"Oxygen\\\"  \\t3:38\\n\" +\n" +
                "\"4.\\t\\\"Home To You\\\"  \\t4:16\\n\" +\n" +
                "\"5.\\t\\\"Kutunggu Kabarmu\\\"  \\t4:00\\n\" +\n" +
                "\"6.\\t\\\"Masih\\\"  \\t3:45\\n\" +\n" +
                "\"7.\\t\\\"We Don’t\\\"  \\t4:16\\n\" +\n" +
                "\"8.\\t\\\"Alasan Untuk Bahagia\\\"  \\t3:41\\n\" +\n" +
                "\"9.\\t\\\"Jakarta Ramai\\\"  \\t4:30\\n\");\n");

        LinkGambar.add("https://2.bp.blogspot.com/-yjGgZverS2c/W6UxMQM66WI/AAAAAAAAEBo/J0WeKSxgJ1U2o8-XJ8NMr-WM9RDzZ-bpgCLcBGAs/s1600/sherina-tuna.jpg");
        NamaAlbum.add("Tuna");
        NamaPenyanyi.add("Album Musik Sherina Munaf");
        DetailAlbum.add("Tuna merupakan album musik ketiga karya Sherina Munaf. Dirilis pada tahun 2013. Lagu utamanya di album ini ialah Sebelum Selamanya." +
                "1.\t\"Sebelum Selamanya\"  \t4:55\n" +
                "2.\t\"Demi Kamu dan Aku\" (feat Afgan)\t4:13\n" +
                "3.\t\"Ada\"  \t4:38\n" +
                "4.\t\"Akan Ku Tunggu\"  \t4:10\n" +
                "5.\t\"Tak Usah Cemburu\"  \t3:45\n" +
                "6.\t\"Apakah Ku Jatuh Cinta\" (feat Vidi Aldiano)\t3:30\n" +
                "7.\t\"Impian Kecil\"  \t4:09\n" +
                "8.\t\"Sing Your Mind\"  \t4:32");

        LinkGambar.add("https://t2.genius.com/unsafe/220x220/https%3A%2F%2Fimages.genius.com%2Feaf6d7b52945910f81675729b2cd8130.640x640x1.jpg");
        NamaAlbum.add("Kereta Kencan");
        NamaPenyanyi.add("Album Musik HIVI!");
        DetailAlbum.add("Kereta Kencan adalah album kedua dari grup vokal HiVi!. Album ini diliris pada tanggal 23 Februari 2017." +
                "1.\t\"Intro\"  \t0:32\n" +
                "2.\t\"Merakit Perahu\"  \t3:37\n" +
                "3.\t\"Sama-Sama Tahu\"  \t3:46\n" +
                "4.\t\"Gadis Sampul\"  \t3:41\n" +
                "5.\t\"Apa Adanya\"  \t3:10\n" +
                "6.\t\"Remaja\"  \t3:38\n" +
                "7.\t\"Pelangi\"  \t3:37\n" +
                "8.\t\"Kereta Kencan\"  \t4:17\n" +
                "9.\t\"Siapkah Kau 'Tuk Jatuh Cinta Lagi (menampilkan Andi Rianto)\"  \t5:28\n" +
                "10.\t\"Mata Ke Hati (Acoustic Version)\"  \t3:24");

        showRecyleList();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, NamaAlbum, LinkGambar, NamaPenyanyi, DetailAlbum);
        recyclerView.setAdapter(adapter);
    }

    private void showRecyleList() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListActivity adapter = new ListActivity(this, NamaAlbum, LinkGambar, NamaPenyanyi, DetailAlbum);
        recyclerView.setAdapter(adapter);

    }

    private void showRecyclerGrid() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridActivity adapter = new GridActivity(this, NamaAlbum, LinkGambar, NamaPenyanyi, DetailAlbum);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyleList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                initRecyclerView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }

}
