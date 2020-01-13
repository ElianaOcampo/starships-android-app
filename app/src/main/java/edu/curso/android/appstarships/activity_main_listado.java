package edu.curso.android.appstarships;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.curso.android.appstarships.detalles_activity;
import edu.curso.android.appstarships.entity.StarshipDataApi;
import edu.curso.android.appstarships.entity.StarshipsDataApi;
import edu.curso.android.appstarships.res.RetrofitClient;
import edu.curso.android.appstarships.res.StarshipsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class activity_main_listado extends AppCompatActivity implements RecyclerAdapterStartships.onClickListener {

    private RecyclerView recyclerViewStarships;
    private ArrayList<StarshipDataApi> starships;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listado);

        recyclerViewStarships = findViewById(R.id.recyclerViewListadoStarships);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStarships.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration =  new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewStarships.addItemDecoration(dividerItemDecoration);

        cargarStarships();

    }

    private void cargarStarships() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Retrofit retrofit = RetrofitClient.recuperarRetrofit();
        StarshipsService starshipsService = retrofit.create(StarshipsService.class);
        Call<StarshipsDataApi> call = starshipsService.getStarships();
        call.enqueue(new Callback<StarshipsDataApi>() {
            @Override
            public void onResponse(Call<StarshipsDataApi>call, Response<StarshipsDataApi> response) {
                starships = response.body().getStarshipsList();
                progressDialog.hide();
                mostrarStarships();
            }

            @Override
            public void onFailure(Call<StarshipsDataApi> call, Throwable t) {

                Log.i("activity_main_listado", "paso por onFailure");
                System.out.println(t);
            }

        });

    }

    private void mostrarStarships() {
        RecyclerAdapterStartships recyclerAdapterStartships = new RecyclerAdapterStartships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStartships);
    }

    private void mostrarDetalles(int pos) {
        Intent intentDetalles = new Intent(this, detalles_activity.class);
        StarshipDataApi extra = starships.get(pos);
        intentDetalles.putExtra("starship", extra);
        startActivity(intentDetalles);
    }

    @Override
    public void onClickListener(int pos) {
        mostrarDetalles(pos);
    }

}
