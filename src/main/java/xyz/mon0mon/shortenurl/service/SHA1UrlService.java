package xyz.mon0mon.shortenurl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SHA1UrlService implements HashedUrlService{

  @Override
  public byte[] getEncodedByteArray(String input) {
    return new byte[0];
  }

  @Override
  public byte[] getShortenedEncodedByteArray(String input) {
    return new byte[0];
  }
}
