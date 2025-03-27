package org.vaadin.example.components;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class LeftColumnCorsiViewComponent extends BaseCardVertical {

    public LeftColumnCorsiViewComponent() {
        setHeightFull();
        setWidth("20vw");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.END);
        // Creare le voci della colonna con icone
        HorizontalLayout homeLayout = createButtonWithIcon(VaadinIcon.HOME, "Torna al cruscotto operatore");


        // Aggiungere le voci alla colonna
        add(homeLayout);

    }

    private HorizontalLayout createButtonWithIcon(VaadinIcon icon, String text) {
        // Crea un'icona e un'etichetta
        Icon iconComponent = icon.create();
        H4 textComponent = new H4(text);

        // Crea un layout orizzontale per ogni voce
        HorizontalLayout layout = new HorizontalLayout(iconComponent, textComponent);
        layout.setAlignItems(Alignment.CENTER);
        layout.setJustifyContentMode(JustifyContentMode.CENTER);

        layout.setSpacing(true);
        layout.getStyle().set("cursor","pointer");
        layout.addClickListener(e -> {
                    getUI().ifPresent(ui -> ui.navigate("operatore-view"));

        });

        return layout;
    }
}
