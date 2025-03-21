package org.vaadin.example.service;

import org.springframework.stereotype.Service;

@Service
public class ComboBoxService {

    private String selectedValue1;
    private String selectedValue2;

    public String getSelectedValue1() {
        return selectedValue1;
    }

    public void setSelectedValue1(String selectedValue1) {
        this.selectedValue1 = selectedValue1;
    }

    public String getSelectedValue2() {
        return selectedValue2;
    }

    public void setSelectedValue2(String selectedValue2) {
        this.selectedValue2 = selectedValue2;
    }
}
