package by.chvertock.lathe.model.entities.lathe;

import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lathe_manufacturer")
@SQLInsert(
		sql = "INSERT INTO " +
				"lathe_manufacturer (name) values(?) " +
				"ON DUPLICATE KEY UPDATE " +
				"id = VALUES(id), " +
				"name = VALUES(name);"
)
public class LatheManufacturer extends Model {

	@Column(name = "name")
	private String name;

	public LatheManufacturer() {
	}

	public LatheManufacturer(String name) {
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
		if (!super.equals(o)) return false;

		LatheManufacturer that = (LatheManufacturer) o;

		return name != null ? name.equals(that.name) : that.name == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return name;
	}
}
