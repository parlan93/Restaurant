package parlan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.MealCategory;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
@Transactional
public interface MealCategoryRepository extends JpaRepository<MealCategory, Integer>{
    
}
