package com.myblog.Service.Impl;

import com.myblog.Common.RedisConstants;
import com.myblog.Common.TokenTimeConstants;
import com.myblog.Utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class TokenRedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //内部方法保存用户单个token
    private void saveUserToken(Long userId,String token,String prefix,long expire){
        String key=prefix+userId;
        stringRedisTemplate.opsForSet().add(key, token);
        stringRedisTemplate.expire(key,expire, TimeUnit.MILLISECONDS);
    }

    //保存accessToken
    public void saveAccessToken(Long userId,String accessToken){
        saveUserToken(userId,accessToken, RedisConstants.USERTOKENLIST_ACCESS_PREFIX,TokenTimeConstants.ACCESS_TOKEN_EXPIRE);
    }

    //保存refreshToken
    public void saveRefreshToken(Long userId,String refreshToken){
        saveUserToken(userId,refreshToken, RedisConstants.USERTOKENLIST_REFRESH_PREFIX,TokenTimeConstants.REFRESH_TOKEN_EXPIRE);
    }

    //保存refreshLongToken
    public void saveRefreshLongToken(Long userId,String refreshLongToken){
        saveUserToken(userId,refreshLongToken, RedisConstants.USERTOKENLIST_REFRESH_PREFIX,TokenTimeConstants.REFRESH_TOKEN_LONG_EXPIRE);
    }

    //将一个令牌加入黑名单
    public  void addTokenToBlackList(String token){
        //解析获取过期时间
        long remainingTime= JwtUtil.getRemainingTimes(token);
        if(remainingTime>0){
            String redisKey= RedisConstants.BLACKLIST_KEY_PREFIX+token;
            stringRedisTemplate.opsForValue().set(redisKey,"black",remainingTime, TimeUnit.MILLISECONDS);
        }
    }

    //将用户所有令牌加入黑名单
    public  void addAllTokensToBlackList(Long userId){
        //记录用户所持有token的key
        String accessKey= RedisConstants.USERTOKENLIST_ACCESS_PREFIX+userId;
        String refreshKey= RedisConstants.USERTOKENLIST_REFRESH_PREFIX+userId;

        //获取该用户所有token并加入黑名单
        Set<String> accessTokens = stringRedisTemplate.opsForSet().members(accessKey);
        if(accessTokens!=null) {
            for (String accessToken : accessTokens) {
                addTokenToBlackList(accessToken);
            }
        }

        Set<String> refreshTokens = stringRedisTemplate.opsForSet().members(refreshKey);
        if(refreshTokens!=null) {
            for (String refreshToken : refreshTokens) {
                addTokenToBlackList(refreshToken);
            }
        }
        stringRedisTemplate.delete(accessKey);
        stringRedisTemplate.delete(refreshKey);
    }



}
