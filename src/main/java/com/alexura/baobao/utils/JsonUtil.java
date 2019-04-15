package com.alexura.baobao.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 6:34 PM
 */
public class JsonUtil {
    private static final Log log = LogFactory.getLog(JsonUtil.class);
    private static ObjectMapper mapper = new ObjectMapper();
    static{
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //设置序列化配置，为null的属性不加入到json中
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //兼容单引号 但单引号不属于json标准 不建议使用
    }
    /**
     * 将对象转换成json字符串,如果转换失败则返回null
     * @param o 需要转换为json的对象
     * @return String 转换后的json字符串
     * */
    public static String write2JsonStr(Object o){
        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("write2JsonStr() exception: " + e.getMessage());
        }
        return jsonStr;
    }

}
