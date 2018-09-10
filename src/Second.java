
public class Second implements ApplicationContextAware{
	private int id;
	public String name;
	int i=2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void dosth(int i) {
		this.i=i;
		System.out.println("Do Sth in object is called");
		
	}
}
