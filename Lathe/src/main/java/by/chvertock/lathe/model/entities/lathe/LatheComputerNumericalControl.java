package by.chvertock.lathe.model.entities.lathe;


import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lathe_cnc")
@SQLInsert(
		sql = "INSERT INTO " +
				"lathe_cnc (name) values(?) " +
				"ON DUPLICATE KEY UPDATE " +
				"id = VALUES(id), " +
				"name = VALUES(name);"
)
public class LatheComputerNumericalControl extends Model {

	@Column(name="name", length = 64)
	private String name;

	public LatheComputerNumericalControl() {
	}

	public LatheComputerNumericalControl(String name) {
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

		LatheComputerNumericalControl that = (LatheComputerNumericalControl) o;

		return name != null ? name.equals(that.name) : that.name == null;

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
