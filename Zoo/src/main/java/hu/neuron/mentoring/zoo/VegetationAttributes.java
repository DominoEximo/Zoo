package hu.neuron.mentoring.zoo;

import java.util.Objects;

public class VegetationAttributes extends Attributes {

	private String soil;

	private Boolean blooms;

	private String timeOfBlooming;

	private Integer waterInterval;

	public VegetationAttributes(String origin, Boolean carnivore, String soil, Boolean blooms, String timeOfBlooming,
			Integer waterInterval) {
		super(origin, carnivore);
		this.soil = soil;
		this.blooms = blooms;
		this.timeOfBlooming = timeOfBlooming;
		this.waterInterval = waterInterval;

	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public Boolean getBlooms() {
		return blooms;
	}

	public void setBlooms(Boolean blooms) {
		this.blooms = blooms;
	}

	public String getTimeOfBlooming() {
		return timeOfBlooming;
	}

	public void setTimeOfBlooming(String timeOfBlooming) {
		this.timeOfBlooming = timeOfBlooming;
	}

	public Integer getWaterInterval() {
		return waterInterval;
	}

	public void setWaterInterval(Integer waterInterval) {
		this.waterInterval = waterInterval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(blooms, soil, timeOfBlooming, waterInterval);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetationAttributes other = (VegetationAttributes) obj;
		return Objects.equals(blooms, other.blooms) && Objects.equals(soil, other.soil)
				&& Objects.equals(timeOfBlooming, other.timeOfBlooming)
				&& Objects.equals(waterInterval, other.waterInterval);
	}

	@Override
	public String toString() {
		return "VegetationAttributes [soil=" + soil + ", blooms=" + blooms + ", timeOfBlooming=" + timeOfBlooming
				+ ", waterInterval=" + waterInterval + "]";
	}
	
	

}
