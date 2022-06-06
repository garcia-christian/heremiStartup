package com.example.heremistartup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface declarationAPI {


    @POST("/addmed")
    Call<List<modelMedicineRes>> saveMedicine(@Body modelMedicine modelMedicine);

    @POST("/addrem")
    Call<List<modelReminderRes>> saveRemidner(@Body modelReminder modelReminder);

    @POST("/addtime")
    Call<List<modelTimeRes>> saveTime(@Body modelTime modelTime);

    @GET("/getmed")
    Call<List<modelMedicineRes>> getMedicine();

    @GET("/gettime/{id}")
    Call<List<modelTimeRes>> getTime(@Path("id") int id);

    @GET("/gettime/")
    Call<List<modelTimeRes>> getTime();

    @GET("/getmed/{id}")
    Call<List<modelMedicineRes>> getMedicine(@Path("id") int id);

    @GET("/getrem")
    Call<List<modelReminderRes>> getReminder();
}
