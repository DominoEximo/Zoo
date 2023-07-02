package hu.neuron.mentoring.zoo;

import java.util.Objects;

public class AnimalAttributes extends Attributes{

	

	private Integer feedingTime;
	
	private Boolean isDangerous;
	
	public AnimalAttributes(String origin, Boolean carnivore, Integer feedingTime, Boolean isDangerous) {
		super(origin, carnivore);
		this.feedingTime = feedingTime;
		this.isDangerous = isDangerous;
	}

	public Integer getFeedingTime() {
		return feedingTime;
	}

	public void setFeedingTime(Integer feedingTime) {
		this.feedingTime = feedingTime;
	}

	public Boolean getIsDangerous() {
		return isDangerous;
	}

	public void setIsDangerous(Boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(feedingTime, isDangerous);
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
		AnimalAttributes other = (AnimalAttributes) obj;
		return Objects.equals(feedingTime, other.feedingTime) && Objects.equals(isDangerous, other.isDangerous);
	}

	@Override
	public String toString() {
		return "AnimalAttributes [feedingTime=" + feedingTime + ", isDangerous=" + isDangerous + "]";
	}
	
	
}
