package designPattern;

public  abstract class Template<P,R> {
	boolean isCancelled=false;
	
	
	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	final public void execute(P p){
		onpreExecute();
		R r = doinBack(p);
		
		if(isCancelled){
			onCancelled(r);
		}else{
			onPostExecute(r);
		}
		
		
		
	}
	
	public abstract void onpreExecute();
	
	public abstract R doinBack(P p);
	
	public abstract void onPostExecute(R r);
	
	public abstract void onCancelled(R r);
	
	
	public static void main(String[] args) {
		
	}
	
	public static class User extends Template<String, String>{

		@Override
		public void onpreExecute() {
			System.out.println("I am doing before background");
			
		}

		@Override
		public String doinBack(String p) {
			System.out.println("I am doing in background");
			return "Returned";
		}

		@Override
		public void onPostExecute(String r) {
			System.out.println("I am doing after background  "+r);
			
		}

		@Override
		public void onCancelled(String r) {
			// TODO Auto-generated method stub
			System.out.println("I am doing after cancelled  "+r);
		}
		
	}
	
}
