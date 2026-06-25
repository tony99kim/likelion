package org.example.basicjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
public class JwtExample {
    public static void main(String[] args) {
        SecretKey randomKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        log.info("랜덤 키: {}", randomKey);

// 방법 2: 문자열로부터 키 생성 (같은 문자열이면 항상 같은 키 생성)
        String secret = "abcdefghijklmnopqrstuvwxzy123456";
        SecretKey signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        log.info("문자열 키: {}", signingKey);

//2. JWT 생성
        String jwt = Jwts.builder()
                .issuer("lion-authserver") //토큰을 발급한 주체
                .subject("carami") //username  토큰의 주인. 사용자ID or email
                .audience().add("lion-server").and()  // 이 토큰은 누구를 위한 것인가를 명시해서 의도하지 않은 곳에서 사용을 방지
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //토큰만료시간  3600초 = 60분 = 1시간입니다.
                .issuedAt(new Date()) //토큰 발급시간
                .notBefore(new Date()) //토큰이 유효해지는 시간설정 이 시간 전에는 토큰을 사용할 수 없음.
                .claim("role", "ADMIN") //커스텀데이터, 표준 클레임외에 필요한 정보를 넣을 수 있다.
                .signWith(signingKey)  //토큰에 서명추가
                .compact();//jwt 문자열로 변환

        log.info("생성된 JWT: {}", jwt);

        //3. JWT 파싱 및 검증

        Claims claims = Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

        // 클레임 정보 출력
        log.info("=== JWT 검증 성공 ===");
        log.info("발급자: {}", claims.getIssuer());
        log.info("사용자 ID: {}", claims.getSubject());
        log.info("대상: {}", claims.getAudience());
        log.info("발급 시간: {}", claims.getIssuedAt());
        log.info("만료 시간: {}", claims.getExpiration());
        log.info("역할: {}", claims.get("role", String.class));

    }
}
