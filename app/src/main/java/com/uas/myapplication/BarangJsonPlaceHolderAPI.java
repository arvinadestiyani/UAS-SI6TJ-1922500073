package com.uas.myapplication;

import java.util.List;
        import retrofit2.http.GET;
        import java.util.Map;
        import retrofit2.Call;
        import retrofit2.http.QueryMap;
public interface BarangJsonPlaceHolderAPI {
    @GET("campuss.php")
    Call<List<tampilDosen>> getPosts(

    );
    @GET("campuss.php")
    Call<List<tampilDosen>> getPosts(@QueryMap Map<String,String> parameters);
}
