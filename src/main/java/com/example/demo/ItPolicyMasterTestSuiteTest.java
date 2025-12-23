package com.example.demo;

import com.example.demo.service.DeviceProfileService;
import com.example.demo.service.UserAccountService;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItPolicyMasterTestSuiteTest extends TestConfig {

    @Autowired
    private DeviceProfileService deviceProfileService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private PolicyRuleService policyRuleService;

    @Autowired
    private ViolationRecordService violationRecordService;

    @BeforeClass
    public void setup() {
        System.out.println("Setting up Policy Master Test Suite...");
    }

    @Test
    public void deviceProfileServiceShouldBeLoaded() {
        assert deviceProfileService != null;
    }

    @Test
    public void userAccountServiceShouldBeLoaded() {
        assert userAccountService != null;
    }

    @Test
    public void policyRuleServiceShouldBeLoaded() {
        assert policyRuleService != null;
    }

    @Test
    public void violationRecordServiceShouldBeLoaded() {
        assert violationRecordService != null;
    }
}
