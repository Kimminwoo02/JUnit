package com.example.junit;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArcUnitTest {
    @Test
    public void Services_should_only_be_accessed_by_Controllers(){
        JavaClasses importedClass = new ClassFileImporter().importPackages("com.example.junit");

        ArchRule myRule = clases().that().residenInAPackage("..service..")
                .should().onlyBeAccessed().byAnyPackage("..controller..","..service..");

        myRule.check(importedClasses);
        
    }
}
