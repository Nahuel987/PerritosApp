package com.example.perritoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.perritoapp.api.ApiDog;
import com.example.perritoapp.api.RetrofitClient;
import com.example.perritoapp.model.BreedImageListResponse;
import com.example.perritoapp.model.BreedListResponse;
import com.example.perritoapp.ui.ListaRazasFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String perro1;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.RecyclerView);//1.enlazo recycler view a su vitsa xml
        instanceDetailFragment();

        //retrofit
        ApiDog api = RetrofitClient.getRetrofitInstance().create(ApiDog.class);
        Call<BreedListResponse> call = api.getBreedList();


        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {

                List<String> perritos= response.body().getBreedList();
                perro1=perritos.get(0);//llamo al primer perro de la lista
                Log.e("PERRITOS",String.valueOf(perritos));

                if (!perro1.equals("")) {
                    whoLetTheDogsOut();
                }

            }

            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this,"FALLO LA CONECXIONNN", Toast.LENGTH_SHORT).show();
                Log.e("PERRITOSSS NO OK",String.valueOf(t));

            }
        });

    }//on create

    private void whoLetTheDogsOut(){
        ApiDog service = RetrofitClient.getRetrofitInstance().create(ApiDog.class);
        Call<BreedImageListResponse> callImages = service.getBeedImageList(perro1);

        callImages.enqueue(new Callback<BreedImageListResponse>() {
            @Override
            public void onResponse(Call<BreedImageListResponse> call, Response<BreedImageListResponse> response) {

                List<String> imagesURL=response.body().getImageURL();
                Log.e("IMAGENES PERRITOS OK",String.valueOf(imagesURL));
            }

            @Override
            public void onFailure(Call<BreedImageListResponse> call, Throwable t) {

                // Toast.makeText(MainActivity.this,"FALLO LA CONECXIONNN DE IMAGENES", Toast.LENGTH_SHORT).show();
                Log.e("IMAGENES PERRITOSSSSSSS",String.valueOf(t));

            }
        });
    }
    private void instanceDetailFragment(String name,String url){

        ListaRazasFragment detailFragment=ListaRazasFragment.newInstance(name, url);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout,detailFragment,"FRAGMENTO DE DETALLES")
                .commit();

    }




}//class
