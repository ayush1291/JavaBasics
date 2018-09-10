package com.example.encrypt;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class GenerateKeys {

	private KeyPairGenerator keyGen;
	private static KeyPair pair;
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.keyGen = KeyPairGenerator.getInstance("RSA");
		this.keyGen.initialize(keylength);
	}

	public void createKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}

	public PublicKey getPublicKey() {
		return this.publicKey;
	}

	public static void main(String[] args) throws InvalidKeySpecException, IOException {
		GenerateKeys gk;
		try {
			gk = new GenerateKeys(1024);
			gk.createKeys();
			System.out.println("Public key " + gk.getPublicKey().getEncoded());
			System.out.println("Private key " + gk.getPrivateKey().getEncoded());
			
			
			KeyFactory fact = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec pub = fact.getKeySpec(pair.getPublic(),
			  RSAPublicKeySpec.class);
			System.out.println(" Public "+pub.getModulus() + "  "+pub.getPublicExponent());
			
			RSAPrivateKeySpec priv = fact.getKeySpec(pair.getPrivate(),
			  RSAPrivateKeySpec.class);

			System.out.println(" Private "+priv.getModulus() + "  "+priv.getPrivateExponent());
			
			
			saveToFile("public.key", pub.getModulus(),
					  pub.getPublicExponent());
			saveToFile("private.key", priv.getModulus(),
			  priv.getPrivateExponent());
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			System.err.println(e.getMessage());
		} 
	}

	
		public static void saveToFile(String fileName,
			  BigInteger mod, BigInteger exp) throws IOException {
			  ObjectOutputStream oout = new ObjectOutputStream(
			    new BufferedOutputStream(new FileOutputStream(fileName)));
			  try {
			    oout.writeObject(mod);
			    oout.writeObject(exp);
			  } catch (Exception e) {
			    throw new IOException("Unexpected error", e);
			  } finally {
			    oout.close();
			  }
			}
}