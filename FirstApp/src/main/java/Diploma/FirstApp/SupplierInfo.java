package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class SupplierInfo {

    private String name;
    private Long inn;

    protected SupplierInfo(){}
    public SupplierInfo(String name, Long inn) {
        this.name = name;
        this.inn = inn;
    }
}
