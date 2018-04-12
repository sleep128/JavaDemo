package com.sleep.JAVA8.testOptional;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * @author wb-zy215796
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional<String> userName = Optional.ofNullable(getMap(2))
                .map(user -> user.getName());
        System.out.println(userName.get());
    }

    private static User getMap(int i){
        User user = new User();
        user.setName("sleepDemo");
        if(i==1){
            return user;
        }else{
            return null;
        }
    }

    private static class User{
        private String name;

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
