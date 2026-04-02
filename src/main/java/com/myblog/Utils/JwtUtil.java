package com.myblog.Utils;


import com.myblog.Common.RedisPrefixConstants;
import com.myblog.Common.TokenTimeConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//TODO 后续component需要删除
@Component
public class JwtUtil {

    private JwtUtil(){}

    //@Resource
    private static StringRedisTemplate stringRedisTemplate;

    //TODO 后续需要删除
    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        JwtUtil.stringRedisTemplate = stringRedisTemplate;
    }

    //创建密钥
    private static final String SECRET_KEY = "hello,myblog,aaabbbcccdddeeefff12345";

    // 将字符串密钥转换为 HMAC256 所需的 Key 对象
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    //生成accessToken
    public static String generateAccessToken(Map<String,Object> claims){
        return generateToken(claims, TokenTimeConstants.ACCESS_TOKEN_EXPIRE,"access");
    }

    //生成refreshToken
    public static String generateRefreshToken(Map<String,Object> claims){
        return generateToken(claims,TokenTimeConstants.REFRESH_TOKEN_EXPIRE,"refresh");
    }

    //生成refreshTokenLong
    public static String generateRefreshTokenLong(Map<String,Object> claims){
        return generateToken(claims,TokenTimeConstants.REFRESH_TOKEN_LONG_EXPIRE,"refresh");
    }


    //内部方法，通用生成token
    private static String generateToken(Map<String, Object> claims,long expire,String type) {
        Date now = new Date();
        Date expiryDate =new Date(now.getTime()+expire);
        claims.put("type:",type);
        return Jwts.builder()
                .setClaims(claims)//自定义载荷
                .setIssuedAt(now)//签发时间
                .setExpiration(expiryDate)//过期时间
                .signWith(KEY)//加密方法
                .compact();
    }

	//接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //获取剩余有效时间（毫秒）accessToken和refreshToken均适用
    public static long getRemainingTimes(String token){
        Map<String ,Object> claims=JwtUtil.parseToken(token);
        //修改将Integer转化为long的方法
        long expSecondTime = Long.parseLong(claims.get("exp").toString());
        return expSecondTime*1000-System.currentTimeMillis();
    }

    //把令牌加入redis黑名单
    public static void addTokenToBlackList(String token){
        //解析获取过期时间
        long remainingTime= JwtUtil.getRemainingTimes(token);
        if(remainingTime>0){
            String redisKey= RedisPrefixConstants.BLACKLIST_KEY_PREFIX+token;
            stringRedisTemplate.opsForValue().set(redisKey,"black",remainingTime, TimeUnit.MILLISECONDS);
        }
    }



}
