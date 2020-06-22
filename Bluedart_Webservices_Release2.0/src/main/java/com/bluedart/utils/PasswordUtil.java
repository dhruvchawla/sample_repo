package com.bluedart.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.bluedart.exception.BlueDartException;
/**
 * @author PR334023
 * Password Utility class
 */
@Component
public class PasswordUtil {

	/**
	 * Generate password
	 */
	public String generatePassword()
	{
		Date date = new Date();
		String password = String.valueOf(date.getTime());
		return password.substring(7);
	}
	/**
	 * To generate strong password
	 * @return password
	 */
	public String generateStrongPassword(){
		Random rand = new Random();

		char[] charset1 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'r', 'v', 'w', 'A', 'C', 'H' , 'D', 's', 'N', 'q',
				'z', 'G', 'u', 'y', 'o', 'F', 'E', 'x', 'p', 'K', 'J', 'P',
				'B', 't', 'M', 'Q', 'L', 'R', 'S', 'T', 'U', 'V', 'Z', 'W',
				'n', 'm', 'l', 'k', 'X', 'Y' };
		char[] charset2 = { '$',  '%', '*' };
		char[] charset3 = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		StringBuilder chars = new StringBuilder();
		StringBuilder chars1 = new StringBuilder();
		StringBuilder symbols = new StringBuilder();
		StringBuilder numeric = new StringBuilder();

		chars.append((Character.toString(charset1[rand.nextInt(charset1.length)])).toUpperCase());
		
		for (int indexCharset1 = 1; indexCharset1 < 3; indexCharset1++) {
			int index = rand.nextInt(charset1.length);
			chars1.append((Character.toString(charset1[index])).toLowerCase());
		}

		for (int indexCharset2 = 0; indexCharset2 < 3; indexCharset2++) {
			int index = rand.nextInt(charset2.length);
			symbols.append(Character.toString(charset2[index]));
		}

		for (int indexCharset3 = 0; indexCharset3 < 2; indexCharset3++) {
			int index = rand.nextInt(charset3.length);
			numeric.append(Character.toString(charset3[index]));
		}
		return (chars.append(chars1).append(symbols).append(numeric)).toString();
	}
	/**
	 * To encrypt original password by MD5 base32
	 * @param password
	 * @return encryptedPassword
	 */
	public String encryptPassword(String password)
	{
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		}catch (Exception exception) {
			 throw new BlueDartException("", "");
		}
		messageDigest.reset();
		messageDigest.update(password.getBytes());
		byte[] digestValue = messageDigest.digest();
		BigInteger bigInt = new BigInteger(1,digestValue);
		String encryptedPassword = bigInt.toString(16);
		while(encryptedPassword.length() < 32 ){
			encryptedPassword = "0"+encryptedPassword;
		}
		return encryptedPassword;
	}
	
	/**
	 * To Encrypt password using MD5 Base64
	 */
	public String encryptPasswordByBase64(String originalPassword) {
	    try {
	      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	      messageDigest.update(originalPassword.getBytes());
	      byte[] digestValue = messageDigest.digest();
	      String encryptedPassword = new sun.misc.BASE64Encoder().encode(digestValue);
	      return encryptedPassword;
	    } catch (Exception exception) {
	    	throw new BlueDartException(exception.getMessage(), "");
	    }
	  }
}