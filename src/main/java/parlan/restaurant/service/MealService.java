package parlan.restaurant.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parlan.restaurant.model.Meal;
import parlan.restaurant.model.Product;
import parlan.restaurant.repository.MealRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    /**
     * Get meals from database and put them into list of maps
     * @param minPrice
     * @param maxPrice
     * @return 
     */
    public List<Map<String, Object>> mealReport(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Map<String, Object>> reportContent = new ArrayList<>();

        for (Meal meal : repository.findAll()) {
            
            if (meal.getPrice().compareTo(minPrice) >= 0 && meal.getPrice().compareTo(maxPrice) <= 0) {
            Map<String, Object> mealsMap = new HashMap<>();

                mealsMap.put("category", meal.getMealCategory().getName());
                mealsMap.put("name", meal.getName());
                mealsMap.put("price", meal.getPrice());
                mealsMap.put("products", convertProductsFromArrayToString(meal.getProducts()));

                reportContent.add(mealsMap);
            }
        }

        return reportContent;
    }

    /**
     * Converts products arrray to string
     *
     * @param products
     * @return
     */
    private String convertProductsFromArrayToString(List<Product> products) {
        StringBuilder productsString = new StringBuilder();

        for (int i = 0; i < products.size(); i++) {
            if (i > 0) {
                productsString.append(", ");
            }
            productsString.append(products.get(i).getName());
        }

        return productsString.toString();
    }

}
