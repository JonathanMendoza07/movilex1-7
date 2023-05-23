package com.andresmz.practiceexam.rest.Service;

import com.andresmz.practiceexam.rest.Model.CatsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Cats {

    @GET("datapackage.json")
    Call<List<CatsModel>> getListaGatos();

//    //POST permite enviar datos a la api
//    @POST("cats/{id}")          //  -> /product/:id
//    Call<CatsModel> getListaGatos(@Path("id") Integer idCat);
//
//    @POST("cat/")          //  -> /cat
//    @FormUrlEncoded         // --> para enviar un conjunto de campos
//    Call<CatsModel> guardarGato(@Field("user_fname") String name,
//                                @Field("user_lname") String lname);
//
//    @DELETE("cats/{id}")          //  -> /product/:id
//    Call<CatsModel> deteleGato(@Path("id") Integer idCat);
//
//

}
