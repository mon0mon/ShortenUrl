package xyz.mon0mon.shortenurl.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UUIDBase64UrlService implements HashedUrlService{

  /**
   *
   * @param input
   * @return
   */
  @Override
  public byte[] getEncodedByteArray(String input) {
    UUID uuid;

    try {
      uuid = UUID.fromString(input);
    } catch (IllegalArgumentException e) {
      log.warn("Given Input Doesn't match with UUID");
      log.warn("Create New UUID");
      uuid = UUID.randomUUID();
    }

    //  UUID Byte를 저장할 배열 선언
    byte[] bytes = new byte[16];
    long mostSigBits = uuid.getMostSignificantBits();
    long leastSigBits = uuid.getLeastSignificantBits();

    //  MSB와 LSB의 값을 byte 배열로 옮김
    for (int i = 0; i < 8; i++) {
      bytes[i] = (byte) (mostSigBits >>> 8 * (7 - i));
      bytes[8 + i] = (byte) (leastSigBits >>> 8 * (7 - i));
    }

    return bytes;
  }

  @Override
  public byte[] getShortenedEncodedByteArray(String input) {


    return new byte[0];
  }
}
