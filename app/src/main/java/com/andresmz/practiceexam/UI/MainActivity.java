package com.andresmz.practiceexam.UI;

    import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.andresmz.practiceexam.Adapter.AdapterCats;
import com.andresmz.practiceexam.Class.CatClass;
import com.andresmz.practiceexam.R;
import com.andresmz.practiceexam.rest.ConfigAPI;
import com.andresmz.practiceexam.rest.Model.CatsModel;
import com.andresmz.practiceexam.rest.Service.Cats;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Cats gatosPeticion;
    public RecyclerView recyclerViewCats;

    public ArrayList<CatClass> listCats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gatosPeticion = ConfigAPI.client().create(Cats.class);

        recyclerViewCats = findViewById(R.id.recyclerView_cats);

        peticionesGatos();
    }

    private void peticionesGatos() {

        Call<List<CatsModel>> call = gatosPeticion.getListaGatos();
        call.enqueue(new Callback<List<CatsModel>>() {
            @Override
            public void onResponse(Call<List<CatsModel>> call, Response<List<CatsModel>> response) {
                Log.d("responseCats", response.code()+"");

                List<CatsModel> responseData = response.body();        //array
                
                for(CatsModel itemList: responseData){              //cada elemento
                        listCats.add(new CatClass(itemList.metadata_created));
                }

                AdapterCats adapterCats = new AdapterCats(listCats);
                recyclerViewCats.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                recyclerViewCats.setAdapter(adapterCats);

            }

            @Override
            public void onFailure(Call<List<CatsModel>> call, Throwable t) {
                Log.d("responseCats", t.getMessage());
                call.cancel();
            }
        });

    }

}