package com.example.encrypt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class cLIENT {
	
	final String fileName = "public.key";
	static String msg ="ayush 1234";
	
	public static void main(String[] args) {
		
		cLIENT client = new cLIENT();
		try {
			
			System.out.println(client.rsaEncrypt(msg));
			
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	PublicKey readKeyFromFile(String keyFileName) throws IOException {
		  FileInputStream in =new FileInputStream(keyFileName);
		  ObjectInputStream oin =
		    new ObjectInputStream(new BufferedInputStream(in));
		  try {
		    BigInteger m = (BigInteger) oin.readObject();
		    BigInteger e = (BigInteger) oin.readObject();
		    RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
		    KeyFactory fact = KeyFactory.getInstance("RSA");
		    PublicKey pubKey = fact.generatePublic(keySpec);
		    return pubKey;
		  } catch (Exception e) {
		    throw new RuntimeException("Spurious serialisation error", e);
		  } finally {
		    oin.close();
		  }
		}
	
	
	public String rsaEncrypt(String msg) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		  PublicKey pubKey = readKeyFromFile("public.key");
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		  byte[] cipherData = cipher.doFinal(msg.getBytes());
		  String base64encodedString = Base64.getEncoder().encodeToString(cipherData);
		  return base64encodedString;
		}
}
