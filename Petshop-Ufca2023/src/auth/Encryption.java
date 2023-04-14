package auth;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Encryption {
	
	public static byte[] encryptPassword(String senha) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		
	    SecureRandom random = new SecureRandom();
	    byte[] salt = new byte[16];
	    random.nextBytes(salt);
		
	    int iterationCount = 10000;
	    int keyLength = 256;
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	    PBEKeySpec keySpec = new PBEKeySpec(senha.toCharArray(), salt, iterationCount, keyLength);
	    SecretKey secretKey = keyFactory.generateSecret(keySpec);
	    byte[] keyBytes = secretKey.getEncoded();
	    
	    SecretKeySpec keySpecs = new SecretKeySpec(keyBytes, "AES");
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    byte[] iv = new byte[cipher.getBlockSize()];
	    random.nextBytes(iv);
	    cipher.init(Cipher.ENCRYPT_MODE, keySpecs, new IvParameterSpec(iv));
	    
	    byte[] encryptedPassword = cipher.doFinal(senha.getBytes());

	    byte[] result = new byte[salt.length + iv.length + encryptedPassword.length];
	    System.arraycopy(salt, 0, result, 0, salt.length);
	    System.arraycopy(iv, 0, result, salt.length, iv.length);
	    System.arraycopy(encryptedPassword, 0, result, salt.length + iv.length, encryptedPassword.length);
	    
	    return result;
	}
	
}
