package com.myblog.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserHolderUtil {
    private  UserHolderUtil(){}

    private static final Map<String,Object> claims=ThreadLocalUtil.get();

    public static String getUserHolderName(){
        return claims.get("username").toString();
    }

    public static Long getUserHolderId(){
        return ((Number)claims.get("userId")).longValue();
    }

    public static Long getUserHolderStatus(){
        //ps:当 userId 数值在 Integer 范围（-2147483648 ~ 2147483647）内时，
        // claims.get("userId") 返回的是 Integer 类型,不能直接把Integer强制转换成是Long

        return ((Number)claims.get("status")).longValue();
    }

    public static Boolean getUserHolderIsDeleted(){
        return (Boolean) claims.get("isDeleted");
    }


    public static List<Long> getUserHolderRoleIds(){
        //不能直接强转泛型列表，泛型擦除会造成运行时不匹配
        Object roleIdsObj=claims.get("roleIds");
        if(!(roleIdsObj instanceof List<?>)){
            return Collections.emptyList();
        }
        List<?> tempList=(List<?>)roleIdsObj;
        List<Long> resultList=new ArrayList<>();
        for(Object obj:tempList){
            if(obj instanceof Long){
                resultList.add((Long)obj);
            }else if (obj instanceof Integer) {
                // 兼容Integer类型，自动转成Long（兜底）
                resultList.add(((Integer) obj).longValue());
            }
        }
        return resultList;
    }

}
