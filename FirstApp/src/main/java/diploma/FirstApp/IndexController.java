package Diploma.FirstApp;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    final ContractRepository contractRepository ;

    public IndexController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    @GetMapping("/")
    public List<Contract> getCustomers() {
        return contractRepository.findByPrice("18225284.76");
    }

    @GetMapping("/contracts/{price}")
    public List<Contract> getContractsByPrice(@PathVariable("price") String price) {
        QContract contract = new QContract("contract");

        //BooleanExpression filter = contract.body.item
        return new ArrayList<>();
    }
}
