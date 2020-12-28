package nastya.BookShop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "assortment")
public class Assortment {
    @EmbeddedId
    private AssortmentId assortmentId;
    private String quantity;
    @Column(name = "price_per_item")
    private String Price;
    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private Classification classification;

    public Assortment(){}

    public Assortment(AssortmentId assortmentId, String quantity, String price, Date creationDate, Classification classification) {
        this.assortmentId = assortmentId;
        this.quantity = quantity;
        Price = price;
        this.creationDate = creationDate;
        this.classification = classification;
    }
}