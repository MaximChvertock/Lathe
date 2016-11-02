/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.tire;

import by.chvertock.lathe.model.entities.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tire")
//@SQLInsert(
//        sql = "INSERT INTO " +
//                "tire (name) values(?) " +
//
//                "ON DUPLICATE KEY UPDATE " +
//
//                "id = VALUES(id), " +
//                "name = VALUES(name);"
//)
public class Tire extends Model {

    @NotNull(message = "Brand is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "brand_id")
    private TireBrand brand;

    @NotNull(message = "Type is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "type_id")
    private TireType type;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "image_id")
    private TireImage image;

    @NotNull(message = "Width is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "width_id")
    private TireWidth width;

    @NotNull(message = "Profile is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "profile_id")
    private TireProfile profile;

    @NotNull(message = "Diameter is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "diameter_id")
    private TireDiameter diameter;

    //    @NotNull(message = "Name is null")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Price is null")
    @Min(value = 0, message = "Price must been greater {value}")
    @Max(value = 99999999, message = "Price must been lower {value}")
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull(message = "In stock is null")
    @Min(value = 0, message = "In stock must been greater {value}")
    @Max(value = 99999, message = "In stock must been lower {value}")
    @Column(name = "in_stock")
    private Integer inStock;

    @Column(name = "description", length = 1024)
    private String description;

    public TireBrand getBrand() {
        return brand;
    }

    public void setBrand(TireBrand brand) {
        this.brand = brand;
    }

    public TireType getType() {
        return type;
    }

    public void setType(TireType type) {
        this.type = type;
    }

    public TireImage getImage() {
        return image;
    }

    public void setImage(TireImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TireWidth getWidth() {
        return width;
    }

    public void setWidth(TireWidth width) {
        this.width = width;
    }

    public TireProfile getProfile() {
        return profile;
    }

    public void setProfile(TireProfile profile) {
        this.profile = profile;
    }

    public TireDiameter getDiameter() {
        return diameter;
    }

    public void setDiameter(TireDiameter diameter) {
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tire tire = (Tire) o;

        if (brand != null ? !brand.equals(tire.brand) : tire.brand != null) return false;
        if (type != null ? !type.equals(tire.type) : tire.type != null) return false;
        if (image != null ? !image.equals(tire.image) : tire.image != null) return false;
        if (width != null ? !width.equals(tire.width) : tire.width != null) return false;
        if (profile != null ? !profile.equals(tire.profile) : tire.profile != null) return false;
        if (diameter != null ? !diameter.equals(tire.diameter) : tire.diameter != null) return false;
        if (name != null ? !name.equals(tire.name) : tire.name != null) return false;
        if (price != null ? !price.equals(tire.price) : tire.price != null) return false;
        if (inStock != null ? !inStock.equals(tire.inStock) : tire.inStock != null) return false;
        return description != null ? description.equals(tire.description) : tire.description == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (inStock != null ? inStock.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "id=" + getId() +
                ", brand=" + brand +
                ", type=" + type +
                ", image=" + image +
                ", width=" + width +
                ", profile=" + profile +
                ", diameter=" + diameter +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", description='" + description + '\'' +
                '}';
    }
}
