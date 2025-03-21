package org.vaadin.example.components;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.html.Span;
import org.springframework.stereotype.Component;

@Component
public class LeftColumnSecondView extends VerticalLayout {

    public LeftColumnSecondView() {
        setSpacing(true);
        setPadding(true);
        setWidth("250px"); // Impostare la larghezza della colonna
        setHeightFull();   // Per riempire verticalmente lo spazio

        // Creare le voci della colonna con icone
        HorizontalLayout homeLayout = createButtonWithIcon(VaadinIcon.HOME, "Torna alla Home");
        HorizontalLayout modifyLayout = createButtonWithIcon(VaadinIcon.EDIT, "Modifica");
        HorizontalLayout cancelLayout = createButtonWithIcon(VaadinIcon.CLOSE, "Annulla");

        // Aggiungere le voci alla colonna
        add(homeLayout, modifyLayout, cancelLayout);

        // Allineare al centro le voci
        setAlignItems(Alignment.START);
    }

    private HorizontalLayout createButtonWithIcon(VaadinIcon icon, String text) {
        // Crea un'icona e un'etichetta
        Icon iconComponent = icon.create();
        Span textComponent = new Span(text);

        // Crea un layout orizzontale per ogni voce
        HorizontalLayout layout = new HorizontalLayout(iconComponent, textComponent);
        layout.setAlignItems(Alignment.CENTER);
        layout.setSpacing(true);

        // Impostare l'azione al click del layout (se vuoi una azione)
        layout.addClickListener(e -> {
            // Gestire le azioni cliccando su ciascuna voce
            if (text.equals("Torna alla Home")) {

                // Naviga alla vista "second-view"
                getUI().ifPresent(ui -> ui.navigate("operatore-view"));
                // Opzionale: mostra una notifica per il click
                Notification.show("Hai cliccato il bottone e sei stato reindirizzato alla home!");

                System.out.println("Torna alla Home");
            } else if (text.equals("Modifica")) {
                // Azione per modificare
                System.out.println("Modifica");
            } else if (text.equals("Annulla")) {
                // Azione per annullare
                System.out.println("Annulla");
            }
        });

        return layout;
    }
}
