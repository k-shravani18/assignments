package com.trail;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.shristi.training.Calculator;
import com.testcases.studentapp.trail.UserTest;

@RunWith(JUnitPlatform.class)
//@SelectPackages({"com.testcases.calcapp","com.testcases.studentapp"})
@SelectPackages({"com.testcases.studentapp"})
@IncludePackages({"com.testcases.studentapp.trail"})
//@ExcludePackages({"com.testcases.studentapp.trail"})
//@SelectClasses({UserTest.class,Calculator.class})
public class AllTests {

}
