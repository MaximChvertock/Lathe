//package by.chvertock.lathe.model.entities.lathe;
//
//import by.chvertock.lathe.model.entities.Model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "lathe_image")
//public class LatheImage extends Model {
//
//	@Column(name = "file_name")
//	private String fileName;
//
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "lathe_id"/*, nullable = false*/)
//	private Lathe lathe;
//
//	public String getFileName() {
//		return fileName;
//	}
//
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//
//	public Lathe getLathe() {
//		return lathe;
//	}
//
//	public void setLathe(Lathe lathe) {
//		this.lathe = lathe;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//
//		LatheImage that = (LatheImage) o;
//
//		if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
//		return lathe != null ? lathe.equals(that.lathe) : that.lathe == null;
//
//	}
//
//	@Override
//	public int hashCode() {
//		int result = fileName != null ? fileName.hashCode() : 0;
//		result = 31 * result + (lathe != null ? lathe.hashCode() : 0);
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "LatheImage{" +
//				"fileName='" + fileName + '\'' +
//				", lathe=" + lathe +
//				'}';
//	}
//}
