package data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginData {
          public static Boolean CheckPasswords (String password1, String password2) {
        	  boolean passwordCorrect = false;
        	  try {
        		  if(password1.equals(password2)) {
        			  System.out.println("Password correct");
        			  passwordCorrect = true;
        		  } else {
        			  System.out.println("Password incorrect");
        			  passwordCorrect = false;
        		  }
        	  } catch (NullPointerException e) {
      			e.printStackTrace();
        	  }
        	  return passwordCorrect;
          }
          
      	public static String crypt(String str) {
  	      if (str == null || str.length() == 0) {
  	          throw new IllegalArgumentException("String to encrypt cannot be null or zero length");
  	      }
  	      MessageDigest digester;
  	      try {
  	          digester = MessageDigest.getInstance("MD5");

  	          digester.update(str.getBytes());
  	          byte[] hash = digester.digest();
  	          StringBuffer hexString = new StringBuffer();
  	          for (int i = 0; i < hash.length; i++) {
  	              if ((0xff & hash[i]) < 0x10) {
  	                  hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
  	              } else {
  	                  hexString.append(Integer.toHexString(0xFF & hash[i]));
  	              }
  	          }
  	          return hexString.toString();
  	      } catch (NoSuchAlgorithmException e) {
  	          e.printStackTrace();
  	      }
  	      return "";
  	  }
          
          
}
