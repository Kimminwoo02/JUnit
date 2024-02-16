package com.example.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudyServiceTest {



    @Test
    void createStudyService(){

        ;
        StudyService studyService = new StudyService();
        assertNotNull(studyService);
        Assertions.assertEquals("Assertions 사용방법입니다.","이렇게 실행 시 에러가 나옵니다.");
    }

}
