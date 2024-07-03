package com.example.demo.service;

import cn.hutool.Hutool;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.net.URLEncoder;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: wl
 * @createDate: 2024/2/20 1:48 PM
 */
public class TestShence {

//    public static void main(String[] args) {
//        String token = "FcUKLurBJXAQPpPCIv4NgATbeyACBxB8L1DFhWIVuthjY9GU6BkyoCI0QCxTntMclkoJFPVPJoiGjMKppYn0mdTMeTio9teuvYFxsT9MeKRkwV400GecmizpaWOGFSXw";
//        String url  = "https://anylysis.inovelclub.com/api/v3/analytics/v1/model/sql/query";
//
//        String jsonStr = "{\"sql\":\"SELECT account_id,user_level,create_time FROM users WHERE account_id='1963142'\",\"limit\":\"100\",\"request_id\":\"12345696321548954\"}";
//        String rspStr = HttpRequest.post(url)
//                .contentType("application/json")
//                .header("sensorsdata-token",token)
//                .body(jsonStr)
//                .timeout(60000)//超时，毫秒
//                .execute().body();
//        System.out.println(rspStr);
//    }

    // 统计过万记录查询结果 设置limit
//    public static void main(String[] args) {
//        /**
//         * {"user_id":15,
//         * "token":"Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm"
//         * ,"username":"zhujinhui"}
//         */
////        String token = "Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm";
//        String token = "FcUKLurBJXAQPpPCIv4NgATbeyACBxB8L1DFhWIVuthjY9GU6BkyoCI0QCxTntMclkoJFPVPJoiGjMKppYn0mdTMeTio9teuvYFxsT9MeKRkwV400GecmizpaWOGFSXw";
//        String url  = "https://anylysis.inovelclub.com/api/events/report?project=production";
//        // "limit": 30000,
//        /**
//         *
//         * {
//         *     "approx": false,
//         *     "sampling_factor": 64,
//         *     "by_fields": ["user.account_id"],
//         *     "measures": [{
//         *         "event_name": "$AppStart",
//         *         "aggregator": "unique",
//         *         "name": "App 启动的用户数"
//         *     }],
//         *     "from_date": "2024-02-20",
//         *     "to_date": "2024-02-20",
//         *     "unit": "day",
//         *     "sub_task_type": "SEGMENTATION",
//         *     "limit": 30000,
//         *     "use_cache": true
//         * }
//         *
//         *
//         */
//        String jsonStr = "{\"approx\":false,\"sampling_factor\":64,\"by_fields\":[\"user.account_id\"],\"measures\":[{\"event_name\":\"$AppStart\",\"aggregator\":\"unique\",\"name\":\"App 启动的用户数\"}],\"from_date\":\"2024-02-20\",\"to_date\":\"2024-02-20\",\"unit\":\"day\",\"sub_task_type\":\"SEGMENTATION\",\"limit\":30000,\"use_cache\":true}";
//        String rspStr = HttpRequest.post(url)
//                .contentType("application/json")
//                .header("sensorsdata-token",token)
//                .body(jsonStr)
//                .timeout(60000)//超时，毫秒
//                .execute().body();
//        System.out.println(rspStr);
//    }



    // 查询用户产品4的包的 按日期活跃用户
//    public static void main(String[] args) {
//        /**
//         * {"user_id":15,
//         * "token":"Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm"
//         * ,"username":"zhujinhui"}
//         */
////        String token = "dQgHyBOEVRzpjHl6yeQ2z8DDR29l7dlowPGGdOavP9PnWkJ3DMR3QkA2a0j7F1QK6eISsDyy6ZU4Gf6RZPYVY5dR9IdqOYItfVIAtX0aBbpbSBifAS2VihmZVObKZYxZ";
//        String token = "FcUKLurBJXAQPpPCIv4NgATbeyACBxB8L1DFhWIVuthjY9GU6BkyoCI0QCxTntMclkoJFPVPJoiGjMKppYn0mdTMeTio9teuvYFxsT9MeKRkwV400GecmizpaWOGFSXw";
//        String url  = "https://anylysis.inovelclub.com/api/events/report?project=production";
//
//        String jsonStr = "{\"approx\":false,\"sampling_factor\":64,\"by_fields\":[\"user.account_id\"],\"filter\":{\"conditions\":[{\"field\":\"user.product_id\",\"function\":\"equal\",\"params\":[\"4\"],\"$$searchValue\":\"产品\",\"$$render_index\":1}]},\"measures\":[{\"event_name\":\"$AppStart\",\"aggregator\":\"unique\",\"name\":\"App 启动的用户数\"}],\"from_date\":\"2024-02-20\",\"to_date\":\"2024-02-20\",\"unit\":\"day\",\"sub_task_type\":\"SEGMENTATION\",\"time_zone_mode\":\"\",\"server_time_zone\":\"\",\"compareKey\":\"\",\"bucket_params\":{},\"topN\":50,\"use_cache\":true}";
//        String rspStr = HttpRequest.post(url)
//                .contentType("application/json")
//                .header("sensorsdata-token",token)
//                .body(jsonStr)
//                .timeout(60000)//超时，毫秒
//                .execute().body();
//        System.out.println(rspStr);
//    }


