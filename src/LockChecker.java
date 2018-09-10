public class LockChecker {

	static void myStaticMethod() {
		synchronized (LockChecker.class) {
			System.out.println("This is a static method");
			try {
				Thread.sleep(5000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	void myNonStaticMethod() {
		
		synchronized (LockChecker.class) {
			System.out.println("This is a non static method");	
		}
		

	}

	public static void main(String[] args) throws InterruptedException {
		final LockChecker main = new LockChecker();
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("thread 1 started");
				main.myStaticMethod();
				
				System.out.println("thread 1 ends");
			}
		};
		thread1.start();
		Thread.sleep(1000);
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("thread 2 started");
				main.myNonStaticMethod();
				System.out.println("thread 2 ends");
			}
		};
		thread2.start();
	}

}
