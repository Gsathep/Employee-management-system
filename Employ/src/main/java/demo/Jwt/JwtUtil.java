package demo.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    @Value("${app.secret}")
    private String secret;
//1
    public String generateToken(String subject) {
        return   Jwts.builder()
                .setSubject(subject)
                .setIssuer("multisensory")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.toMillis(30)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }
    //2
    public Claims getClaims(String Token)
    {
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(Token).getBody();
    }
    //3
    public Date getExpDate(String Token)
    {
        return getClaims(Token).getExpiration();
    }
    //4
    public String getUsername(String Token)
    {
        return getClaims(Token).getSubject();
    }
    //5
    public boolean isTokenEp(String Token)
    {
        Date d=getExpDate(Token);
        return d.before(new Date(System.currentTimeMillis()));
    }
    public boolean validateToken(String  Token)
    {
        String Tokenusername=getUsername(Token);
        return Tokenusername.equals(Tokenusername)&&!isTokenEp(Token);
    }
}