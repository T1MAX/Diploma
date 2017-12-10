package Diploma.FirstApp.repositories;

import Diploma.FirstApp.model.SupplierInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierInfoRepository extends MongoRepository<SupplierInfo, Integer> {

    List<SupplierInfo> findByInn(Long inn);
}
