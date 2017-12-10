package Diploma.FirstApp.model;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;

@QueryEntity
public class SupplierInfo {

    private String name;
    private String shortName;

    @Id
    private Long inn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    protected SupplierInfo(){}
    public SupplierInfo(String name, String shortName, Long inn) {
        this.name = name;
        this.shortName = shortName;
        this.inn = inn;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
