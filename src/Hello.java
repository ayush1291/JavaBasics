import java.text.DecimalFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class Hello {
	
	static int a;
	
	
	
	
	/*public enum OPTION{
		ONE,TWO;
		
		private String main(){
			System.out.println("main");
			a=2;
			return "main";
		}
		
		public static void hello(){
			System.out.println("Hello");
		}
	}*/
	public static void myMethod(){
		
	}
	
	 public static final Pattern EMAIL_ADDRESS
     = Pattern.compile(
         "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
         "\\@" +
         "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
         "(" +
             "\\." +
             "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
         ")+"
     );
	 public static  void findAndSetEmi(double P, double R, double N){

			double r 			= 	R;
			double c5 			= 	P;
			double c9 			= 	N;
			double c6 			= 	r / 100;
			double c7 			= 	12;
			double pq 			=	 Math.pow((1 + c6 / c7), (c9));
			double zz 			= 	((double) Math.round(pq * 100)) / 100;
			double emi 			= 	(c5 * (c6 / c7))/ (1 - (1 / (pq)));
			double a1 			= 	((double) Math.round(emi * 100)) / 100;
			DecimalFormat df 	= 	new DecimalFormat("#.##");
			
			
			//System.out.println(" df.format(a1) "+df.format(a1) );
			

			int progress = Math.round((Float.parseFloat(df.format(a1))));
			double emi1 = Double.parseDouble(df.format(a1));
				System.out.println((emi1));
			}
		
	
	public static void main(String[] args) {
		findAndSetEmi(10000000, 10, 36);
		
		
		/*SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");
		try {
			java.util.Date dDate = sdfmt1.parse( "12/13/1991" );
		} catch (ParseException e) {
			System.out.println("Not");
			e.printStackTrace();
		}*/
		
	/*	System.out.println(EMAIL_ADDRESS.matcher("ayush@gfka.com.com").matches());
		
		myMethod();
		
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Date today = new Date();

		try {
			String now =formatter.format(today);
			//Date todayWithZeroTime = formatter.parse(formatter.format(today));
			//formatter.format(todayWithZeroTime);
			
			System.out.println(""+now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		
	/*	Second sec = new Second();
		sec.setName("Ayush");
		hello(sec);*/
		/*MyEnum.INSTANCE.setS1(5);
		MyEnum.INSTANCE.setS1(8);
		System.out.println(MyEnum.INSTANCE.getS1());
		*/
//		Hash hash = new Hash(4);
//		hash.put("one", "ayush");
//		hash.put("two", "ayush1");
//		hash.put("three", "ayush2");
//		hash.put("four", "ayush3");
//		hash.put("one", "ayush5");
		Date def = new Date();
		Date d1 = new Date(2017,10,10);
		Date d2 = new Date(2017,10,10);
		
		if(d1 == d2)
		{
			System.out.println("true1");
		}
		if(d1.equals(d2))
		{
			System.out.println("true2");
		}
		
		/*System.out.println(MyEnum.FIRST);
		
		Hello.OPTION.hello();
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	    String dateInString = dateFormat.format(date);
	    System.out.println(dateInString);*/
		
		
	}

	
	/*public static void hello(Object second){
		
		if(second instanceof ApplicationContextAware){
			((ApplicationContextAware) second).dosth(3);
			System.out.println("Yes");
		}
		
	}*/
	
}
