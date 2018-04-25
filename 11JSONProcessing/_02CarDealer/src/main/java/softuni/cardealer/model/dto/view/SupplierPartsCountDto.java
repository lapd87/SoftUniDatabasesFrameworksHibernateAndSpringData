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
    private long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    private long partsCount;

    public SupplierPartsCountDto() {
    }

    public SupplierPartsCountDto(long id, String name, long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(long partsCount) {
        this.partsCount = partsCount;
    }
}