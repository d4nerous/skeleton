package org.vaadin.example.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.vaadin.example.events.AnnoSelectionEvent;
import org.vaadin.example.events.RuoloSelectionEvent;
import org.vaadin.example.events.TabComplessiChangeEvent;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.model.AnnoFormtivoDTO;
import org.vaadin.example.model.RuoloDTO;

@Service
public class EventService {
    private final ApplicationEventPublisher eventPublisher;

    public EventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishRuoloChange(RuoloDTO value) {
        eventPublisher.publishEvent(new RuoloSelectionEvent(this, value));
    }
    public void publishAnnoChange(AnnoFormtivoDTO anno) {
        eventPublisher.publishEvent(new AnnoSelectionEvent(this, anno));
    }

}