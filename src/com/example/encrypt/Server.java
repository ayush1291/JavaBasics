package com.example.encrypt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Server {
	
	static String msg="aR5yozCmp7xmBZyJPgJWicc0n4Lk8klFa1Jo25DbYKn7judb1Xi32dcrXXnhBe+s6A7O8jXrkzxLFN4DJsp2bViQUsxm5ZvXzWqOGZ76NOyaq1OCk616AOeRcLAeC4YAXXF11qyhC0t4st3PGZk6cZzTMdINmzIIamw24FHD2K8=";

	public static void main(String[] args) {
	
		System.out.println(msg.getBytes());
		
		Server server = new Server();
		
		try {
			System.out.println(server.rsaDecrypt(msg));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	PrivateKey readKeyFromFile(String keyFileName) throws IOException {
		  FileInputStream in =new FileInputStream(keyFileName);
		  ObjectInputStream oin =
		    new ObjectInputStream(new BufferedInputStream(in));
		  try {
		    BigInteger m = (BigInteger) oin.readObject();
		    BigInteger e = (BigInteger) oin.readObject();
		    RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
		    KeyFactory fact = KeyFactory.getInstance("RSA");
		    PrivateKey pubKey = fact.generatePrivate(keySpec);
		    return pubKey;
		  } catch (Exception e) {
		    throw new RuntimeException("Spurious serialisation error", e);
		  } finally {
		    oin.close();
		  }
		}
	
	
	public String rsaDecrypt(String msg) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		  PrivateKey privateKey = readKeyFromFile("private.key");
		  byte[] bytes = Base64.getDecoder().decode(msg);
		  
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(Cipher.DECRYPT_MODE, privateKey);
		  byte[] cipherData = cipher.doFinal(bytes);
		  return new String(cipherData);
		}

}
