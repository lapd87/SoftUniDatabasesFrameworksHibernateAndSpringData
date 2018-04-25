package softuni.cardealer.model.dto.binding;

import com.google.gson.annotations.Expose;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 21:31 ч.
 */
public class CarSeedDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public CarSeedDto() {
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