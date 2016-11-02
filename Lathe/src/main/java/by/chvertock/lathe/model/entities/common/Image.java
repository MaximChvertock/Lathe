package by.chvertock.lathe.model.entities.common;

import by.chvertock.lathe.model.entities.Model;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@SQLInsert(
		sql = "INSERT INTO " +
				"image (file_name) values(?) " +
				"ON DUPLICATE KEY UPDATE " +
				"id = VALUES(id), " +
				"file_name = VALUES(file_name);"
)
public class Image extends Model {

	@Column(name = "file_name")
	private String fileName;

	public Image() {
	}

	public Image(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Image image = (Image) o;

		return fileName != null ? fileName.equals(image.fileName) : image.fileName == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return fileName;
	}
}
