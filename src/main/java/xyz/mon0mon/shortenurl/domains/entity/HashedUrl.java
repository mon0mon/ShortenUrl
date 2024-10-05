package xyz.mon0mon.shortenurl.domains.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HASHED_URL", indexes = {
    @Index(name = "idx_hashedurl_url", columnList = "url"),
    @Index(name = "idx_hashedurl_shortenurl", columnList = "shortenUrl")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HashedUrl extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String url;

  @Column(length = 24, unique = true, nullable = false)
  private String shortenUrl;

  @Column
  @Default
  private LocalDateTime expiredAfter = LocalDateTime.MAX;

  @Convert(converter = HashTypeConverter.class)
  private HashType hashType;
}
