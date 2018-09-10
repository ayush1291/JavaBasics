import java.security.DigestException;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
public class Encryp {




	public static final double MAXAMOUNT = 99999999999999.99;
	public static final double MINAMOUNT = 0.0;
	public static final double MAXTENURE = 999;
	public static final double MINTENURE = 0;
	public static final int MAXSEQUENCE = 99999999; 
	public static final int MINSEQUENCE = 0;
	public static final int SEQUENCE = 99999999;
	public static final String ORACLE_DATE_FORMAT = "DD/MM/YYYY HH24:MI:SS";
	public static final String ORACLE_DATE_FORMAT_RRRR = "DD/MM/RRRR HH24:MI:SS";
	public static final String ORACLE_DATE_FORMAT_SEARCH = "DD/MM/YYYY";



public static String encryptedPassword(String p_userName, String p_password,String p_token) {

              String encryptedPassword = "";
              //System.out.println("p_token"+p_token);
              String shaPassword = sha1(p_password.trim()+p_token);
              //System.out.println("shaPassword "+shaPassword);
              try {
                     String rsaPassword = rsa(p_password.trim());
                     rsaPassword = rsaPassword.substring(0, 32);
                     String basePassword = base(p_password.trim(), p_userName.trim());
                     //System.out.println("Base................." + basePassword);
                     //System.out.println("Sha1" + shaPassword);
                     //System.out.println("rsa" + rsaPassword);
                     for (int i = 0; i <= 15; i++) {
                           encryptedPassword = encryptedPassword.concat(shaPassword
                                         .substring(0, 2));
                           shaPassword = shaPassword.substring(2);
                           encryptedPassword = encryptedPassword.concat(rsaPassword
                                         .substring(0, 2));
                           rsaPassword = rsaPassword.substring(2);
                           encryptedPassword = encryptedPassword.concat(basePassword
                                         .substring(0, 2));
                           basePassword = basePassword.substring(2);
                     }
                     encryptedPassword = encryptedPassword.concat(shaPassword);
                     //System.out.println("length" + encryptedPassword.length());
                     //System.out.println("Password>>>>>>>>>>>>>>>>>>>>>>>>>:"+ encryptedPassword);

              } catch (InvalidKeyException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (NoSuchAlgorithmException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (InvalidKeySpecException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (NoSuchPaddingException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (IllegalStateException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (ShortBufferException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (IllegalBlockSizeException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              } catch (BadPaddingException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
              return encryptedPassword;
       }




 public static void main(String args[]) throws Exception{
	  String encryptedPssword = "";
	   
        Random rn = new Random();
      String p_token=  String.valueOf(rn.nextInt(100000000));
//		String p_token="94861775";
//	  encryptedPssword=encryptedPassword("AGENCY1","Aajtak2016@",p_token);
//		encryptedPssword=encryptedPassword("akash","Nsel@123",p_token);
	//		encryptedPssword=encryptedPassword("fiagent2","Agent@1234",p_token);
//				encryptedPssword=encryptedPassword("ciaagent","Opkey@123",p_token);
			encryptedPssword=encryptedPassword("SACHIN","Sachin@123",p_token);
/*	  String base64 = getBase64String(encryptedPssword);
	  System.out.println("base64:"+base64);
	  
	  String userId = "MAKER_CC";//;"AG_01";
	  System.out.println("base64:"+base64.length());
	  String password= decrypt(base64, userId);
	  System.out.println("Password" +password);
	  String token = "55016538";
	  
	String decryptedPasswordDB = decrypt(getBase64String(encryptedPssword), userId);
 System.out.println("decryptedPasswordDB" +decryptedPasswordDB);
	String 	shaPassword = sha1(decryptedPasswordDB+token);		  
	    System.out.println("shaPassword" +shaPassword);
	  
		String rsaPassword = rsa(decryptedPasswordDB.trim());
		System.out.println(rsaPassword);
		rsaPassword = rsaPassword.substring(0, 32);
		System.out.println(rsaPassword);
		String basePassword = base(decryptedPasswordDB.trim(), userId.trim());
		System.out.println(basePassword);
		String encryptedPassword="";
		for (int i = 0; i <= 15; i++) {
						encryptedPassword = encryptedPassword.concat(shaPassword
								.substring(0, 2));
						shaPassword = shaPassword.substring(2);
						encryptedPassword = encryptedPassword.concat(rsaPassword
								.substring(0, 2));
						rsaPassword = rsaPassword.substring(2);
						encryptedPassword = encryptedPassword.concat(basePassword
								.substring(0, 2));
						basePassword = basePassword.substring(2);
					}
		System.out.println(encryptedPassword);
		System.out.println(basePassword);
		System.out.println(shaPassword);
					encryptedPassword = encryptedPassword.concat(shaPassword);*/
System.out.println("encryptedPassword " +encryptedPssword);
  }


	public  static String rPad(String str, int num, int d)
	{
		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < num; i++)
		{
			sb.append((char) d);
		}
		return sb.toString();
	}

	public static String getBase64String(String encryptedString){

		String base64EncryptedString;
		base64EncryptedString="";	
		try{
			System.out.println("the lenght of the encrypted string is "+encryptedString.length());		 
			for(int i=0;i<=15;i++)
			{
				encryptedString=encryptedString.substring(2);
				encryptedString=encryptedString.substring(2);
				base64EncryptedString=base64EncryptedString.concat(encryptedString.substring(0,2));
				encryptedString=encryptedString.substring(2);
			}
			System.out.println("*******************"+base64EncryptedString); 
			return base64EncryptedString;
		} catch(Exception e){
			e.printStackTrace();
			return "1";

		}

	}

public static String sha1(String sInput) {
		int nDigestLen = 20;
		byte[] plainText = sInput.getBytes();
		// Allocate memory for the encrypted text
		byte[] encryptedText = new byte[nDigestLen];
		MessageDigest cipher = null;
		try {
			cipher = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		cipher.update(plainText, 0, plainText.length);
		try {
			cipher.digest(encryptedText, 0, nDigestLen);
		} catch (DigestException ex) {
			ex.printStackTrace();
		}
		// Convert result to hexidecimal
		return toHex(encryptedText);
	}

	private static String toHex(byte[] bsData) {
		int nDataLen = bsData.length;
		String sHex = "";
		for (int nIter = 0; nIter < nDataLen; nIter++) {
			int nValue = (bsData[nIter] + 256) % 256;
			int nIndex1 = nValue >> 4;
		sHex += Integer.toHexString(nIndex1);
		int nIndex2 = nValue & 0x0f;
		sHex += Integer.toHexString(nIndex2);
		}
		return sHex;
	}

	public static String decrypt(String encText, String pKey)
	{
		String sText = "";
		String sKey = rPad(pKey, 16, 0);
		String sDecText = "";
		String sTemp = rPad(encText, 32, 0);
		int a = 0;
		int b = 0;
		int i = 0;
		try
		{
			for (int j = 0; j < 15; j++)
			{
				//				System.out.println(sTemp.charAt((j * 2) + 0)+" "+sTemp.charAt((j * 2) + 1));

				a = (int) sTemp.charAt((j * 2) + 0);
				b = (int) sTemp.charAt((j * 2) + 1);
				//				System.out.println(a+" "+b);

				if (a >= 65){
					a = (a + 10) - 65;
				}
				else{
					a = a - 48;
				}
				if (b >= 65){
					b = (b + 10) - 65;
				}else{
					b = b - 48;
				}
	//			System.out.println(a+ " "+b);
				i = (a * 16) + b;
				i = i - (int) sKey.charAt(j);
				if (i < 0){
					i = i + 126;
				}			//	System.out.println(i);

				sText = sText + (char) i;
			}
			sDecText = sText;
			sDecText = sDecText.trim();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return sDecText;
	}

private static  String rsa(String pText) throws NoSuchAlgorithmException,
	InvalidKeySpecException, NoSuchPaddingException,
	InvalidKeyException, IllegalStateException, ShortBufferException,
	IllegalBlockSizeException, BadPaddingException {

		X509EncodedKeySpec pks = new X509EncodedKeySpec(kRSAPublicKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(pks);
		byte[] plainText = pText.getBytes();
		byte[] ciphertext = new byte[256];
		Cipher cipher1 = Cipher.getInstance("RSA");
		cipher1.init(Cipher.ENCRYPT_MODE, publicKey);
		cipher1.doFinal(plainText, 0, plainText.length, ciphertext, 0);
		return toHex(ciphertext);
	}
private static String base(String pText, String pKey) {
		String sTemp = "";
		String sTemp1 = "";
		int i = 0;
		int t = 0;
		int a = 0;
		int b = 0;

		int z4 = pText.length();
		if (z4 < 16) {
			int aa = 16 - z4;
			for (int ie = 0; ie < aa; ie++) {
				pText = pText.concat("|");
			}
		}

		int z5 = pKey.length();
		if (z5 < 16) {
			int aa = 16 - z5;
			for (int ie = 0; ie < aa; ie++) {
				pKey = pKey.concat("|");
			}
		}

		for (int j = 0; j < 16; j++) {

			String z = (pText.substring(j, j + 1));
			char z1 = z.charAt(0);
			int z2 = (int) z1;
			if (z2 == 124) {
				z2 = 0;
			}

			String y = (pKey.substring(j, j + 1));
			char y1 = y.charAt(0);
			int y2 = (int) y1;
			if (y2 == 124) {
				y2 = 0;
			}

			i = y2 + z2;

			i = i % 255;
			char digit = (char) i;
			sTemp = sTemp + digit;
		}
		for (i = 0; i < 16; i++) {
			String x = (sTemp.substring(i, i + 1));
			char x1 = x.charAt(0);
			int x2 = (int) x1;
			t = x2;
			a = t % 16;
			b = (t - a) / 16;
			if (b < 10) {
				int ss = b + 48;
				char digit = (char) ss;
				String aaa = "" + digit;
				sTemp1 = sTemp1.concat(aaa);
			} else {
				int ss = b - 10 + 65;
				char digit = (char) ss;
				String aaa = "" + digit;
				sTemp1 = sTemp1.concat(aaa);
			}

			if (a < 10) {
				int ss = a + 48;
				char digit = (char) ss;
				String aaa = "" + digit;
				sTemp1 = sTemp1.concat(aaa);
			} else {
				int ss = a - 10 + 65;
				char digit = (char) ss;
				String aaa = "" + digit;
				sTemp1 = sTemp1.concat(aaa);
			}
		}
		return sTemp1;
	}

	private static final byte[] kRSAPublicKey = { (byte) 0x30, (byte) 0x82,
		(byte) 0x1, (byte) 0x22, (byte) 0x30, (byte) 0xd, (byte) 0x6,
		(byte) 0x9, (byte) 0x2a, (byte) 0x86, (byte) 0x48, (byte) 0x86,
		(byte) 0xf7, (byte) 0xd, (byte) 0x1, (byte) 0x1, (byte) 0x1,
		(byte) 0x5, (byte) 0x0, (byte) 0x3, (byte) 0x82, (byte) 0x1,
		(byte) 0xf, (byte) 0x0, (byte) 0x30, (byte) 0x82, (byte) 0x1,
		(byte) 0xa, (byte) 0x2, (byte) 0x82, (byte) 0x1, (byte) 0x1,
		(byte) 0x0, (byte) 0xe0, (byte) 0xe2, (byte) 0x9f, (byte) 0xc2,
		(byte) 0x75, (byte) 0x4c, (byte) 0x10, (byte) 0x53, (byte) 0xbb,
		(byte) 0x48, (byte) 0xcb, (byte) 0x54, (byte) 0x23, (byte) 0xe4,
		(byte) 0x91, (byte) 0x17, (byte) 0xa2, (byte) 0xec, (byte) 0x59,
		(byte) 0x9f, (byte) 0x6f, (byte) 0x57, (byte) 0x7f, (byte) 0x9b,
		(byte) 0x6a, (byte) 0x1f, (byte) 0x93, (byte) 0x5e, (byte) 0x69,
		(byte) 0xf1, (byte) 0xd4, (byte) 0x56, (byte) 0xb9, (byte) 0x65,
		(byte) 0x9e, (byte) 0x14, (byte) 0x27, (byte) 0xb8, (byte) 0xb1,
		(byte) 0xb5, (byte) 0x9d, (byte) 0xea, (byte) 0xd6, (byte) 0xef,
		(byte) 0xc2, (byte) 0x3, (byte) 0x4e, (byte) 0x9b, (byte) 0x28,
		(byte) 0x1e, (byte) 0x1b, (byte) 0x8, (byte) 0x1a, (byte) 0x5,
		(byte) 0x4d, (byte) 0xf7, (byte) 0xb5, (byte) 0xe7, (byte) 0x92,
		(byte) 0xcd, (byte) 0x3a, (byte) 0x59, (byte) 0xd8, (byte) 0xb6,
		(byte) 0xb6, (byte) 0x20, (byte) 0xf3, (byte) 0xc8, (byte) 0x2b,
		(byte) 0xf8, (byte) 0x1e, (byte) 0x38, (byte) 0xd9, (byte) 0xb4,
		(byte) 0xf4, (byte) 0x23, (byte) 0xc0, (byte) 0x3, (byte) 0xc9,
		(byte) 0x2, (byte) 0x71, (byte) 0x7a, (byte) 0xac, (byte) 0x40,
		(byte) 0x25, (byte) 0x67, (byte) 0xfe, (byte) 0xc2, (byte) 0x6a,
		(byte) 0xd2, (byte) 0x3b, (byte) 0x25, (byte) 0x14, (byte) 0x29,
		(byte) 0xf5, (byte) 0x99, (byte) 0x8c, (byte) 0xef, (byte) 0x51,
		(byte) 0x25, (byte) 0xa4, (byte) 0x37, (byte) 0xda, (byte) 0xb1,
		(byte) 0x65, (byte) 0xb6, (byte) 0x49, (byte) 0xf7, (byte) 0x9d,
		(byte) 0x1e, (byte) 0x5a, (byte) 0x34, (byte) 0xe, (byte) 0x17,
		(byte) 0xf2, (byte) 0x50, (byte) 0x92, (byte) 0x85, (byte) 0xbb,
		(byte) 0x1c, (byte) 0x6c, (byte) 0xae, (byte) 0x6a, (byte) 0xe4,
		(byte) 0xe0, (byte) 0x29, (byte) 0xe5, (byte) 0xfd, (byte) 0xcd,
		(byte) 0x10, (byte) 0x1a, (byte) 0xab, (byte) 0x7, (byte) 0xc7,
		(byte) 0xa4, (byte) 0x32, (byte) 0xd7, (byte) 0xbd, (byte) 0x70,
		(byte) 0x24, (byte) 0xc6, (byte) 0x53, (byte) 0x73, (byte) 0x33,
		(byte) 0x95, (byte) 0x62, (byte) 0x84, (byte) 0x99, (byte) 0xb5,
		(byte) 0x3b, (byte) 0x83, (byte) 0x90, (byte) 0xe, (byte) 0xbc,
		(byte) 0x91, (byte) 0x58, (byte) 0xf0, (byte) 0x95, (byte) 0x96,
		(byte) 0x15, (byte) 0xf, (byte) 0xed, (byte) 0x68, (byte) 0xba,
		(byte) 0x46, (byte) 0x5, (byte) 0x22, (byte) 0x99, (byte) 0x55,
		(byte) 0x1e, (byte) 0x39, (byte) 0xbe, (byte) 0xf5, (byte) 0x34,
		(byte) 0xcd, (byte) 0xb9, (byte) 0x43, (byte) 0xde, (byte) 0x1c,
		(byte) 0xeb, (byte) 0xf0, (byte) 0x79, (byte) 0xee, (byte) 0x9d,
		(byte) 0x60, (byte) 0xa5, (byte) 0x50, (byte) 0x78, (byte) 0xe0,
		(byte) 0x38, (byte) 0xf9, (byte) 0x28, (byte) 0x96, (byte) 0xaf,
		(byte) 0x7, (byte) 0x99, (byte) 0xd6, (byte) 0xce, (byte) 0x7c,
		(byte) 0xbc, (byte) 0x3b, (byte) 0x4, (byte) 0xfd, (byte) 0xd,
		(byte) 0x9, (byte) 0x70, (byte) 0xb1, (byte) 0xad, (byte) 0xcf,
		(byte) 0xa5, (byte) 0x46, (byte) 0xc8, (byte) 0x41, (byte) 0x5c,
		(byte) 0x7, (byte) 0xd8, (byte) 0x9b, (byte) 0xcb, (byte) 0xd7,
		(byte) 0xcb, (byte) 0x5c, (byte) 0xc4, (byte) 0x96, (byte) 0xe,
		(byte) 0x41, (byte) 0x84, (byte) 0x3b, (byte) 0x28, (byte) 0x91,
		(byte) 0x7, (byte) 0xc5, (byte) 0xdc, (byte) 0x9e, (byte) 0x71,
		(byte) 0x78, (byte) 0x10, (byte) 0x41, (byte) 0x8d, (byte) 0x5,
		(byte) 0x3d, (byte) 0x36, (byte) 0x3f, (byte) 0x78, (byte) 0xa1,
		(byte) 0x9c, (byte) 0xb3, (byte) 0x37, (byte) 0x81, (byte) 0x2a,
		(byte) 0xa5, (byte) 0xd0, (byte) 0x25, (byte) 0xad, (byte) 0xfe,
		(byte) 0x71, (byte) 0x7, (byte) 0x2, (byte) 0x3, (byte) 0x1,
		(byte) 0x0, (byte) 0x1 };

	
}