package parlan.restaurant.repository;

import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.Chef;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Transactional
public interface ChefRepository extends EmployeeRepository<Chef> {

}
