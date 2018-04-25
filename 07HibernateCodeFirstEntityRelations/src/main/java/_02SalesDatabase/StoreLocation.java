package _02SalesDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 12:48 ч.
 */

@Entity
@Table(name = "store_location")
public class StoreLocation {

    private int id;
    private String locationName;
    private Set<Sale> sales;



    public StoreLocation() {
    }

    public StoreLocation(int id, String locationName,
                         Set<Sale> sales) {
        this.id = id;
        this.locationName = locationName;
        this.sales = sales;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocation")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}