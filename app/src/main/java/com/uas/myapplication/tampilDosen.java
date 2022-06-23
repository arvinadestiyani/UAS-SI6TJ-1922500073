package com.uas.myapplication;
import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class tampilDosen {
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String nama_dosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String gol_pang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String program_studi;
    public String ambilNidn(){
        return nidn;
    }
    public String ambilnama_dosen(){
        return nama_dosen;
    }
    public String ambilJabatan(){
        return jabatan;
    }
    public String ambilGol_Pang(){
        return gol_pang;
    }
    public String ambilKeahlian(){
        return keahlian;
    }
    public String ambilProgram_studi(){
        return program_studi;
    }

}
