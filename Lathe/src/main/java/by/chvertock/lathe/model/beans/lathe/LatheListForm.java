/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.lathe;

import by.chvertock.lathe.model.entities.lathe.Lathe;

import java.util.List;

public class LatheListForm {
    private List<Lathe> latheList;

    public LatheListForm() {
    }

    public LatheListForm(List<Lathe> latheList) {
        this.latheList = latheList;
    }

    public List<Lathe> getLatheList() {
        return latheList;
    }

    public void setLatheList(List<Lathe> latheList) {
        this.latheList = latheList;
    }

    @Override
    public String toString() {
        return latheList.toString();
    }
}
