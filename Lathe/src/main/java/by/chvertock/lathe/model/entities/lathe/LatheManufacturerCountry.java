package by.chvertock.lathe.model.entities.lathe;

import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lathe_manufacturer_country")
@SQLInsert(
		sql = "INSERT INTO " +
				"lathe_manufacturer_country (name) values(?) " +
				"ON DUPLICATE KEY UPDATE " +
				"id = VALUES(id), " +
				"name = VALUES(name);"
)
public class LatheManufacturerCountry extends Model {

	@Column(name = "name")
	private String name;

	public LatheManufacturerCountry() {
	}

	public LatheManufacturerCountry(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LatheManufacturerCountry country = (LatheManufacturerCountry) o;

		return name != null ? name.equals(country.name) : country.name == null;

	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return name;
	}
}