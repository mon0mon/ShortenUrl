package xyz.mon0mon.shortenurl.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String input = "https://example.com"; // 원본 URL
    byte[] md5Bytes = generateMD5(input);
    String md5 = convertMD5ToString(md5Bytes);
    System.out.println("MD5 Decoded : " + md5 + " (" + md5.length() + ")");
    String shortUrl = generateShortUrlWithMD5(md5Bytes);
    System.out.println("MD5 based Short URL: " + shortUrl + " (" + shortUrl.length() + ")");
  }

  public static byte[] generateMD5(String input) throws NoSuchAlgorithmException {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    return md5.digest(input.getBytes());
  }

  public static String convertMD5ToString(byte[] hashBytes) {
    StringBuilder sb = new StringBuilder();
    for (byte hashByte : hashBytes) {
      String hex = Integer.toHexString(0xFF & hashByte);
      if (hex.length() == 1) {
        sb.append('0');
      }
      sb.append(hex);
    }
    return sb.toString();
  }

  // MD5를 사용하여 URL을 해싱하고, 그 중 일부를 잘라 짧은 URL로 만듬
  public static String generateShortUrlWithMD5(byte[] hashBytes) {
    // 16바이트(128비트)의 해시 중 앞의 12바이트(96비트)만 사용
    StringBuilder hexString = new StringBuilder();
    for (int i = 0; i < 12; i++) {
      String hex = Integer.toHexString(0xff & hashBytes[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }

    return hexString.toString(); // 24자리의 고유한 짧은 URL ID
  }
}
