package by.chvertock.lathe.model.entities.lathe;

import by.chvertock.lathe.model.entities.Model;
import by.chvertock.lathe.model.entities.common.Country;
import by.chvertock.lathe.model.entities.common.Image;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lathe")
public class Lathe extends Model {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id")
	private LatheManufacturer manufacturer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private LatheType type;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_country_id")
	private LatheManufacturerCountry manufacturerCountry;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cnc_id")
	private LatheComputerNumericalControl computerNumericalControl;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id")
	private Country location;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "tool_holder_type_id")
	private LatheToolHolderType toolHolderType;

	@Column(name = "model", length = 128)
	private String model;

	@Column(name = "production_year", length = 4)
	private String productionYear;

	@Column(name = "max_processing_diameter")
	private Integer maxProcessingDiameter;

	@Column(name = "processing_diameter")
	private Integer processingDiameter;

	@Column(name = "spindle_rod_diameter", length = 32)
	private String spindleRodDiameter;

	@Column(name = "max_processing_length")
	private Integer maxProcessingLength;

	@Column(name = "x_axis")
	private Integer xAxis;

	@Column(name = "y_axis")
	private Integer yAxis;

	@Column(name = "z_axis")
	private Integer zAxis;

	@Column(name = "spindle_angle_speed")
	private Integer spindleAngleSpeed;

	@Column(name = "spindle_power", length = 32)
	private String spindlePower;

	@Column(name = "spindle_bore_diameter", length = 32)
	private String spindleBoreDiameter;

	@Column(name = "counter_spindle_avail", length = 16)
	private String counterSpindleAvailable;

	@Column(name = "counter_spindle_angle_speed")
	private Integer counterSpindleAngleSpeed;

	@Column(name = "tools_amount", length = 16)
	private String toolsAmount;

	@Column(name = "driving_tools_amount", length = 16)
	private String drivingToolsAmount;

	@Column(name = "non_driving_tools_amount", length = 16)
	private String nonDrivingToolsAmount;

	@Column(name = "tailstock_avail", length = 16)
	private String tailStockAvailable;

	@Column(name = "positioning_accuracy", length = 32)
	private String positioningAccuracy;

	@Column(name = "positioning_accuracy_deg", length = 32)
	private String positioningAccuracyInDegrees;

	@Column(name = "spindle_hours")
	private Integer spindleHours;

	@Column(name = "lathe_hours")
	private Integer latheHours;

	@Column(name = "price", precision = 10, scale = 2)
	private BigDecimal price;

	@Column(name = "lathe_condition")
	private String condition;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "lathe_image",
			joinColumns = @JoinColumn(name = "lathe_id"),
			inverseJoinColumns = @JoinColumn(name = "image_id")
	)
	private Set<Image> images = new HashSet<Image>();

	public LatheManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(LatheManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LatheType getType() {
		return type;
	}

	public void setType(LatheType type) {
		this.type = type;
	}

	public LatheManufacturerCountry getManufacturerCountry() {
		return manufacturerCountry;
	}

	public void setManufacturerCountry(LatheManufacturerCountry manufacturerCountry) {
		this.manufacturerCountry = manufacturerCountry;
	}

	public LatheComputerNumericalControl getComputerNumericalControl() {
		return computerNumericalControl;
	}

	public void setComputerNumericalControl(LatheComputerNumericalControl computerNumericalControl) {
		this.computerNumericalControl = computerNumericalControl;
	}

	public Country getLocation() {
		return location;
	}

	public void setLocation(Country location) {
		this.location = location;
	}

	public LatheToolHolderType getToolHolderType() {
		return toolHolderType;
	}

	public void setToolHolderType(LatheToolHolderType toolHolderType) {
		this.toolHolderType = toolHolderType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public Integer getMaxProcessingDiameter() {
		return maxProcessingDiameter;
	}

	public void setMaxProcessingDiameter(Integer maxProcessingDiameter) {
		this.maxProcessingDiameter = maxProcessingDiameter;
	}

	public Integer getProcessingDiameter() {
		return processingDiameter;
	}

	public void setProcessingDiameter(Integer processingDiameter) {
		this.processingDiameter = processingDiameter;
	}

	public String getSpindleRodDiameter() {
		return spindleRodDiameter;
	}

	public void setSpindleRodDiameter(String spindleRodDiameter) {
		this.spindleRodDiameter = spindleRodDiameter;
	}

	public Integer getMaxProcessingLength() {
		return maxProcessingLength;
	}

	public void setMaxProcessingLength(Integer maxProcessingLength) {
		this.maxProcessingLength = maxProcessingLength;
	}

	public Integer getxAxis() {
		return xAxis;
	}

	public void setxAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}

	public Integer getyAxis() {
		return yAxis;
	}

	public void setyAxis(Integer yAxis) {
		this.yAxis = yAxis;
	}

	public Integer getzAxis() {
		return zAxis;
	}

	public void setzAxis(Integer zAxis) {
		this.zAxis = zAxis;
	}

	public Integer getSpindleAngleSpeed() {
		return spindleAngleSpeed;
	}

	public void setSpindleAngleSpeed(Integer spindleAngleSpeed) {
		this.spindleAngleSpeed = spindleAngleSpeed;
	}

	public String getSpindlePower() {
		return spindlePower;
	}

	public void setSpindlePower(String spindlePower) {
		this.spindlePower = spindlePower;
	}

	public String getSpindleBoreDiameter() {
		return spindleBoreDiameter;
	}

	public void setSpindleBoreDiameter(String spindleBoreDiameter) {
		this.spindleBoreDiameter = spindleBoreDiameter;
	}

	public String getCounterSpindleAvailable() {
		return counterSpindleAvailable;
	}

	public void setCounterSpindleAvailable(String counterSpindleAvailable) {
		this.counterSpindleAvailable = counterSpindleAvailable;
	}

	public Integer getCounterSpindleAngleSpeed() {
		return counterSpindleAngleSpeed;
	}

	public void setCounterSpindleAngleSpeed(Integer counterSpindleAngleSpeed) {
		this.counterSpindleAngleSpeed = counterSpindleAngleSpeed;
	}

	public String getToolsAmount() {
		return toolsAmount;
	}

	public void setToolsAmount(String toolsAmount) {
		this.toolsAmount = toolsAmount;
	}

	public String getDrivingToolsAmount() {
		return drivingToolsAmount;
	}

	public void setDrivingToolsAmount(String drivingToolsAmount) {
		this.drivingToolsAmount = drivingToolsAmount;
	}

	public String getNonDrivingToolsAmount() {
		return nonDrivingToolsAmount;
	}

	public void setNonDrivingToolsAmount(String nonDrivingToolsAmount) {
		this.nonDrivingToolsAmount = nonDrivingToolsAmount;
	}

	public String getTailStockAvailable() {
		return tailStockAvailable;
	}

	public void setTailStockAvailable(String tailStockAvailable) {
		this.tailStockAvailable = tailStockAvailable;
	}

	public String getPositioningAccuracy() {
		return positioningAccuracy;
	}

	public void setPositioningAccuracy(String positioningAccuracy) {
		this.positioningAccuracy = positioningAccuracy;
	}

	public String getPositioningAccuracyInDegrees() {
		return positioningAccuracyInDegrees;
	}

	public void setPositioningAccuracyInDegrees(String positioningAccuracyInDegrees) {
		this.positioningAccuracyInDegrees = positioningAccuracyInDegrees;
	}

	public Integer getSpindleHours() {
		return spindleHours;
	}

	public void setSpindleHours(Integer spindleHours) {
		this.spindleHours = spindleHours;
	}

	public Integer getLatheHours() {
		return latheHours;
	}

	public void setLatheHours(Integer latheHours) {
		this.latheHours = latheHours;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Lathe lathe = (Lathe) o;

		if (manufacturer != null ? !manufacturer.equals(lathe.manufacturer) : lathe.manufacturer != null) return false;
		if (type != null ? !type.equals(lathe.type) : lathe.type != null) return false;
		if (manufacturerCountry != null ? !manufacturerCountry.equals(lathe.manufacturerCountry) : lathe.manufacturerCountry != null)
			return false;
		if (computerNumericalControl != null ? !computerNumericalControl.equals(lathe.computerNumericalControl) : lathe.computerNumericalControl != null)
			return false;
		if (location != null ? !location.equals(lathe.location) : lathe.location != null) return false;
		if (toolHolderType != null ? !toolHolderType.equals(lathe.toolHolderType) : lathe.toolHolderType != null)
			return false;
		if (model != null ? !model.equals(lathe.model) : lathe.model != null) return false;
		if (productionYear != null ? !productionYear.equals(lathe.productionYear) : lathe.productionYear != null)
			return false;
		if (maxProcessingDiameter != null ? !maxProcessingDiameter.equals(lathe.maxProcessingDiameter) : lathe.maxProcessingDiameter != null)
			return false;
		if (processingDiameter != null ? !processingDiameter.equals(lathe.processingDiameter) : lathe.processingDiameter != null)
			return false;
		if (spindleRodDiameter != null ? !spindleRodDiameter.equals(lathe.spindleRodDiameter) : lathe.spindleRodDiameter != null)
			return false;
		if (maxProcessingLength != null ? !maxProcessingLength.equals(lathe.maxProcessingLength) : lathe.maxProcessingLength != null)
			return false;
		if (xAxis != null ? !xAxis.equals(lathe.xAxis) : lathe.xAxis != null) return false;
		if (yAxis != null ? !yAxis.equals(lathe.yAxis) : lathe.yAxis != null) return false;
		if (zAxis != null ? !zAxis.equals(lathe.zAxis) : lathe.zAxis != null) return false;
		if (spindleAngleSpeed != null ? !spindleAngleSpeed.equals(lathe.spindleAngleSpeed) : lathe.spindleAngleSpeed != null)
			return false;
		if (spindlePower != null ? !spindlePower.equals(lathe.spindlePower) : lathe.spindlePower != null) return false;
		if (spindleBoreDiameter != null ? !spindleBoreDiameter.equals(lathe.spindleBoreDiameter) : lathe.spindleBoreDiameter != null)
			return false;
		if (counterSpindleAvailable != null ? !counterSpindleAvailable.equals(lathe.counterSpindleAvailable) : lathe.counterSpindleAvailable != null)
			return false;
		if (counterSpindleAngleSpeed != null ? !counterSpindleAngleSpeed.equals(lathe.counterSpindleAngleSpeed) : lathe.counterSpindleAngleSpeed != null)
			return false;
		if (toolsAmount != null ? !toolsAmount.equals(lathe.toolsAmount) : lathe.toolsAmount != null) return false;
		if (drivingToolsAmount != null ? !drivingToolsAmount.equals(lathe.drivingToolsAmount) : lathe.drivingToolsAmount != null)
			return false;
		if (nonDrivingToolsAmount != null ? !nonDrivingToolsAmount.equals(lathe.nonDrivingToolsAmount) : lathe.nonDrivingToolsAmount != null)
			return false;
		if (tailStockAvailable != null ? !tailStockAvailable.equals(lathe.tailStockAvailable) : lathe.tailStockAvailable != null)
			return false;
		if (positioningAccuracy != null ? !positioningAccuracy.equals(lathe.positioningAccuracy) : lathe.positioningAccuracy != null)
			return false;
		if (positioningAccuracyInDegrees != null ? !positioningAccuracyInDegrees.equals(lathe.positioningAccuracyInDegrees) : lathe.positioningAccuracyInDegrees != null)
			return false;
		if (spindleHours != null ? !spindleHours.equals(lathe.spindleHours) : lathe.spindleHours != null) return false;
		if (latheHours != null ? !latheHours.equals(lathe.latheHours) : lathe.latheHours != null) return false;
		if (price != null ? !price.equals(lathe.price) : lathe.price != null) return false;
		if (condition != null ? !condition.equals(lathe.condition) : lathe.condition != null) return false;
		return images != null ? images.equals(lathe.images) : lathe.images == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (manufacturerCountry != null ? manufacturerCountry.hashCode() : 0);
		result = 31 * result + (computerNumericalControl != null ? computerNumericalControl.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (toolHolderType != null ? toolHolderType.hashCode() : 0);
		result = 31 * result + (model != null ? model.hashCode() : 0);
		result = 31 * result + (productionYear != null ? productionYear.hashCode() : 0);
		result = 31 * result + (maxProcessingDiameter != null ? maxProcessingDiameter.hashCode() : 0);
		result = 31 * result + (processingDiameter != null ? processingDiameter.hashCode() : 0);
		result = 31 * result + (spindleRodDiameter != null ? spindleRodDiameter.hashCode() : 0);
		result = 31 * result + (maxProcessingLength != null ? maxProcessingLength.hashCode() : 0);
		result = 31 * result + (xAxis != null ? xAxis.hashCode() : 0);
		result = 31 * result + (yAxis != null ? yAxis.hashCode() : 0);
		result = 31 * result + (zAxis != null ? zAxis.hashCode() : 0);
		result = 31 * result + (spindleAngleSpeed != null ? spindleAngleSpeed.hashCode() : 0);
		result = 31 * result + (spindlePower != null ? spindlePower.hashCode() : 0);
		result = 31 * result + (spindleBoreDiameter != null ? spindleBoreDiameter.hashCode() : 0);
		result = 31 * result + (counterSpindleAvailable != null ? counterSpindleAvailable.hashCode() : 0);
		result = 31 * result + (counterSpindleAngleSpeed != null ? counterSpindleAngleSpeed.hashCode() : 0);
		result = 31 * result + (toolsAmount != null ? toolsAmount.hashCode() : 0);
		result = 31 * result + (drivingToolsAmount != null ? drivingToolsAmount.hashCode() : 0);
		result = 31 * result + (nonDrivingToolsAmount != null ? nonDrivingToolsAmount.hashCode() : 0);
		result = 31 * result + (tailStockAvailable != null ? tailStockAvailable.hashCode() : 0);
		result = 31 * result + (positioningAccuracy != null ? positioningAccuracy.hashCode() : 0);
		result = 31 * result + (positioningAccuracyInDegrees != null ? positioningAccuracyInDegrees.hashCode() : 0);
		result = 31 * result + (spindleHours != null ? spindleHours.hashCode() : 0);
		result = 31 * result + (latheHours != null ? latheHours.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (condition != null ? condition.hashCode() : 0);
		result = 31 * result + (images != null ? images.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Lathe{" +
				"manufacturer=" + manufacturer +
				", type=" + type +
				", manufacturerCountry=" + manufacturerCountry +
				", computerNumericalControl=" + computerNumericalControl +
				", location=" + location +
				", toolHolderType=" + toolHolderType +
				", model='" + model + '\'' +
				", productionYear='" + productionYear + '\'' +
				", maxProcessingDiameter=" + maxProcessingDiameter +
				", processingDiameter=" + processingDiameter +
				", spindleRodDiameter='" + spindleRodDiameter + '\'' +
				", maxProcessingLength=" + maxProcessingLength +
				", xAxis=" + xAxis +
				", yAxis=" + yAxis +
				", zAxis=" + zAxis +
				", spindleAngleSpeed=" + spindleAngleSpeed +
				", spindlePower='" + spindlePower + '\'' +
				", spindleBoreDiameter='" + spindleBoreDiameter + '\'' +
				", counterSpindleAvailable='" + counterSpindleAvailable + '\'' +
				", counterSpindleAngleSpeed=" + counterSpindleAngleSpeed +
				", toolsAmount='" + toolsAmount + '\'' +
				", drivingToolsAmount='" + drivingToolsAmount + '\'' +
				", nonDrivingToolsAmount='" + nonDrivingToolsAmount + '\'' +
				", tailStockAvailable='" + tailStockAvailable + '\'' +
				", positioningAccuracy='" + positioningAccuracy + '\'' +
				", positioningAccuracyInDegrees='" + positioningAccuracyInDegrees + '\'' +
				", spindleHours=" + spindleHours +
				", latheHours=" + latheHours +
				", price=" + price +
				", condition='" + condition + '\'' +
				", images=" + images +
				'}';
	}
}

