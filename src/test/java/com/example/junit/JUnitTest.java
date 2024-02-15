package com.example.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JUnitTest {
    @Test
    @DisplayName("스터디 만들기")
    @Tag("fast")
    void create(){
        System.out.println("create1");
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, StudyStatus.STARTED);
    }

    @Test
    @Disabled
    @Tag("slow")
    void createTest(){
        System.out.println("create2 느린 테스트");

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
