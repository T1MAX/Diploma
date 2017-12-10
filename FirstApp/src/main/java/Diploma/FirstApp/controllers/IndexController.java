package Diploma.FirstApp.controllers;

import Diploma.FirstApp.model.ContractData;
import Diploma.FirstApp.repositories.ContractDataRepository;
import com.mongodb.DBObject;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {
    private final ContractDataRepository contractDataRepository ;


    public IndexController(ContractDataRepository contractDataRepository) {
        this.contractDataRepository = contractDataRepository;
    }


    @GetMapping("/")
    public List<ContractData> getMostExpensiveContracts() {
        return contractDataRepository.findTop10ByOrderByPriceDesc();
    }

}
