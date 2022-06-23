package com.uas.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public TextView TampilHasil;
    private BarangJsonPlaceHolderAPI jsonPlaceHolderAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TampilHasil = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.8/api_uas_mobtech/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(BarangJsonPlaceHolderAPI.class);
        getPosts();
    }
    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        Call<List<tampilDosen>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<tampilDosen>>() {
            @Override
            public void onResponse(Call<List<tampilDosen>> call, Response<List<tampilDosen>> response){
                if(!response.isSuccessful()){
                    TampilHasil.setText("code: "+ response.code());
                    return;
                }
                List<tampilDosen> posts = response.body();
                for (tampilDosen post:posts){
                    String content = "";
                    content += "NIDN: " +post.ambilNidn() + "\n";
                    content += "NAMA_DOSEN: " +post.ambilnama_dosen() + "\n";
                    content += "JABATAN: " +post.ambilJabatan() + "\n";
                    content += "GOL_PANG: " +post.ambilGol_Pang() + "\n";
                    content += "KEAHLIAN: " +post.ambilKeahlian() + "\n";
                    content += "PRODI: " +post.ambilProgram_studi() + "\n\n";
                    TampilHasil.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<tampilDosen>> call, Throwable t){
                TampilHasil.setText(t.getMessage());
            }
        });
    }

    public void tambah(View View){
        Intent i = new Intent(MainActivity.this,EDosen.class);
        startActivity(i);
    }

}