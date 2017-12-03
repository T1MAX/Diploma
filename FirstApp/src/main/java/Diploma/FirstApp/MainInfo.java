package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class MainInfo {


    private Long inn;
    private String fullName;

    protected MainInfo(){}
    public MainInfo(Long inn, String fullName) {
        this.inn = inn;
        this.fullName = fullName;
    }
}
