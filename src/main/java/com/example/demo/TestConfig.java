package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;

@SpringBootTest
@Listeners(TestResultListener.class)
public abstract class TestConfig extends AbstractTestNGSpringContextTests {
}
