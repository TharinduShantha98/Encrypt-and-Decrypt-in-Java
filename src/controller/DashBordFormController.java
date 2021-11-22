package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.EncryptDecryptUtil;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DashBordFormController {
    public TextField txtPlainText;
    public Label lblBeforeEncrypt;
    public Label lblAfterEncrypt;
    public Label lblAfterDecrypt;
    public Button btnEncrypt;
    public Button btnDecrypt;



    String encryptedText;
    SecretKey secretKey;

    static Cipher cipher;

    public  void initialize(){
        btnDecrypt.setDisable(true);
    }


    public  void setCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");
    }

    public void EncryptOnAction(ActionEvent actionEvent) throws NoSuchAlgorithmException, NoSuchPaddingException {
        setCipher();
        try {
            encryptedText = EncryptDecryptUtil.encrypt(txtPlainText.getText(),secretKey,cipher);
            lblBeforeEncrypt.setText(txtPlainText.getText());
            lblAfterEncrypt.setText(encryptedText);


        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        txtPlainText.clear();
        btnDecrypt.setDisable(false);

    }

    public void DecryptOnAction(ActionEvent actionEvent) {

        try {
            String decryptedText = EncryptDecryptUtil.decrypt(encryptedText,secretKey,cipher);
            lblAfterDecrypt.setText(decryptedText);


        } catch (Exception e) {
            e.printStackTrace();
        } {


        }




    }
}
