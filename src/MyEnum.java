

public enum MyEnum {

	INSTANCE(10),
	FIRST,SECOND,THIRD;
	
	private MyEnum() {
		
	}
	
	private MyEnum(int a) {
		s1=a;
	}
	
	private int s1;
	
	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}
	
}
