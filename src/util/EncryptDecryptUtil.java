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

    public static String decrypt(String encryptedText , SecretKey secretKey, Cipher cipher) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(cipher.DECRYPT_MODE,secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;

    }



}
