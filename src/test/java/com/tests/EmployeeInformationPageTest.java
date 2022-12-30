package com.tests;

import com.entity.EmployeeDetails;
import com.entity.LoginDetails;
import com.pages.LoginPage;
import com.tests.testdata.EmployeeTestData;
import com.tests.testdata.LoginTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.nio.file.Path;
import java.nio.file.Paths;

@Execution(value = ExecutionMode.CONCURRENT)
class EmployeeInformationPageTest extends TestSetup {

  private final EmployeeDetails employeeDetails = EmployeeTestData.getRandomEmployeeDetails();
  private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();

  @Test
  void testWhetherEmployeeInformationIsDisplayed() {
    LoginPage.getInstance()
        .login(loginDetails)
        .clickPIMMenu()
        .verifyEmployeeInformationTextIsDisplayed();
  }

  @Test
  void testNewEmployeeCanBeCreated() {
    LoginPage.getInstance()
        .login(loginDetails)
        .clickPIMMenu()
        .navigateToAddEmployeePage()
        .addNewEmployee(employeeDetails)
        .verifyWhetherEmployeeCreatedSuccessfully();
  }
}