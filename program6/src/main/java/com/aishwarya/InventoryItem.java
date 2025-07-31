package com.aishwarya;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InventoryItem {
     private final SimpleStringProperty name;
    private final SimpleStringProperty id;
    private final SimpleIntegerProperty quantity;

    public InventoryItem(String name, String id, int quantity) {
       
        this.name = new SimpleStringProperty(name);
         this.id = new SimpleStringProperty(id);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }

    
    public String getId() { return id.get(); }
    public void setId(String id) { this.id.set(id); }


    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int quantity) { this.quantity.set(quantity); }
}
