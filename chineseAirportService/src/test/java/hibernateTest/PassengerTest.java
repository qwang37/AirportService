package hibernateTest;

import org.junit.Test;

import businessService.DataAccessService;
import entityModel.Passenger;
import entityModel.PassengerAddress;

public class PassengerTest {
	@Test
	public void setFunctionTest(){
		DataAccessService dataAccessService = DataAccessService.getDataAccessServiceInstance();
		Passenger p = new Passenger();
		p.setFirstName("firstName");
		p.setLastName("lastName");
		PassengerAddress pAddress = new PassengerAddress();
		pAddress.setCity("city");
		pAddress.setLine1("line1");
		p.getPassengerAddress().add(pAddress);
		pAddress.getPassengers().add(p);
		dataAccessService.openSession();
		dataAccessService.save(p);
		dataAccessService.closeSession();
	}
}
