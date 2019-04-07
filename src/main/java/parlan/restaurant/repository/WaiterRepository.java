package parlan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.Waiter;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Transactional
public interface WaiterRepository extends JpaRepository<Waiter, Integer>{
    
}
