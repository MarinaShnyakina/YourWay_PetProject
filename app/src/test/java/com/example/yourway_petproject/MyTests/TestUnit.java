package com.example.yourway_petproject.MyTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUnit {

    @Test
    public void testInputPassword() {
        assertEquals("Ошибка! Пароль должен быть более 7 символов","Пароль", "Пароль");
    }

    @Test
    public void testInputPasswordFalse() {
        String password = "qwsdf";
            assertEquals("Пароль должен быть более 7 символов", password);
        }


    @Test
    public void testInputPasswordTrue() {
        String password = "qwsdfgg";
            assertEquals("Пароль введен верно", password);
        }
    }
