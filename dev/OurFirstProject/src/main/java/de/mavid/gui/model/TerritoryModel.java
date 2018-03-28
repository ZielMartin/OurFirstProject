package de.mavid.gui.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TerritoryModel {
    private LongProperty numberProperty;
    private StringProperty nameProperty;
    private StringProperty imageb64Property;

    public TerritoryModel() {
        this.numberProperty = new SimpleLongProperty(0);
        this.nameProperty = new SimpleStringProperty("");
        this.imageb64Property = new SimpleStringProperty("");
    }

    public long getNumber() {
        return this.numberProperty.get();
    }

    public void setNumber(long number) {
        this.numberProperty.set(number);
    }

    public LongProperty numberProperty() {
        return this.numberProperty;
    }

    public String getName() {
        return this.nameProperty.get();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty nameProperty() {
        return this.nameProperty;
    }

    public String getImageb64() {
        return this.imageb64Property.get();
    }

    public void setImageb64(String imageb64) {
        this.imageb64Property.set(imageb64);
    }

    public StringProperty Imageb64Property() {
        return this.imageb64Property;
    }
}
