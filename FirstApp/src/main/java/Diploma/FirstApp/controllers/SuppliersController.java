package Diploma.FirstApp.controllers;

import Diploma.FirstApp.repositories.ContractDataRepository;
import com.mongodb.DBObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    private final ContractDataRepository contractDataRepository ;


    public SuppliersController(ContractDataRepository contractDataRepository) {
        this.contractDataRepository = contractDataRepository;
    }

    @GetMapping("/{count}")
    public List<DBObject> getMostPopularSuppliers(@PathVariable("count") Integer count) {
        return contractDataRepository.findMostPopularSuppliers(count);
    }
}
