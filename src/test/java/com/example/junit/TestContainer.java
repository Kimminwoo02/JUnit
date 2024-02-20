package com.example.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Testcontainers
public class TestContainer {
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();

    @BeforeAll
    static void beforeAll(){
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll(){
        postgreSQLContainer.stop();
    }

    @Test
    void createNewStudy(){

    }
}
