package com.example.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudyServiceTest {
    @Mock
    StudyRepository studyRepository;


    @Test
    void createStudyService(){
        StudyService studyService = new StudyService();
        assertNotNull(studyService);
        Assertions.assertEquals("Assertions 사용방법입니다.","이렇게 실행 시 에러가 나옵니다.");
    }


    @Test
    void  createStudyService2(){

        StudyRepository studyRepository = Mockito.mock(StudyRepository.class);


    }

}
