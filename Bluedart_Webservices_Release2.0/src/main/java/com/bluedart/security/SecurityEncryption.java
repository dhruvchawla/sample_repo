package com.bluedart.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class SecurityEncryption {

	// 8-byte Salt
    static byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
 
    public SecurityEncryption() { 

    }

    public static String decrypt(String encryptedText)
    	     throws NoSuchAlgorithmException, 
    	            InvalidKeySpecException, 
    	            NoSuchPaddingException, 
    	            InvalidKeyException,
    	            InvalidAlgorithmParameterException, 
    	            UnsupportedEncodingException, 
    	            IllegalBlockSizeException, 
    	            BadPaddingException, 
    	            IOException {
    			Cipher dcipher;
		    	
		    	KeySpec keySpec = new PBEKeySpec(UserConstants.SECRETKEY.toCharArray(), salt, UserConstants.ITERATIONCOUNT);
    	        SecretKey key = SecretKeyFactory.getInstance(UserConstants.SECRETCODE).generateSecret(keySpec);        
    	        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, UserConstants.ITERATIONCOUNT);
    	        dcipher=Cipher.getInstance(key.getAlgorithm());
    	        dcipher.init(Cipher.DECRYPT_MODE, key,paramSpec);
    	        byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
    	        byte[] utf8 = dcipher.doFinal(enc);
    	        String plainStr = new String(utf8, UserConstants.CHARSET);
    	        return plainStr;
    	    }  
}
