/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.wheel;

import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wheel_mount")
@SQLInsert(
        sql = "INSERT INTO " +
                "wheel_mount (value) values(?) " +
                "ON DUPLICATE KEY UPDATE " +
                "id = VALUES(id), " +
                "value = VALUES(value);"
)
public class WheelMount extends Model {

    @Column(name = "value")
    private String value;

    public WheelMount() {
    }

    public WheelMount(String value) {
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

        WheelMount mount = (WheelMount) o;

        return value != null ? value.equals(mount.value) : mount.value == null;

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
