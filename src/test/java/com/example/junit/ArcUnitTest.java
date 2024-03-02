package com.example.junit;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

//@SpringBootTest
@AnalyzeClasses(packagesOf = App.class)
public class ArcUnitTest {

    @ArchTest
    ArchRule myRule = clases().that().residenInAPackage("..service..")
            .should().onlyBeAccessed().byClassesThat()
            .resideInAnyPackage("..study..","..member..","..domain..");
        domainPackageRule.check(classes);

    @ArchTest
    ArchRule myRule = noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..member.."); // 도메인 안의 어떤 클래스도
    // 멤버 패키지 안에 있는 클래스에 접근할 수 없다.


        memberPackageRule.check(classes);
    @ArchTest
    ArchRule myRule = noClasses().that().resideOutsideOfPackage("..study..")
            .should().accessClassesThat().resideInAPackage("..study.."); // 도메인 안의 어떤 클래스도
    // 멤버 패키지 안에 있는 클래스에 접근할 수 없다.

        studyPackageRule.check(classes);


    @ArchTest
    // 순환참조를 없애는 코드
    ArchRule freeOfCycles = slices().matching("..junit.(*)..").should()/beFreeOfCycles();
        freeOfCycles.check(classes);



}
