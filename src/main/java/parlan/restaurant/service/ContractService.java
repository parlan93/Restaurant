package parlan.restaurant.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parlan.restaurant.model.Contract;
import parlan.restaurant.model.ContractType;
import parlan.restaurant.repository.ContractRepository;
import parlan.restaurant.repository.ContractTypeRepository;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    /**
     * Get raport of salaries based on few parameters
     *
     * @param isHourly
     * @param minEmployees
     * @param maxEmployees
     * @return
     */
    public List<Map<String, Object>> salariesReport(boolean isHourly, int minEmployees, int maxEmployees) {
        List<Map<String, Object>> reportContent = new ArrayList<>();

        for (ContractType contractType : contractTypeRepository.findAll()) {
            if (contractType.isHourly() == isHourly) {
                List<Contract> contracts = contractRepository.findByContractType(contractType);

                if (contracts.size() >= minEmployees && contracts.size() <= maxEmployees) {
                    Map<String, Object> contractTypesMap = new HashMap<>();

                    contractTypesMap.put("name", contractType.getName());
                    contractTypesMap.put("price", BigDecimal.valueOf(calculateAverageSalary(contracts)).setScale(2));
                    contractTypesMap.put("amount", contracts.size());

                    reportContent.add(contractTypesMap);
                }
            }
        }

        return reportContent;
    }

    /**
     * Calculate average salary based on contract list
     *
     * @param contracts
     * @return
     */
    private double calculateAverageSalary(List<Contract> contracts) {
        double salarySum = 0;
        double averageSalary = 0;

        for (Contract contract : contracts) {
            salarySum += contract.getSalary().doubleValue();
        }

        averageSalary = salarySum / contracts.size();
        averageSalary *= 100;
        averageSalary = Math.round(averageSalary);
        averageSalary /= 100;

        return averageSalary;
    }

}
