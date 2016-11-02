/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;

import by.chvertock.lathe.model.entities.tire.Tire;

import java.util.List;

public class TireListForm {
    private List<Tire> tireList;

    public TireListForm() {
    }

    public TireListForm(List<Tire> tireList) {
        this.tireList = tireList;
    }

    public List<Tire> getTireList() {
        return tireList;
    }

    public void setTireList(List<Tire> tireList) {
        this.tireList = tireList;
    }

    @Override
    public String toString() {
        return tireList.toString();
    }
}
