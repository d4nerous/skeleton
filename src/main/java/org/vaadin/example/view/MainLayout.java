package org.vaadin.example.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.components.NavbarComponent;
import org.vaadin.example.events.RuoloSelectionEvent;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.service.EventService;

import java.util.List;

@Component
@UIScope
@CssImport("./styles/roundButtonsStyles.css")
public class MainLayout extends VerticalLayout implements RouterLayout {
    private final EventService eventService;
    List<RuoloDTO> listaRuoli;
    Store store;
    @Autowired
    public MainLayout(EventService eventService, NavbarComponent navbarComponent) {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.eventService=eventService;
        this.store=store;
        this.listaRuoli=store.utente.getRoles();
        if(store.ruoloSelected==null){
            openRoleSelectionDialog(navbarComponent);
        }
    }
    private void openRoleSelectionDialog(NavbarComponent navbarComponent) {


        Dialog roleDialog = new Dialog();
        roleDialog.setCloseOnEsc(false);
        roleDialog.setCloseOnOutsideClick(false);

        // ComboBox con i ruoli disponibili
        ComboBox<RuoloDTO> ruoloComboBox = new ComboBox<>("Seleziona il tuo ruolo");
        ruoloComboBox.setItems(listaRuoli);
        ruoloComboBox.setItemLabelGenerator(RuoloDTO::getName);

        // Bottone per confermare la selezione
        Button confirmButton = new Button("Conferma", event -> {
            if (ruoloComboBox.getValue() != null) {
                ruoloComboBox.addValueChangeListener(r -> {
                    if (r.getValue() != null) {
                        this.eventService.publishRuoloChange(r.getValue());
                        this.store.ruoloSelected=r.getValue();

                    }
                });
                roleDialog.close();
                add(navbarComponent);
                navbarComponent.setRuoloComboBox(ruoloComboBox.getValue());





            }
        });

        // Aggiungere elementi al Dialog e mostrarlo
        roleDialog.add(new VerticalLayout(ruoloComboBox, confirmButton));
        roleDialog.open();
    }
    @EventListener
    public void handleRuoloSelection(RuoloSelectionEvent event) {
        // Seleziona se la colonna sinistra deve essere visibile o meno
        if("Operatore".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("operatore-view");
        }else if("Altro".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("altro-view");
        }else{
            UI.getCurrent().navigate("");
        }
}
}