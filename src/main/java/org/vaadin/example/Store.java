package org.vaadin.example;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class Store {

    String ruoloSelected="Opertore";

}
