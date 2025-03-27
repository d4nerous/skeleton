package org.vaadin.example.listener;


import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.Utility;
import org.vaadin.example.model.UtenteDTO;

@Component
public class UiServiceInitListener implements VaadinServiceInitListener {

    private final ApplicationContext applicationContext;

    public UiServiceInitListener(ApplicationContext context) {
        this.applicationContext = context;
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener(uiInitEvent -> {


            // servirà per selezionare un ruolo appena parte l'app
            Store store = applicationContext.getBean(Store.class);
            uiInitEvent.getUI().addBeforeEnterListener(event -> {
                store.utente = Utility.loadJson("utente.json", UtenteDTO.class);
                VaadinSession.getCurrent().setAttribute(Store.class, store);

            });
        });
    }
}
