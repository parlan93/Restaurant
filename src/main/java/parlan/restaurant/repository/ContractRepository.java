package parlan.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import parlan.restaurant.model.Contract;
import parlan.restaurant.model.ContractType;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    List<Contract> findByContractType(ContractType contractType);
}
