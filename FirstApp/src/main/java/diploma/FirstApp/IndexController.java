package Diploma.FirstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    final ContractRepository contractRepository;

    public IndexController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/")
    public long getContracts() {
        return contractRepository.count();
    }
}
