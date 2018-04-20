package com.knight.test;



import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class CreateSecrteKey {


    public class Keys {

    }

    public static final String KEY_ALGORITHM = "RSA";
    //public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    //获得公钥
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //byte[] publicKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获得私钥
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //byte[] privateKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //map对象中存放公私钥
    public static Map<String, Object> initKey() throws Exception {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1WithRSA");
        keyPairGen.initialize(1024, random);
//        keyPairGen.initialize(1024);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static void main(String[] args) throws Exception {
//        Map<String, Object> keyMap;
//        try {
//            keyMap = initKey();
//            String publicKey = getPublicKey(keyMap);
//            System.out.println(publicKey);
//            String privateKey = getPrivateKey(keyMap);
//            System.out.println(privateKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            getKey();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        }


        getRSAKey();
        try {
            System.out.println(getPrivateKey("pru.pem"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        createKeyPairs();
    }


//    public static void getKey() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
//        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//        // create the keys
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
//        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
//        generator.initialize(512, random);
//        KeyPair pair = generator.generateKeyPair();
//        PublicKey pubKey = pair.getPublic();
//        PrivateKey privKey = pair.getPrivate();
//        byte[] pk = pubKey.getEncoded();
//        byte[] privk = privKey.getEncoded();
//        String strpk = new String(Base64.encodeBase64(pk));
//        String strprivk = new String(Base64.encodeBase64(privk));
//
//        System.out.println("公钥:" + Arrays.toString(pk));
//        System.out.println("私钥:" + Arrays.toString(privk));
//        System.out.println("公钥Base64编码:" + strpk);
//        System.out.println("私钥Base64编码:" + strprivk);
//
//        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decodeBase64(strpk.getBytes()));
//        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(strprivk.getBytes()));
//
//        KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
//        PublicKey pubkey2 = keyf.generatePublic(pubX509);
//        PrivateKey privkey2 = keyf.generatePrivate(priPKCS8);
//
//        System.out.println(pubKey.equals(pubkey2));
//        System.out.println(privKey.equals(privkey2));
//    }


    public static void getRSAKey(){
        String PUBLIC_KEY_PATH = "pub.pem";
        String PRIVATE_KEY_PATH = "pru.pem";
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
            keyPairGenerator.initialize(1024, secureRandom);
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
            System.out.println(Base64.getEncoder().encodeToString(publicKeyBytes));
            FileOutputStream fos = new FileOutputStream(PUBLIC_KEY_PATH);
            fos.write(publicKeyBytes);
            fos.close();
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
            System.out.println(Base64.getEncoder().encodeToString(privateKeyBytes));
            fos = new FileOutputStream(PRIVATE_KEY_PATH);
            fos.write(privateKeyBytes);
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public static PrivateKey getPrivateKey(String filename)throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
    public static void createKeyPairs() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // create the keys
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
        generator.initialize(512, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();
        PublicKey pubKey = pair.getPublic();
        PrivateKey privKey = pair.getPrivate();
        byte[] pk = pubKey.getEncoded();
        byte[] privk = privKey.getEncoded();
        String strpk = new String(org.apache.commons.codec.binary.Base64.encodeBase64(pk));
        String strprivk = new String(org.apache.commons.codec.binary.Base64.encodeBase64(privk));

        System.out.println("公钥:" + Arrays.toString(pk));
        System.out.println("私钥:" + Arrays.toString(privk));
        System.out.println("公钥Base64编码:" + strpk);
        System.out.println("私钥Base64编码:" + strprivk);

        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(strpk.getBytes()));
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(strprivk.getBytes()));



        KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(strprivk));
        RSAPrivateKey key = (RSAPrivateKey) keyf.generatePrivate(pkcs8KeySpec);

        PublicKey pubkey2 = keyf.generatePublic(pubX509);
        PrivateKey privkey2 = keyf.generatePrivate(priPKCS8);
        System.out.println("\n\n");
        byte[] privateKeyBytes = key.getEncoded();
        System.out.println(Base64.getEncoder().encodeToString(privateKeyBytes));

        System.out.println(pubKey.equals(pubkey2));
        System.out.println(privKey.equals(privkey2));
    }
}
