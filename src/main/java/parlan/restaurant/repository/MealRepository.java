package parlan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.Meal;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
@Transactional
public interface MealRepository extends JpaRepository<Meal, Integer>{
    
}
