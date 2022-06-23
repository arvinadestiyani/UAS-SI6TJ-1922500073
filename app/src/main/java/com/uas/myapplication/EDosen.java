package com.uas.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import java.util.HashMap;
public class EDosen extends AppCompatActivity {
    private EditText Entrynidn,Entrynama_dosen,Entryjabatan,Entrygol_pang,Entrykeahlian,Entryprodi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edosen);

        Entrynidn = (EditText) findViewById(R.id.txtnidn);
        Entrynama_dosen = (EditText) findViewById(R.id.txtNmDosen);
        Entryjabatan = (EditText) findViewById(R.id.txtJabatan);
        Entrygol_pang = (EditText) findViewById(R.id.txtGolPang);
        Entrykeahlian = (EditText) findViewById(R.id.txtKeahlian);
        Entryprodi = (EditText) findViewById(R.id.txtProdi);
    }

    public void tambahData(View View){
        final String nidn = Entrynidn.getText().toString().trim();
        final String nama_dosen = Entrynama_dosen.getText().toString().trim();
        final String jabatan = Entryjabatan.getText().toString().trim();
        final String gol_pang = Entrygol_pang.getText().toString().trim();
        final String keahlian = Entrykeahlian.getText().toString().trim();
        final String program_studi = Entryprodi.getText().toString().trim();

        class tambahdtDosen extends AsyncTask<Void, Void, String>{
            ProgressDialog load;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                load = ProgressDialog.show(
                        EDosen.this, "Add...","Wait...",false,false );
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put("nidn",nidn);
                params.put("nama_dosen",nama_dosen);
                params.put("jabatan", jabatan);
                params.put("gol_pang",gol_pang);
                params.put("keahlian",keahlian);
                params.put("program_studi",program_studi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.100.8/api_uas_mobtech/tambah.php",params);
                return res;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                load.dismiss();
                Toast.makeText(EDosen.this,s,Toast.LENGTH_LONG).show();
            }
        }
        tambahdtDosen TmbhDosen = new tambahdtDosen();
        TmbhDosen.execute();
    }
}