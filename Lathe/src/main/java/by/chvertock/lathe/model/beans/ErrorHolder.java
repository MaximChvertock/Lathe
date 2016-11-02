/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHolder {
    private List<String> errors = new ArrayList<String>();

    public ErrorHolder() {
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void clear(){
        errors.clear();
    }

    public void add(String error){
        errors.add(error);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorHolder that = (ErrorHolder) o;

        return errors != null ? errors.equals(that.errors) : that.errors == null;

    }

    @Override
    public int hashCode() {
        return errors != null ? errors.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ErrorHolder{" +
                "errors=" + errors +
                '}';
    }
}
