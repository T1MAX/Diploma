package Diploma.FirstApp;


import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class Customer {
    private MainInfo mainInfo;

    protected Customer(){}
    public Customer(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }
}
