package softuni.cardealer.model.dto.binding;

import com.google.gson.annotations.Expose;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 17:38 ч.
 */
public class SupplierSeedDto {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}