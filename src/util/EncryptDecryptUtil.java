package util;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.util.Base64;

public class EncryptDecryptUtil {

    public static String encrypt(String plainText, SecretKey secretKey, Cipher cipher) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] plainTextByte = plainText.getBytes();
        cipher.init(cipher.ENCRYPT_MODE,secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;


    }



}
