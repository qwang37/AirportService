package entityModel;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dataModel.PersonModel;
@Entity
@Table (name="Passenger")
public class Passenger extends PersonModel{

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Passenger_PassengerAddress", joinColumns=@JoinColumn(name="PassengerID"), 
	inverseJoinColumns=@JoinColumn(name="PassengerAddressID"))
	private Collection<PassengerAddress> passengerAddress = new HashSet<PassengerAddress>();
	
	public Collection<PassengerAddress> getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(Collection<PassengerAddress> passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
}
