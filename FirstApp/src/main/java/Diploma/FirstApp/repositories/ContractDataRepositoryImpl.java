package Diploma.FirstApp.repositories;


import Diploma.FirstApp.model.ContractData;
import Diploma.FirstApp.repositories.ContractDataRepositoryCustom;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractDataRepositoryImpl implements ContractDataRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DBObject> findMostPopularSuppliers(int count) {
        List<DBObject> agg = Arrays.asList(
                new BasicDBObject("$unwind", "$supplierInfo"),
                new BasicDBObject("$project", new BasicDBObject("inn", "$supplierInfo.inn").append("name", "$supplierInfo.name")),
                new BasicDBObject("$group", new BasicDBObject("_id", new BasicDBObject("inn", "$inn").append("name", "$name")).append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", count));

        String collection = mongoTemplate.getCollectionName(ContractData.class);
        Iterable<DBObject> results = mongoTemplate.getCollection(collection).aggregate(agg).results();

        List<DBObject> suppliers = new ArrayList<>();
        results.forEach(supplier -> {
            JSONObject jsonObject = (JSONObject) JSON.parse(supplier.toString());
        });

        return suppliers;
    }

}
