package xyz.mon0mon.shortenurl.sample;

import java.util.Base64;
import java.util.UUID;

public class UUIDBase64Example {
  public static void main(String[] args) {
    UUID uuid = UUID.randomUUID();
    System.out.println("Original UUID: " + uuid + " (" + uuid.toString().length() + ")");

    // UUID를 바이트 배열로 변환
    byte[] uuidBytes = uuidToBytes(uuid);

    // Base64로 인코딩
    String base64UUID = Base64.getUrlEncoder().withoutPadding().encodeToString(uuidBytes);
    System.out.println("Base64 Encoded UUID: " + base64UUID + " (" + base64UUID.length() + ")");
    String decodedBase64UUID = convertBase64ToString(Base64.getUrlDecoder().decode(base64UUID));
    System.out.println("decodedBase64UUID : " + decodedBase64UUID + " (" + decodedBase64UUID.length() + ")");
  }

  // UUID를 바이트 배열로 변환하는 메소드
  public static byte[] uuidToBytes(UUID uuid) {
    byte[] bytes = new byte[16];
    long mostSigBits = uuid.getMostSignificantBits();
    long leastSigBits = uuid.getLeastSignificantBits();

    for (int i = 0; i < 8; i++) {
      bytes[i] = (byte) (mostSigBits >>> 8 * (7 - i));
      bytes[8 + i] = (byte) (leastSigBits >>> 8 * (7 - i));
    }
    return bytes;
  }

  //  BASE64 Decoding 된 Byte 배열을 다시 String으로 Decode
  public static String convertBase64ToString(byte[] hashBytes) {
    StringBuilder sb = new StringBuilder();
    for (byte hashByte : hashBytes) {
      String hex = Integer.toHexString(0xFF & hashByte);
      if (hex.length() == 1) {
        sb.append('0');
      }
      sb.append(hex);
    }
    String unformattedString = sb.toString();
    return String.format("%s-%s-%s-%s-%s", unformattedString.substring(0,8), unformattedString.substring(8,12), unformattedString.substring(12,16), unformattedString.substring(16,20), unformattedString.substring(20, 32));
  }
}
