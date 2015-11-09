package springTest;

public class LazyLoad {
	ReferencedObjectTest reference;

	public ReferencedObjectTest getReference() {
		return reference;
	}

	public void setReference(ReferencedObjectTest reference) {
		this.reference = reference;
	}
	
}
