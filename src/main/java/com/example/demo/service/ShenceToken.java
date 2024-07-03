package com.example.demo.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;

/**
 * @description:
 * @author: wl
 * @createDate: 2024/2/20 2:22 PM
 */
public class ShenceToken {
    public static void main(String[] args) {

        String scret = "be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610";
        String url  = "https://anylysis.inovelclub.com/api/auth/login?project=production&token="+scret+"&project=production";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("username","wangli");
        paramMap.put("expired_interval","14400");
        String rspStr = HttpRequest.post(url)
                .contentType("application/json")
                .body(JSONUtil.toJsonStr(paramMap))
                .timeout(60000)//超时，毫秒
                .execute().body();

        System.out.println(rspStr);
        // {"user_id":23,"token":"dQgHyBOEVRzpjHl6yeQ2z8DDR29l7dlowPGGdOavP9PnWkJ3DMR3QkA2a0j7F1QK6eISsDyy6ZU4Gf6RZPYVY5dR9IdqOYItfVIAtX0aBbpbSBifAS2VihmZVObKZYxZ","username":"wangli"}
        // {"user_id":15,"token":"Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm","username":"zhujinhui"}
    }
}
