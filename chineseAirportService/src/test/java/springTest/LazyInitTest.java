package springTest;

public class LazyInitTest {
	ReferencedObjectTest reference;

	public ReferencedObjectTest getReference() {
		return reference;
	}

	public void setReference(ReferencedObjectTest reference) {
		this.reference = reference;
	}
	
}
