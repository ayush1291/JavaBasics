package designPattern;

public class Proxy {
	

	public static void main(String[] args) {
		
		ProxtRealClass proxyClass = new ProxtRealClass(new RealClass());
		
		myMethod(proxyClass);
		
		
	}

	
	//We shud never include private methods with @transactional, as then subclass wont be able to access this method
	public static void myMethod(/*RealClass */ProxtRealClass sample){
		
//		sample.notpart();				// this cannot be done if we have interface proxy, so we shud use interface with interface, or class with class
		sample.run();
		
	}
	
	
	public static class ProxtRealClass implements Sample{

		public RealClass realClass;
		
		public void before(){
			System.out.println(" Before running proxy method");
		}
		
		public ProxtRealClass(RealClass realClass) {
			before();
			this.realClass=realClass;
		}
		
		@Override
		public void run() {
			realClass.run();
		}

		// This method here does not run proxy as the real object calls this and not using proxy
		@Override
		public void run1() {
			System.out.println(" Before run1 proxy is running");
			realClass.run1();
		}
		
	}
	
	public static interface Sample{
		public void run();
		public void run1();
	}
	
	
	public static class RealClass implements Sample{
		
		public void run(){
			System.out.println(" Real is running");
			run1();
		}
		
		public void run1(){
			System.out.println(" Real is running");
		}
		
		public void notpart(){
			System.out.println("Not part of interface");
		}
	}
}
