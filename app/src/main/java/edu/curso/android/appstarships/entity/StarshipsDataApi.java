package edu.curso.android.appstarships.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import edu.curso.android.appstarships.entity.StarshipDataApi;

public class StarshipsDataApi {

    @SerializedName("results")
    ArrayList<StarshipDataApi> starshipsList;

    public ArrayList<StarshipDataApi> getStarshipsList() {
        return this.starshipsList;
    }

}
