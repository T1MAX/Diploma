package Diploma.FirstApp.ui;

import Diploma.FirstApp.model.ContractData;
import Diploma.FirstApp.repositories.ContractDataRepository;
import com.mongodb.DBObject;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@SpringUI
@Theme("valo")
public class NavigatorUI extends UI {

    private VerticalLayout layout;

    @Autowired
    ContractDataRepository repository;

    Grid<ContractData> grid = new Grid<>(ContractData.class);



    Button button = new Button("Show");

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();

        TextField text = new TextField();
        layout.addComponentsAndExpand(text);

        layout.addComponentsAndExpand(button);
        button.addClickListener(click -> {
            int count = Integer.parseInt(text.getValue());
            System.out.println(count);
            List<ContractData> suppliers = repository.findMostPopularSuppliers(count);
            grid.setItems(suppliers);
            layout.addComponentsAndExpand(grid);
        });

    }

    private void setupLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }



}
