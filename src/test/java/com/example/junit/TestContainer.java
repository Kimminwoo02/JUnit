package com.example.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Testcontainers
@Slf4j
@ContextConfiguration(initializers = TestContainer.ContainerPropertyInitializer.class)
public class TestContainer {

    @Autowired Environment env;


    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();

    @BeforeAll
    static void beforeAll(){
        postgreSQLContainer.start();
        Slf4jLogConsumer logConsumer = new Slf4jLogConsumer(LOGGER);
        postgreSQLContainer.followOutput(logConsumer);

        System.out.println(env.getProperty("container.port"));
    }

    @AfterAll
    static void afterAll(){
        postgreSQLContainer.stop();
    }

    @Container
    static GenericContainer postgreSQLContainer = new GenericContainer("postgres")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB","studytest")
//            .waitingFor(Wait.forListeningPort());ㅁ

            .waitingFor(Wait.forHttp("/hello"));


    @Test
    void createNewStudy(){

    }

    static class ContainerPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("container.port=" + postgreSQLContainer.getMappedPort(5432))
                    .applyTo(context.getEnviroment());

        }
    }
}
