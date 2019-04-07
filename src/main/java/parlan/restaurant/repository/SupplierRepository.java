package parlan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.Supplier;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    
}
