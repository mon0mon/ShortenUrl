package xyz.mon0mon.shortenurl.domains.entity;

import jakarta.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class HashTypeConverter implements AttributeConverter<HashType, String> {

  @Override
  public String convertToDatabaseColumn(HashType attribute) {
    return attribute.name();
  }

  @Override
  public HashType convertToEntityAttribute(String dbData) {
    return EnumSet.allOf(HashType.class).stream()
        .filter(e -> e.name().equals(dbData))
        .findAny()
        .orElseThrow(NoSuchElementException::new);
  }
}
