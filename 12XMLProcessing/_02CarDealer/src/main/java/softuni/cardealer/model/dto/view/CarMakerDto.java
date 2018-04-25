package softuni.cardealer.model.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.4.2018 г.
 * Time: 11:44 ч.
 */
public class CarMakerDto {

    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Make")
    private String make;
    @Expose
    @SerializedName("Model")
    private String model;
    @Expose
    @SerializedName("TravelledDistance")
    private Long travelledDistance;

    public CarMakerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}