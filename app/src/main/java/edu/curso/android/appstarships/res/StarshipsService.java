package edu.curso.android.appstarships.res;

import java.util.ArrayList;

import edu.curso.android.appstarships.entity.StarshipDataApi;
import edu.curso.android.appstarships.entity.StarshipsDataApi;
import retrofit2.*;
import retrofit2.http.*;

public interface StarshipsService {

    @GET("starships/")
    public Call<StarshipsDataApi> getStarships();

    @GET("starships/2/")
    public Call<StarshipDataApi> getOneStarship();

}
