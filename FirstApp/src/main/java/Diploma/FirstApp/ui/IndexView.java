package Diploma.FirstApp.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

@UIScope
public class IndexView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "index";

    public IndexView() {
        setSizeFull();

        Button button = new Button("Go to Main View", event -> UI.getCurrent().getNavigator().navigateTo("suppliers"));
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
}
