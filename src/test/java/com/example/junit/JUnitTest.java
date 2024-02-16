package com.example.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JUnitTest {
    @Test
    @DisplayName("스터디 만들기")
    // @Tag("fast")
    @FastTest
    void create(){
        System.out.println("create1");
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, StudyStatus.STARTED);
    }

    @Test
    @Disabled
    // @Tag("slow")
    @SlowTest
    void createTest(){
        System.out.println("create2 느린 테스트");

    }

    @RepeatedTest(10)
    void repeatTest(RepetitionInfo repetitionInfo){

        System.out.println("테스트 반복" + repetitionInfo.getCurrentRepetition());
        System.out.println("테스트 반복" + repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이" ,"추워지고","있네요"})
    void parameterizedTest(String message){
        System.out.println(message);
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
