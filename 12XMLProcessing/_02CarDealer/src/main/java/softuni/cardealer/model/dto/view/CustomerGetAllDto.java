package softuni.cardealer.model.dto.view;

import com.google.gson.annotations.Expose;
import softuni.cardealer.model.entity.Sale;

import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.4.2018 г.
 * Time: 10:34 ч.
 */
public class CustomerGetAllDto {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Date birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private Set<Sale> sales;


    public CustomerGetAllDto() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}