    // 批量导入数据
//    public static void main(String[] args) {
//        /**
//         * {"user_id":15,
//         * "token":"Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm"
//         * ,"username":"zhujinhui"}
//         *
//         * curl 'https://anylysis.inovelclub.com/api/sql/query?token=be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610&project=production' \
//         * -X POST \
//         * --data-urlencode "q=SELECT * FROM events LIMIT 10" \
//         * --data-urlencode "format=json"
//         *
//         */
////        String token = "dQgHyBOEVRzpjHl6yeQ2z8DDR29l7dlowPGGdOavP9PnWkJ3DMR3QkA2a0j7F1QK6eISsDyy6ZU4Gf6RZPYVY5dR9IdqOYItfVIAtX0aBbpbSBifAS2VihmZVObKZYxZ";
//        String token = "FcUKLurBJXAQPpPCIv4NgATbeyACBxB8L1DFhWIVuthjY9GU6BkyoCI0QCxTntMclkoJFPVPJoiGjMKppYn0mdTMeTio9teuvYFxsT9MeKRkwV400GecmizpaWOGFSXw";
//        String scurl  = "https://anylysis.inovelclub.com/api/sql/query?token=be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610&project=production";
//
//        String result = HttpRequest.post(scurl)
//                .header("Content-Type", "application/x-www-form-urlencoded") // 设置请求头
//                .form("q", "SELECT account_id,user_level,create_time FROM users where account_id IS NOT NULL LIMIT 20000") // 设置表单内容
////                .form("format", "csv") // 设置表单内容
//                .form("format", "json") // 设置表单内容
//                .timeout(60000)//超时，毫秒
//                .execute() // 执行请求
//                .body(); // 获取响应体
//        System.out.println(result);
//        if (StrUtil.isNotEmpty(result)){
//
//        }else {
//            System.out.println("导入完毕");
//        }
//
//
//
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<User> userList = new ArrayList<>();
//
//        try {
//            String[] jsonStrings = result.split("\n");
//
//            for (String json : jsonStrings) {
//                User user = objectMapper.readValue(json, User.class);
//                userList.add(user);
//            }
//
//            // 打印结果
//            for (User user : userList) {
//                System.out.println(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        String url = "jdbc:mysql://localhost:3306/flush_user";
//        String username = "root";
//        String password = "root";
//        // JDBC连接对象
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//
//            // SQL插入语句
//            String insertSQL = "INSERT INTO scuser ( account_id, level) VALUES ( ?, ?)";
//
//            // 使用PreparedStatement预编译SQL语句
//            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
//                // 设置参数值
//                for (User u:userList) {
//                    preparedStatement.setString(1, u.getAccountId());
//                    preparedStatement.setString(2, u.getUserLevel());
//                    preparedStatement.addBatch();
//                }
//                // 执行插入操作
//                int[] insterResult = preparedStatement.executeBatch();
//
//                // 检查批量插入的结果
//                for (int i : insterResult) {
//                    if (i == PreparedStatement.EXECUTE_FAILED) {
//                        System.out.println("批量插入失败！");
//                        // 可以处理失败的情况
//                    }
//                }
//
//                System.out.println("批量插入成功！");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    // 批量写数据
//    public static void main(String[] args) {
//        /**
//         * {"user_id":15,
//         * "token":"Gz3ZgiJcZZJfMUERc8I3GUp8YlVxQJ4n2NgkUio8GprCUhjo1Hy11vz9NdVg8d2Mn4MbdTFyX7CQnvwF8QcsBciqDD6Ob0I9WwOCR1wSvzLbhApOxzAylDra63jbpoSm"
//         * ,"username":"zhujinhui"}
//         *
//         * curl 'https://anylysis.inovelclub.com/api/sql/query?token=be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610&project=production' \
//         * -X POST \
//         * --data-urlencode "q=SELECT * FROM events LIMIT 10" \
//         * --data-urlencode "format=json"
//         *
//         */
////        String token = "dQgHyBOEVRzpjHl6yeQ2z8DDR29l7dlowPGGdOavP9PnWkJ3DMR3QkA2a0j7F1QK6eISsDyy6ZU4Gf6RZPYVY5dR9IdqOYItfVIAtX0aBbpbSBifAS2VihmZVObKZYxZ";
//        boolean next = true;
//        int count  = 1;
//        int start_index = 0;
//        int page_size = 1000;
//
//        // token 必须是管理员的token
//        String scurl  = "https://anylysis.inovelclub.com/api/sql/query?token=be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610&project=production";
//
//
//        String url = "jdbc:mysql://localhost:3306/flush_user";
//        String username = "root";
//        String password = "root";
//
//        while (next){
//            System.out.println("导入 第 "+start_index+" 到 "+ page_size +"条数据");
//            String sql = "SELECT account_id,user_level,create_time FROM users where account_id IS NOT NULL ORDER BY account_id ASC LIMIT "+start_index+","+page_size;
//            System.out.println(sql);
//            String result = HttpRequest.post(scurl)
//                    .header("Content-Type", "application/x-www-form-urlencoded") // 设置请求头
//                    .form("q", sql) // 设置表单内容
////                .form("format", "csv") // 设置表单内容
//                    .form("format", "json") // 设置表单内容
//                    .timeout(60000)//超时，毫秒
//                    .execute() // 执行请求
//                    .body(); // 获取响应体
//            System.out.println("==================");
////            System.out.println(result);
//            if (StrUtil.isNotEmpty(result)){
//
//            }else {
//                System.out.println("导入完毕");
//                next =false;
//            }
//
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<User> userList = new ArrayList<>();
//
//            try {
//                String[] jsonStrings = result.split("\n");
//
//                for (String json : jsonStrings) {
//                    User user = objectMapper.readValue(json, User.class);
//                    userList.add(user);
//                }
////                // 打印结果
////                for (User user : userList) {
////                    System.out.println(user);
////                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("查询到到数据长度:"+userList.size());
//            // JDBC连接对象
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//
//                // SQL插入语句
//                String insertSQL = "INSERT INTO scuser ( account_id, level) VALUES ( ?, ?)";
//
//                // 使用PreparedStatement预编译SQL语句
//                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
//                    // 设置参数值
//                    for (User u:userList) {
//                        preparedStatement.setString(1, u.getAccountId());
//                        preparedStatement.setString(2, u.getUserLevel());
//                        preparedStatement.addBatch();
//                    }
//                    // 执行插入操作
//                    int[] insterResult = preparedStatement.executeBatch();
//
//                    // 检查批量插入的结果
//                    for (int i : insterResult) {
//                        if (i == PreparedStatement.EXECUTE_FAILED) {
//                            System.out.println("批量插入失败！");
//                            // 可以处理失败的情况
//                        }
//                    }
//
//                    System.out.println("批量插入成功！");
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            start_index = page_size + start_index ;
//        }
//    }

        public static void main(String[] args) {

        boolean next = true;
        int count  = 1;
        int start_index = 0;
        int page_size = 1000;

        // token 必须是管理员的token
        String scurl  = "https://anylysis.inovelclub.com/api/sql/query?token=be07acb980ec6aec3487aaceb8fa73536eae153ba2e4b54c1b33e7e8ffcf0610&project=production";


        String sql = "SELECT event,is_success,account_id,`date`,`time`,top_up_cash,top_up_bonus,top_up_coins FROM events WHERE event='recharge_result' and is_success=1 and date ='2024-02-20 00:00:00'";
        System.out.println(sql);
        String result = HttpRequest.post(scurl)
                .header("Content-Type", "application/x-www-form-urlencoded") // 设置请求头
                .form("q", sql) // 设置表单内容
//                .form("format", "csv") // 设置表单内容
                .form("format", "json") // 设置表单内容
                .timeout(60000)//超时，毫秒
                .execute() // 执行请求
                .body(); // 获取响应体
        System.out.println("==================");
        System.out.println(result);
    }


}
