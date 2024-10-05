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
}
