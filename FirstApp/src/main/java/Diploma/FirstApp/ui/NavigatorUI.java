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

//    @WebServlet(urlPatterns = "/*")
//    @VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//        @Override
//        public ServletContext getServletContext() {
//            return super.getServletContext();
//        }
//    }

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


//    @Override
//    protected void init(VaadinRequest vaadinRequest) {
//        final VerticalLayout root = new VerticalLayout();
//        root.setSizeFull();
//        root.setMargin(true);
//        root.setSpacing(true);
//        setContent(root);
//
//        final CssLayout navigationBar = new CssLayout();
//        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//
//        navigationBar.addComponent(createNavigationButton("Index View",
//                IndexView.VIEW_NAME));
//        navigationBar.addComponent(createNavigationButton("Suppliers View",
//                SuppliersView.VIEW_NAME));
//
//        root.addComponent(navigationBar);
//
//        Navigator navigator = new Navigator(this, this);
//        navigator.addView("index", IndexView.class);
//        navigator.addView("suppliers", SuppliersView.class);
//        navigator.addView(TopSuppliersView.VIEW_NAME, TopSuppliersView.class);
//        navigator.navigateTo("index");
//        navigator.addProvider(viewProvider);
//
//    }

}
