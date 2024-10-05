package xyz.mon0mon.shortenurl.service;

import java.util.Arrays;

public interface HashedUrlService {

  byte[] getEncodedByteArray(String input);

  default String getEncodedString(String input) {
    return Arrays.toString(getEncodedByteArray(input));
  }

  byte[] getShortenedEncodedByteArray(String input, int length);

  default String getShortenedEncodedString(String input, int length) {
    return Arrays.toString(getShortenedEncodedByteArray(input, length));
  }
}
