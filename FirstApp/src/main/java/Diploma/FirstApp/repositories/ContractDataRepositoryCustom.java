package Diploma.FirstApp.repositories;


import Diploma.FirstApp.model.ContractData;
import com.mongodb.DBObject;

import java.util.List;

public interface ContractDataRepositoryCustom {

    List<DBObject> findMostPopularSuppliers(int count);

}
