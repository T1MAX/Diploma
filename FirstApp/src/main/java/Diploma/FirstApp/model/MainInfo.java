package Diploma.FirstApp.model;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class MainInfo {

    private Long inn;
    private String fullName;


    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    protected MainInfo(){}
    public MainInfo(Long inn, String fullName) {
        this.inn = inn;
        this.fullName = fullName;
    }
}
