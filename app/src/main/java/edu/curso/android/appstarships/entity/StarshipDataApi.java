package edu.curso.android.appstarships.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class StarshipDataApi implements Parcelable {

    @SerializedName("name")
    String name;
    @SerializedName("model")
    String model;
    @SerializedName("starship_class")
    String starshipClass;
    @SerializedName("length")
    String length;
    @SerializedName("crew")
    String crewSize;
    @SerializedName("MGLT")
    String speed;
    @SerializedName("passengers")
    String passengers;

    public StarshipDataApi() {}

    public StarshipDataApi(String name, String model, String starshipClass, String length, String crewSize, String speed, String passengers) {
        this.name = name;
        this.model = model;
        this.starshipClass = starshipClass;
        this.length = length;
        this.crewSize = crewSize;
        this.speed = speed;
        this.passengers = passengers;
    }

    protected StarshipDataApi(Parcel in) {
        name = in.readString();
        model = in.readString();
        starshipClass = in.readString();
        length = in.readString();
        crewSize = in.readString();
        speed = in.readString();
        passengers = in.readString();
    }

    public static final Creator<StarshipDataApi> CREATOR = new Creator<StarshipDataApi>() {
        @Override
        public StarshipDataApi createFromParcel(Parcel in) {
            return new StarshipDataApi(in);
        }

        @Override
        public StarshipDataApi[] newArray(int size) {
            return new StarshipDataApi[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public String getModel() {
        return this.model;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCrewSize() {
        return crewSize;
    }

    public String getSpeed() {
        return speed;
    }

    public String getLength() {
        return length;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public String toString() {
        return this.name + this.model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(starshipClass);
        dest.writeString(length);
        dest.writeString(crewSize);
        dest.writeString(speed);
        dest.writeString(passengers);
    }
}
