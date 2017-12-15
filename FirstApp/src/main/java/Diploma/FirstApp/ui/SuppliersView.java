package Diploma.FirstApp.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;


@SpringView(name = SuppliersView.VIEW_NAME)
public class SuppliersView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "suppliers";
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        TextField text = new TextField();
        Button button = new Button("Add");
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
        button.addClickListener(click -> UI.getCurrent().getNavigator().navigateTo("topSuppliers"));
    }

    private void addContent() {

    }
}
