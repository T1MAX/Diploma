package Diploma.FirstApp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends MongoRepository<Contract, String>, QueryDslPredicateExecutor<Contract> {

    @Query(value = "{body.item.contractData.price:?0}")
    List<Contract> findByPrice(String price);

}
