package com.example.junit;

import org.junit.jupiter.api.*;

public class JUnitTest {
    @Test
    @Disabled
    void create(){
        System.out.println("create1");
    }

    @BeforeAll // 모든 테스트가 실행되기 전 동작한다. static으로 선언해야 된다.
    static void beforeAll(){
        System.out.println("before All");
    }

    @AfterAll // 모든 테스트가 실행된 후 동작한다.
    static void afterAll(){
        System.out.println("after All");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each");
    }
}
