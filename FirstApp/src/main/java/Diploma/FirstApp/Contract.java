package Diploma.FirstApp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Document(collection = "contracts")
public class Contract {

    @Id
    @GeneratedValue
    public String id;

}
