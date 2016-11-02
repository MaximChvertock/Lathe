/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.entities.wheel;

import by.chvertock.lathe.model.entities.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "wheel")
public class Wheel extends Model {

    @NotNull(message = "Brand is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "brand_id")
    private WheelBrand brand;

    @NotNull(message = "Type is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "type_id")
    private WheelType type;

    @NotNull(message = "Material is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "material_id")
    private WheelMaterial material;

    @NotNull(message = "Image is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "image_id")
    private WheelImage image;

    @NotNull(message = "Width is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "width_id")
    private WheelWidth width;

    @NotNull(message = "Diameter is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "diameter_id")
    private WheelDiameter diameter;

    @NotNull(message = "Mount is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "mount_id")
    private WheelMount mount;

    @NotNull(message = "PCD is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "pcd_id")
    private WheelPcd pcd;

    @NotNull(message = "Dia is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "dia_id")
    private WheelDia dia;

    @NotNull(message = "ET is NULL")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "et_id")
    private WheelEt et;

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

    @NotNull(message = "Weight is NULL")
    @Column(name = "weight")
    private Integer weight;

    public WheelBrand getBrand() {
        return brand;
    }

    public void setBrand(WheelBrand brand) {
        this.brand = brand;
    }

    public WheelType getType() {
        return type;
    }

    public void setType(WheelType type) {
        this.type = type;
    }

    public WheelMaterial getMaterial() {
        return material;
    }

    public void setMaterial(WheelMaterial material) {
        this.material = material;
    }

    public WheelImage getImage() {
        return image;
    }

    public void setImage(WheelImage image) {
        this.image = image;
    }

    public WheelWidth getWidth() {
        return width;
    }

    public void setWidth(WheelWidth width) {
        this.width = width;
    }

    public WheelDiameter getDiameter() {
        return diameter;
    }

    public void setDiameter(WheelDiameter diameter) {
        this.diameter = diameter;
    }

    public WheelMount getMount() {
        return mount;
    }

    public void setMount(WheelMount mount) {
        this.mount = mount;
    }

    public WheelPcd getPcd() {
        return pcd;
    }

    public void setPcd(WheelPcd pcd) {
        this.pcd = pcd;
    }

    public WheelDia getDia() {
        return dia;
    }

    public void setDia(WheelDia dia) {
        this.dia = dia;
    }

    public WheelEt getEt() {
        return et;
    }

    public void setEt(WheelEt et) {
        this.et = et;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Wheel wheel = (Wheel) o;

        if (brand != null ? !brand.equals(wheel.brand) : wheel.brand != null) return false;
        if (type != null ? !type.equals(wheel.type) : wheel.type != null) return false;
        if (material != null ? !material.equals(wheel.material) : wheel.material != null) return false;
        if (image != null ? !image.equals(wheel.image) : wheel.image != null) return false;
        if (width != null ? !width.equals(wheel.width) : wheel.width != null) return false;
        if (diameter != null ? !diameter.equals(wheel.diameter) : wheel.diameter != null) return false;
        if (mount != null ? !mount.equals(wheel.mount) : wheel.mount != null) return false;
        if (pcd != null ? !pcd.equals(wheel.pcd) : wheel.pcd != null) return false;
        if (dia != null ? !dia.equals(wheel.dia) : wheel.dia != null) return false;
        if (et != null ? !et.equals(wheel.et) : wheel.et != null) return false;
        if (name != null ? !name.equals(wheel.name) : wheel.name != null) return false;
        if (price != null ? !price.equals(wheel.price) : wheel.price != null) return false;
        if (inStock != null ? !inStock.equals(wheel.inStock) : wheel.inStock != null) return false;
        if (description != null ? !description.equals(wheel.description) : wheel.description != null) return false;
        return weight != null ? weight.equals(wheel.weight) : wheel.weight == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (mount != null ? mount.hashCode() : 0);
        result = 31 * result + (pcd != null ? pcd.hashCode() : 0);
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (et != null ? et.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (inStock != null ? inStock.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + getId() +
                ", brand=" + brand +
                ", type=" + type +
                ", material=" + material +
                ", image=" + image +
                ", width=" + width +
                ", diameter=" + diameter +
                ", mount=" + mount +
                ", pcd=" + pcd +
                ", dia=" + dia +
                ", et=" + et +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
