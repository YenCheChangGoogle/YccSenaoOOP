package YccSenaoOOP.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import YccSenaoOOP.AbstractHandler;
import YccSenaoOOP.myBackupCandidate.Candidate;

//將檔案加以編碼(加密)
public class EncodeHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(EncodeHandler.class);
	
	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);
		byte[] result = target;
		//(1)當第二個參數為 null時, 不做任何編碼
		//(2)當傳入byte[] 時, 編碼後回傳byte[]
		if (target != null) {
			result = this.encodeData(candidate, target);
		}
		return result;
	}

	//將 byte[] 加以編碼, 並傳回 byte[]
	private byte[] encodeData(Candidate candidate, byte[] target) {
		return this.toEncrypt(target);
	}
	
	private static byte[] iv = {1,2,3,4,5,6,7,8,1,2,3,4,5,6,15,8}; //注意: AES為16bytes, 若為DES則為8bytes  
	
	//加密方法(如果加密發生異常會回傳原來的內容)
	public static byte[] toEncrypt(byte[] target) {
		logger.debug("");
		
		byte[] byteCipherText = target;
		try {
			SecretKeySpec key = new SecretKeySpec(iv, "AES"); 			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));			
			byteCipherText = cipher.doFinal(target);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteCipherText;
	}

	//解密方法(如果解密發生異常會回傳原來的內容)
	public static byte[] toDecrypt(byte[] cipherText) {
		logger.debug("");
		
		byte[] decryptedData = cipherText;
		try {
			SecretKeySpec key = new SecretKeySpec(iv, "AES");			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			decryptedData = cipher.doFinal(cipherText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedData;
	}
	
    public static void main(String args[]) {
    	byte [] b=EncodeHandler.toEncrypt("YenCheChang Just Do It".getBytes());
    	System.out.println(new String (b));
    	
    	b=EncodeHandler.toDecrypt(b);
    	System.out.println(new String (b));
    }
}
