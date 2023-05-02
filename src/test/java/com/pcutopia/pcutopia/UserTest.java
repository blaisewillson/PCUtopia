package com.pcutopia.pcutopia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @org.junit.jupiter.api.Test
    public void test_setUserId(){
        User user = new User("John", "hello@gmail.com", "password");
        User user2 = new User("Mary", "bye@gmail.com", "password");
        assertNotSame(user.getUserID(), user2.getUserID());
    }

    @org.junit.jupiter.api.Test
    public void test_getUsername(){
        User user = new User("John", "hello@gmail.com", "password");
        assertEquals("John", user.getUsername());
    }

    @org.junit.jupiter.api.Test
    public void test_getPassword(){
        User user = new User("John", "hello@gmail.com", "password");
        assertEquals("password", user.getPassword());
    }
}