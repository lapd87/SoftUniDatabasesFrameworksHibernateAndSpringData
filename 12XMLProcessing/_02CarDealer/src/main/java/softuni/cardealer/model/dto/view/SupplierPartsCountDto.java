package softuni.cardealer.model.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.4.2018 г.
 * Time: 13:34 ч.
 */
public class SupplierPartsCountDto {

    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    private int partsCount;

    public SupplierPartsCountDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}