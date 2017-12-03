package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class Body {
    private Item item;

    protected Body(){}

    public Body(Item item) {
        this.item = item;
    }
}
