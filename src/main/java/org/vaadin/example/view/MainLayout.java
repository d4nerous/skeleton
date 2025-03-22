package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.Navbar;

@Component
@UIScope
public class MainLayout extends VerticalLayout implements RouterLayout {

    public MainLayout(@Autowired Navbar navbar) {
        // La navbar sarà sempre visibile
        add(navbar);
    }

}