package com.tests;

import com.entity.EmployeeDetails;
import com.entity.LoginDetails;
import com.pages.LoginPage;
import com.tests.base.TestSetup;
import com.tests.testdata.EmployeeTestData;
import com.tests.testdata.LoginTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(value = ExecutionMode.CONCURRENT)
class EmployeeInformationPageTest extends TestSetup {

  private final EmployeeDetails employeeDetails = EmployeeTestData.getRandomEmployeeDetails();
  private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();

  @Test
  void testWhetherEmployeeInformationIsDisplayed() {
    LoginPage.getInstance()
        .loginToApplication(loginDetails)
        .clickPIMMenu()
        .verifyEmployeeInformationTextIsDisplayed();
  }

  @Test
  void testNewEmployeeCanBeCreated() {
    LoginPage.getInstance()
        .loginToApplication(loginDetails)
        .clickPIMMenu()
        .navigateToAddEmployeePage()
        .addNewEmployee(employeeDetails)
        .verifyWhetherEmployeeCreatedSuccessfully();
  }
}