package org.epam.testng_definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest
@CucumberContextConfiguration
public class BasicDefinitions extends AbstractTestNGSpringContextTests {

}
