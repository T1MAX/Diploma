package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@QueryEntity
@Document(collection = "contracts")
public class Contract {

    @Id
    private String id;
    private Body body;

    protected Contract(){}

    public Contract(String id, Body body) {
        this.id = id;
        this.body = body;
    }
}
