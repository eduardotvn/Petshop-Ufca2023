package auth;

import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

public class Authentication {
	public static boolean authenticatePassword(String password, byte[] storedEncryptedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	    byte[] salt = Arrays.copyOfRange(storedEncryptedPassword, 0, 16);
	    byte[] iv = Arrays.copyOfRange(storedEncryptedPassword, 16, 32);
	    byte[] encryptedPassword = Arrays.copyOfRange(storedEncryptedPassword, 32, storedEncryptedPassword.length);
	    
	    // Generate a derived key using PBKDF2 with the same salt and parameters as during registration
	    int iterationCount = 10000;
	    int keyLength = 256;
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
	    SecretKey secretKey = keyFactory.generateSecret(keySpec);
	    byte[] keyBytes = secretKey.getEncoded();
	    
	    // Initialize the decryption cipher with the derived key and the stored IV
	    SecretKeySpec keySpecs = new SecretKeySpec(keyBytes, "AES");
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, keySpecs, new IvParameterSpec(iv));
	    
	    // Decrypt the stored encrypted password and compare it with the encrypted entered password
	    byte[] decryptedPassword = cipher.doFinal(encryptedPassword);
	    byte[] enteredPassword = password.getBytes();
	    return Arrays.equals(decryptedPassword, enteredPassword);
	}
	
	public static byte[] getChaveGerente()
	{
		byte[] chaveGerente; 
		
		try {
			String chaveGerenteString = new String(Files.readAllBytes(Paths.get("./src/auth/authJson/keys.json")));
			JSONObject keyJson = new JSONObject(chaveGerenteString);
			JSONArray chaveGerenteArray = keyJson.getJSONArray("chaveGerente");
			chaveGerente = new byte[chaveGerenteArray.length()];
			
			for (int i = 0; i < chaveGerenteArray.length(); i++) {
			    chaveGerente[i] = (byte) chaveGerenteArray.getInt(i);
			}
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
			return new byte[0];
		}
		
		return chaveGerente; 
	}
}
