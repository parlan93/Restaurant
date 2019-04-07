package parlan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import parlan.restaurant.model.Employee;

/**
 *
 * @author Bartłomiej Skibiński
 * @param <T>
 */
@NoRepositoryBean
public interface EmployeeRepository<T extends Employee> extends JpaRepository<T, Integer> {

}
