package by.chvertock.lathe.model.beans.lathe;


import by.chvertock.lathe.model.entities.lathe.LatheManufacturer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LatheFilter {
	private List<LatheManufacturer> latheManufacturers = new ArrayList<>();

	private BigDecimal minPrice;
	private BigDecimal maxPrice;

	private String price;

	public List<LatheManufacturer> getLatheManufacturers() {
		return latheManufacturers;
	}

	public void setLatheManufacturers(List<LatheManufacturer> latheManufacturers) {
		this.latheManufacturers = latheManufacturers;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void clearBrands() {
		if (latheManufacturers != null) {
			latheManufacturers.clear();
		}
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LatheFilter that = (LatheFilter) o;

		if (latheManufacturers != null ? !latheManufacturers.equals(that.latheManufacturers) : that.latheManufacturers != null)
			return false;
		if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
		if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
		return price != null ? price.equals(that.price) : that.price == null;

	}

	@Override
	public int hashCode() {
		int result = latheManufacturers != null ? latheManufacturers.hashCode() : 0;
		result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
		result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "LatheFilter{" +
				"latheManufacturers=" + latheManufacturers +
				", minPrice=" + minPrice +
				", maxPrice=" + maxPrice +
				", price='" + price + '\'' +
				'}';
	}
}
