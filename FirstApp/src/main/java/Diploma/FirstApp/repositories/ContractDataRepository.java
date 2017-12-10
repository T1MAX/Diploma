package Diploma.FirstApp.repositories;

import Diploma.FirstApp.model.ContractData;
import com.mongodb.DBObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDataRepository extends MongoRepository<ContractData, String>, ContractDataRepositoryCustom {

    List<ContractData> findByPrice(Double price);

    List<DBObject> findMostPopularSuppliers(int count);

    List<ContractData> findTop10ByOrderByPriceDesc();

}
