# TOC
<!-- TOC -->
* [TOC](#toc)
  * [URL Shortening](#url-shortening)
    * [참고 사이트 분석](#참고-사이트-분석)
      * [NaverMap](#navermap)
      * [TextCompare](#textcompare)
<!-- TOC -->

## URL Shortening
| URL 단축 구현 방법

기존의 긴 URL이 아닌, 짧은 URL로 만드는 기능

- 참고 사이트
  - [Naver 지도](https://naver.me/GulDSZRB)
  - [TextCompare](https://www.textcompare.org/?id=67007cd1df5ff975713ed9db)

### 참고 사이트 분석
#### NaverMap

> 알파벳과 숫자가 섞인 형태 
> <br>대소문자 구분이 존재 (GulDSZRB != GulDSZRb)

위와 같은 형식이라고 가정 했을 때, 한 글자에 가능한 경우의 수는 다음과 같음
- 숫자 (0 - 9) -> 10개
- 소문자 알파벳 (a - z) -> 26개
- 대문자 알파벳 (A - Z) -> 26개
- => 총합 : 10 + 26 + 26 = 62개

각 자리마다 별도의 경우의 수가 있으므로 8자리를 기준으로 하였을 때, 가능한 경우의 수는 다음과 같음

- 62 * 62 ... = 62^8 = 218,340,105,584,896

#### TextCompare

> 24자의 UID를 생성하는 방식

구체적인 코드가 없기에, 생성 방식에 대해서 추측
1. MongoDB Object ID
2. UUID V4를 Base 64로 인코딩 한 값 [Code](https://www.jdoodle.com/ia/1jPW)
3. SHA1, MD5 해쉬 값에서 24자리만 추출해서 사용 [SHA1](https://www.jdoodle.com/ia/1jPV), [MD5](https://www.jdoodle.com/ia/1jPQ)

위 방법 중에서 2번과 3번 방법으로 구현 예정


