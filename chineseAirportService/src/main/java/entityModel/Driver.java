package entityModel;

import javax.persistence.Entity;
import javax.persistence.Table;

import dataModel.PersonModel;

@Entity
@Table (name="Driver")
public class Driver extends PersonModel{
	private String driverLicense;
	
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	
}
