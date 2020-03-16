package com.thoughtworks.parkinglot.architecture;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

/**
 * @author gitqh
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.thoughtworks.parkinglot")
public class HexagonalArchitectureTest {


    @ArchTest
    static final ArchRule hexagonal_architecture_is_respected = onionArchitecture()
            .domainModels("..domain.model..")
            .applicationServices("..application..")
            .adapter("api", "..adapter.api..")
            .adapter("repository", "..adapter.repository..")
            .withOptionalLayers(true);

}
