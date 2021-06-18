package com.leeseast2Z.serializable.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @Author: limf
 * @Date: 2021/6/15 11:48
 * @Description: get方法NPE异常
 *
 * jackson在进行序列化时，会迭代类里的属性、方法(get和is开头的方法)，获取要进行序列化的字段，在这个过程中，识别出
 * 之后，在序列化的过程中，会通过反射调用方法
 * 因此，当反射执行getTotals()方法时，由于方法内有的字段是null，就出现了npe错误。
 *
 * 在使用jackson进行序列化和反序列化时，
 * 要注意is和get开头的方法，序列化器会把这个方法名识别为一个字段，然后通过反射区执行这个方法，
 * 当这个方法里的字段没有初始化时，就会出现npe问题。
 *
 * https://www.huaweicloud.com/articles/ac5459b8609c14170b613d81d413b628.html
 */
public class GetterNPE {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
       /* Bean bean = new Bean();
        try {
            mapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        Bean2 bean2 = new Bean2();
        bean2.setCode(0);
        try {
            //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            //String value = mapper.writeValueAsString(bean2);
            //System.out.println("value = " + value);
            JsonMapper jsonMapper = new JsonMapper();
            String value1 = jsonMapper.writeValueAsString(bean2);
            System.out.println("value1 = " + value1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    static class Bean implements Serializable {
        private Integer qs;
        private Integer ms;

        public Integer getQs() {
            return qs;
        }

        public void setQs(Integer qs) {
            this.qs = qs;
        }

        public Integer getMs() {
            return ms;
        }

        public void setMs(Integer ms) {
            this.ms = ms;
        }

        /**
         * jackson序列化抛出NPE异常
         * @return
         */
        public Integer getTotals() {
            return qs + ms;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class Bean2 {
        private Integer code;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }
}
