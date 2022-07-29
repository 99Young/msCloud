package com.yang.springcloud.base.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PojoUtil {

    static Logger logger = LoggerFactory.getLogger(PojoUtil.class);

    /**
     * json byte 转 实体
     *
     * @param bytes
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T JsonBytes2Object(byte[] bytes, Class<T> tClass) {
        //尽量把对象转换成JSON保存更稳妥
        try {
            String json = new String(bytes, "UTF-8");
            T t = JSON.parseObject(json, tClass);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object对象转成JSON字符串后，进一步转成字节数组
     *
     * @param obj
     * @return
     */
    public static byte[] object2JsonBytes(Object obj) {
        //把对象转换成JSON
        String json = pojoToJson(obj);
        try {
            return json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转字符串
     *
     * @param obj
     * @return
     */
    public static String pojoToJson(Object obj) {
        if (obj == null) {
            logger.error("pojoToJson 对象为 null");
            return "";
        }
        String result;
        try {
            result = JSON.toJSONString(obj);
        } catch (Exception e) {
            result = obj.toString();
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Byte[] 转 对象
     *
     * @param bytes
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T jsonBytes2Object(byte[] bytes, Class<T> tClass) {

        //尽量把对象转换成JSON保存更稳妥
        try {
            String json = new String(bytes, "UTF-8");
            return parseObject(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T parseObject(JSONObject jsonObj, Class<T> clazz) {
        return JSONUtil.toBean(jsonObj, clazz);
    }

    public static <T> T parseObject(Object object, Class<T> clazz) {
        String json = pojoToJson(object);
        return StrUtil.isEmpty(json) ? null : JSONUtil.toBean(json, clazz);
    }

    public static <T> T parseObject(String json, Class<T> type) {
        try{
            return JSON.parseObject(json, type);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }


    public static <T> List<T> parseArray(JSONArray jsonObj, Class<T> clazz) {
        return JSONUtil.toList(jsonObj, clazz);
    }


}
