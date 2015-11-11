package hibernateTest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestHibernateModel {
	@Id
	int testInt;
	String testString;
	public int getTestInt() {
		return testInt;
	}
	public void setTestInt(int testInt) {
		this.testInt = testInt;
	}
	public String getTestString() {
		return testString;
	}
	public void setTestString(String testString) {
		this.testString = testString;
	}
	
}
