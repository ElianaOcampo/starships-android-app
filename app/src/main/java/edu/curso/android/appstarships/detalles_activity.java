package edu.curso.android.appstarships;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import edu.curso.android.appstarships.entity.StarshipDataApi;

public class detalles_activity extends AppCompatActivity {

    private StarshipDataApi starship;
    private TextView textViewName;
    private TextView textViewModel;
    private TextView textViewClass;
    private TextView textViewLenght;
    private TextView textViewCrew;
    private TextView textViewSpeed;
    private TextView textViewCapacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        Toolbar toolbar = findViewById(R.id.toolbarDetalles);
      /*  setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       */
        starship = getIntent().getExtras().getParcelable("starship");
        llenarDetalles();
    }

    private void llenarDetalles() {
        textViewName = findViewById(R.id.textViewNameDetails);
        textViewName.setText(starship.getName());
        textViewModel = findViewById(R.id.textViewModelDetails);
        textViewModel.setText(starship.getModel());
        textViewClass = findViewById(R.id.textViewClass);
        textViewClass.setText(starship.getStarshipClass());
        textViewCapacity = findViewById(R.id.textViewCapacity);
        textViewCapacity.setText(starship.getPassengers());
        textViewCrew = findViewById(R.id.textViewCrew);
        textViewCrew.setText(starship.getCrewSize());
        textViewLenght = findViewById(R.id.textViewLenght);
        textViewLenght.setText(starship.getLength());
        textViewSpeed = findViewById(R.id.textViewSpeed);
        textViewSpeed.setText(starship.getSpeed());
    }

}
