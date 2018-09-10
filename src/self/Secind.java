package self;

public class Secind {

	public static void main(String[] args) {
		
		A1 a = new B1();
		System.out.println(a.getClass().getName());
		
	}
	
	static class A1{
		public void write(){
			System.out.println("Write A");
		}
	}
	
	static class B1 extends A1{
		
		public void write(){
			System.out.println("Write B");
		}
	}
	
	public static class A implements Cloneable{
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
		
	}
	
}
