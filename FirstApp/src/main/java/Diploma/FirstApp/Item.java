package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class Item {

    private ContractData contractData;
    private String guid;

    protected Item(){}
    public Item(ContractData contractData, String guid) {
        this.contractData = contractData;
        this.guid = guid;
    }
}
