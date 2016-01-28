package com.vedic.astro.util;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vedic.astro.exception.SystemException;



/**
 * Utility class for encrpytion and decryption.
 * 
 * @author Sumeer Saxena
 */
@Component("encryptionUtil")
public class EncryptionUtil {


	@Value("${encryption.key.val}") 
	public String KEY;
	
	@Value("${encryption.key.iv}") 
	public String IV;
	
	@Value("${encryption.type}") 
	public String ENCRYPTION_TYPE;
	
	@Value("${encryption.padding}") 
	public String ENCRYPTION_PADDING;
	
	private Cipher cipher;

	/**
	 * Private constructor so that nobody can instantiate class.
	 */
	private EncryptionUtil() {
	}

	/**
	 * Initializes cipher for encryption or decryption.
	 * 
	 * @param mode
	 */
	public void initCipher(int mode) {
		try {
			cipher = getCipher(mode);
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Converts the given value to the encrypted value.
	 * 
	 * @param value
	 *            String to be encrypted.
	 * @return The encrypted value.
	 */
	public String encrypt(String value) {
		String result = null;
	       try {
	            IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), ENCRYPTION_TYPE);

	            Cipher cipher = Cipher.getInstance(ENCRYPTION_PADDING);
	            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	            byte[] encrypted = cipher.doFinal(value.getBytes());

	            result = Base64.encodeBase64String(encrypted);
	        } catch (Exception ex) {
	        	throw new SystemException(ex.getMessage(), ex);
	        }

	       return result;
	}

	/**
	 * Decrypts the given encrypted value to the real value.
	 * 
	 * @param value
	 *            String to be decrypted.
	 * @return The decrypted value.
	 */
	public String decrypt(String value) {
		String result = null;
				
	       try {
	            IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), ENCRYPTION_TYPE);

	            Cipher cipher = Cipher.getInstance(ENCRYPTION_PADDING);
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

	            byte[] decrypted = cipher.doFinal(Base64.decodeBase64(value));

	            result = new String(decrypted);
	        } catch (Exception ex) {
	        	throw new SystemException(ex.getMessage(), ex);
	        }
	        return result;
	}

	/**
	 * Private utility method for converting hex to bytes.
	 * 
	 * @param hex
	 * @return
	 */
	private static byte[] hexToBytes(char[] hex) {
		int length = hex.length / 2;
		byte[] raw = new byte[length];
		for (int i = 0; i < length; i++) {
			int high = Character.digit(hex[i * 2], 16);
			int low = Character.digit(hex[i * 2 + 1], 16);
			int value = (high << 4) | low;
			if (value > 127)
				value -= 256;
			raw[i] = (byte) value;
		}
		return raw;
	}

	/**
	 * Private utility method for converting hex to bytes.
	 * 
	 * @param hex
	 * @return
	 */

	private static byte[] hexToBytes(String hex) {
		return hexToBytes(hex.toCharArray());
	}

	/**
	 * Private utility method for getting the Cipher
	 * 
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	private Cipher getCipher(int mode) throws Exception {

		// Properties props =
		// PropertiesLoaderUtils.loadAllProperties("crm.properties");
		byte[] ivBytes = hexToBytes(IV);
		byte[] keyBytes = hexToBytes(KEY);
		SecretKeySpec secKeySpec = new SecretKeySpec(keyBytes,
				ENCRYPTION_TYPE);
		//
		AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivBytes);

		//
		Cipher cipher = Cipher.getInstance(ENCRYPTION_PADDING);// NoPadding");
		cipher.init(mode, secKeySpec, paramSpec);

		return cipher;
	}


}
