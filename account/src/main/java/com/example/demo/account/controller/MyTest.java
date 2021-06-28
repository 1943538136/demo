package com.example.demo.account.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author :tanjm
 * Date:  2021/6/28
 * Desc:
 */
public class MyTest {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("secret"));
        System.out.println(passwordEncoder.encode("admin"));
    }
}
