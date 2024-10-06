# TOC
<!-- TOC -->
* [TOC](#toc)
  * [UUID](#uuid)
  * [Base64](#base64)
  * [구현](#구현)
    * [Encoding (UUID -> Base64)](#encoding-uuid---base64)
    * [Decoding (Base64 -> UUID)](#decoding-base64---uuid)
<!-- TOC -->

## UUID

| 128비트(16 바이트)로 Globaly Unique한 ID를 생성하는 생성자

UUID의 경우 내부적으로 128비트의 값을 가지고 있으며, 문자열로 표현했을 때 36자 길이를 가짐<br>
> 9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d (36자) {8}-{4}-{4}-{4}-{12}

- [참고](https://docs.tosspayments.com/resources/glossary/uuid)

## Base64

| Binary 데이터를 Base64 형식에 맞게끔 ASCII 문자열 형식으로 나타내는 인코딩 방식

Base64의 각 글자는 6비트의 정보를 표현하므로, 일반적으로는 Binary Date에 비해 30% 가량 데이터가 커짐

하지만 일반적으로 Hexdecimal의 경우 8비트로 2개의 글자를 표현하므로, 6비트에 1개의 문자를 표현하는 Base64에 비해 길어보일 수 있음

- [참고](https://developer.mozilla.org/ko/docs/Glossary/Base64)

## 구현

### Encoding (UUID -> Base64)
1. Java.Util.UUID를 사용해서 UUID 생성(V4)
2. UUID의 MSB(Most Significant Bit), LSB(Least Significant Bit)를 이용해서 Byte[16] 배열에 저장
3. 저장된 배열을 Java.Util.Base64의 URLEncoding을 이용해서 인코딩
   - withoutPadding() 메소드를 생성할 경우 22자
   - 기본 메소드(Padding 옵션)으로 생성할 경우 24자

### Decoding (Base64 -> UUID)
1. Java.Util.Base64의 URLDecoding을 이용해서 디코딩
2. 디코딩한 Byte 배열을 문자열로 변환
   1. Byte 배열을 16진수 형식의 문자열로 변환
        - 부호확장 및 패딩이 0이 되어야하므로 `0xFF & {byte}`로 16진수 변환
   2. 문자열의 길이가 1일 경우 0x0을 패딩으로 추가