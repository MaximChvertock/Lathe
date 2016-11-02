/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;


import by.chvertock.lathe.model.entities.tire.Tire;


import java.util.HashSet;
import java.util.Set;

public class TireCompareList {

    private Set<Tire> tires = new HashSet<Tire>();

    public Set<Tire> getTires() {
        return tires;
    }

    public void setTires(Set<Tire> tires) {
        this.tires = tires;
    }

    public void addTire(Tire tire) {
        if (tire == null) {
            throw new NullPointerException("Can't add tire to comapre list because tire is null");
        }

        tires.add(tire);
    }

    public void removeTire(Tire tire) {
        if (tire == null) {
            throw new NullPointerException("Can't remove tire from comapre list because tire is null");
        }

        tires.remove(tire);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TireCompareList that = (TireCompareList) o;

        return tires != null ? tires.equals(that.tires) : that.tires == null;

    }

    @Override
    public int hashCode() {
        return tires != null ? tires.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TireCompareList{" +
                "tires=" + tires +
                '}';
    }
}
