/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;

import by.chvertock.lathe.model.entities.tire.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TireFilter {
    private List<TireBrand> tireBrands = new ArrayList<TireBrand>();

    private List<TireType> tireTypes = new ArrayList<TireType>();

    private List<TireWidth> tireWidths = new ArrayList<TireWidth>();

    private List<TireProfile> tireProfiles = new ArrayList<TireProfile>();

    private List<TireDiameter> tireDiameters = new ArrayList<TireDiameter>();

    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    private String price;

    private boolean inStock;

    public List<TireBrand> getTireBrands() {
        return tireBrands;
    }

    public void setTireBrands(List<TireBrand> tireBrands) {
        this.tireBrands = tireBrands;
    }

    public List<TireType> getTireTypes() {
        return tireTypes;
    }

    public void setTireTypes(List<TireType> tireTypes) {
        this.tireTypes = tireTypes;
    }

    public List<TireWidth> getTireWidths() {
        return tireWidths;
    }

    public void setTireWidths(List<TireWidth> tireWidths) {
        this.tireWidths = tireWidths;
    }

    public List<TireProfile> getTireProfiles() {
        return tireProfiles;
    }

    public void setTireProfiles(List<TireProfile> tireProfiles) {
        this.tireProfiles = tireProfiles;
    }

    public List<TireDiameter> getTireDiameters() {
        return tireDiameters;
    }

    public void setTireDiameters(List<TireDiameter> tireDiameters) {
        this.tireDiameters = tireDiameters;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;

        String[] prices = price.split(",");

        if (prices.length == 2) {
            try {
                BigDecimal min = new BigDecimal(prices[0]);
                BigDecimal max = new BigDecimal(prices[1]);

                setMinPrice(min);
                setMaxPrice(max);
            } catch (Exception ignore) {/*NOOP*/}
        }
    }

    public void clearBrands() {
        if (tireBrands != null) {
            tireBrands.clear();
        }
    }

    public void clearTypes() {
        if (tireTypes != null) {
            tireTypes.clear();
        }
    }

    public void clearWidths() {
        if (tireWidths != null) {
            tireWidths.clear();
        }
    }

    public void clearProfiles() {
        if (tireProfiles != null) {
            tireProfiles.clear();
        }
    }

    public void clearDiameters() {
        if (tireDiameters != null) {
            tireDiameters.clear();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TireFilter that = (TireFilter) o;

        if (inStock != that.inStock) return false;
        if (tireBrands != null ? !tireBrands.equals(that.tireBrands) : that.tireBrands != null) return false;
        if (tireTypes != null ? !tireTypes.equals(that.tireTypes) : that.tireTypes != null) return false;
        if (tireWidths != null ? !tireWidths.equals(that.tireWidths) : that.tireWidths != null) return false;
        if (tireProfiles != null ? !tireProfiles.equals(that.tireProfiles) : that.tireProfiles != null) return false;
        if (tireDiameters != null ? !tireDiameters.equals(that.tireDiameters) : that.tireDiameters != null)
            return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
        return maxPrice != null ? maxPrice.equals(that.maxPrice) : that.maxPrice == null;

    }

    @Override
    public int hashCode() {
        int result = tireBrands != null ? tireBrands.hashCode() : 0;
        result = 31 * result + (tireTypes != null ? tireTypes.hashCode() : 0);
        result = 31 * result + (tireWidths != null ? tireWidths.hashCode() : 0);
        result = 31 * result + (tireProfiles != null ? tireProfiles.hashCode() : 0);
        result = 31 * result + (tireDiameters != null ? tireDiameters.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (inStock ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TireFilter{" +
                "tireBrands=" + tireBrands +
                ", tireTypes=" + tireTypes +
                ", tireWidths=" + tireWidths +
                ", tireProfiles=" + tireProfiles +
                ", tireDiameters=" + tireDiameters +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", inStock=" + inStock +
                ", price=" + price +
                '}';
    }
}
