package parlan.restaurant.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "meal")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 32, unique = true)
    private String name;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MealCategory.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "meal_category_id", nullable = false)
    private MealCategory mealCategory;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinTable(name = "meal_product", joinColumns = {
        @JoinColumn(name = "meal_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "product_id")
    }, uniqueConstraints = {
        @UniqueConstraint(columnNames = { "meal_id", "product_id" })
    })
    List<Product> products;

    public Meal() {
    }

    public Meal(String name, BigDecimal price, MealCategory mealCategory, List<Product> products) {
        this.name = name;
        this.price = price;
        this.mealCategory = mealCategory;
        this.products = products;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MealCategory getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
