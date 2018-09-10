
public class Huffman {
	
	
	public static void main(String[] args) {
		
		String a ="zbc";
		
		int a4=128;
		char a1=(char) a4;
		int i=a1;
		byte b1 = (byte)i;
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(i);
		
		String s = Integer.toBinaryString(i);
		System.out.println(s);
		
//		byte[] bytes = stringToBytesUTFCustom(a);
//		
//		for(int i=0; i<bytes.length; i++){
//			System.out.println(bytes[i]);
//		}
		
		
	}
	
	public static byte[] stringToBytesUTFCustom(String str) {
		
		System.out.println(str.length() << 1);
		
		 byte[] b = new byte[str.length() << 1];
		 for(int i = 0; i < str.length(); i++) {
		  char strChar = str.charAt(i);
		  int bpos = i << 1;
		  b[bpos] = (byte) ((strChar&0xFF00)>>8);
		  b[bpos + 1] = (byte) (strChar&0x00FF);
		 }
		 return b;
		}


}
