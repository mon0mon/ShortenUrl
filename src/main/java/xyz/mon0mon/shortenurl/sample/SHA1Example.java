package xyz.mon0mon.shortenurl.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Example {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String input = "https://example.com"; // 원본 URL
    byte[] sha1Bytes = generateSHA1(input);
    String decodedSha1 = convertSHA1ToString(sha1Bytes);
    System.out.println("SHA1 encoded : " + decodedSha1 + "(" + decodedSha1.length() + ")");
    String shortUrl = generateShortUrlWithSHA1(sha1Bytes);
    System.out.println("SHA1 based Short URL : " + shortUrl + "(" + shortUrl.length() + ")");
  }

  //  주어진 Input에 대해, SHA1 Encoding된 Byte 배열을 리턴
  public static byte[] generateSHA1(String input) throws NoSuchAlgorithmException {
    MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
    return sha1.digest(input.getBytes());
  }

  //  SHA1 Encoding 된 Byte 배열을 다시 String으로 Decode
  public static String convertSHA1ToString(byte[] hashBytes) {
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

  // SHA1을 사용하여 URL을 해싱하고, 그 중 일부를 잘라 짧은 URL로 만듬
  public static String generateShortUrlWithSHA1(byte[] hashBytes) {
    // 20바이트(160비트)의 해시 중 앞의 12바이트(96비트)만 사용
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
