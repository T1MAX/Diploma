package Diploma.FirstApp.ui;

import Diploma.FirstApp.repositories.ContractDataRepository;
import com.mongodb.DBObject;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TopSuppliersView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "topSuppliers";

    @Autowired
    private ContractDataRepository repository;

    private Grid<DBObject> grid;



    @PostConstruct
    private void init() {
        TextField text = new TextField();

        addComponent(text);
        grid = new Grid<>();
        Button button = new Button("Show", click -> {
            int count = Integer.parseInt(text.getValue());
            System.out.println(count);
            List<DBObject> suppliers = repository.findMostPopularSuppliers(10);
            grid.setItems(suppliers);
            grid.setColumns("inn", "name", "count");
        });
        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
