package edu.curso.android.appstarships;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Button buttonIniciar;
    private ImageView imageViewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonIniciar = findViewById(R.id.buttonIniciar);
        imageViewStart = findViewById(R.id.imageViewStart);

        Picasso.with(this).load("https://scandinaviantraveler.com/sites/default/files/styles/article_top_full_imagecustom_user_mobile_2x/public/starwars-fleet-1140x619.jpg?itok=WAoUF34f").into(imageViewStart);
        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
    }

    public void iniciar() {
        Intent intent = new Intent(this, activity_main_listado.class);
        startActivity(intent);
    }

}
