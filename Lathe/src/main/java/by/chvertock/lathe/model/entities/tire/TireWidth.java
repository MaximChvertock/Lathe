/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.tire;

import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tire_width")
@SQLInsert(
        sql = "INSERT INTO " +
                "tire_width (value) values(?) " +
                "ON DUPLICATE KEY UPDATE " +
                "id = VALUES(id), " +
                "value = VALUES(value);"
)
public class TireWidth extends Model {

    @Column(name = "value")
    private String value;

    public TireWidth() {
    }

    public TireWidth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TireWidth width = (TireWidth) o;

        return value != null ? value.equals(width.value) : width.value == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
