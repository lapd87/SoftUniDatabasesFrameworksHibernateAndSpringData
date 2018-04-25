package _001ShampooCompany.Shampoo;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.3.2018 г.
 * Time: 14:56 ч.
 */

@Entity
@Table(name = "labels")
public class BasicLabel implements Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class,
            cascade = CascadeType.ALL)
    private BasicShampoo basicShampoo;

    public BasicLabel() {
    }

    public BasicLabel(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }


    @Override
    public long getId() {
        return this.Id;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override
    public void setSubtitle(String subtitle) {

    }
}