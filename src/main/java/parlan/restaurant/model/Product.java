package parlan.restaurant.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 32, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategory.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(String name, ProductCategory productCategory) {
        this.name = name;
        this.productCategory = productCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

}
