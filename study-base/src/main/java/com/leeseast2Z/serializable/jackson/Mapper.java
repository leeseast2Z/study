package com.leeseast2Z.serializable.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.leeseast2Z.serializable.jackson.vo.ResponseVO;

import java.io.Serializable;

/**
 * @Author: limf
 * @Date: 2021/6/18 11:11
 * @Description:
 */
public class Mapper {

    public static void main(String[] args) {
        /*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        Bean bean = new Bean();
        bean.setAge(0);
        bean.setAge2(0);
        bean.setName(null);
        bean.setMessage(" ");
        try {
            String value = objectMapper.writeValueAsString(bean);
            System.out.println("value = " + value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/

        ResponseVO<Object> success = ResponseVO.success();
        JsonMapper jsonMapper = new JsonMapper();
        try {
            String asString = jsonMapper.writeValueAsString(success);
            System.out.println("asString = " + asString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class Bean implements Serializable {
        private String name;
        private Integer age;
        private int age2;
        private String message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public int getAge2() {
            return age2;
        }

        public void setAge2(int age2) {
            this.age2 = age2;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
