package entityModel;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import dataModel.AddressModel;
@Entity
public class PassengerAddress extends AddressModel{
	@ManyToMany(mappedBy="passengerAddress")
	private Collection<Passenger> passengers = new HashSet<Passenger>();
	public Collection<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}
}
