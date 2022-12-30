package com.pages;

import com.entity.EmployeeDetails;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddEmployeePage {

  private final Page page;

  public AddEmployeePage(Page page) {
    this.page = page;
  }

  private static final String FIRST_NAME = "input[name='firstName']";
  private static final String MIDDLE_NAME = "input[name='middleName']";
  private static final String LAST_NAME = "input[name='lastName']";
  private static final String UPLOAD_FILE = "input[type='file']";
  private static final String EMPLOYEE_ID = "//label[text()='Employee Id']/following::input";
  private static final String SAVE_BUTTON = "//button[@type='submit']";
  private static final String SUCCESS_MESSAGE = "text='Success'";

  public AddEmployeePage addNewEmployee(EmployeeDetails employeeDetails) {
    page.locator(FIRST_NAME).fill(employeeDetails.getFirstName(), new Locator.FillOptions().setForce(true));
    page.locator(LAST_NAME).fill(employeeDetails.getLastName());
    page.locator(MIDDLE_NAME).fill(employeeDetails.getMiddleName());
    page.fill(EMPLOYEE_ID, String.valueOf(employeeDetails.getEmployeeId()));
    page.setInputFiles(UPLOAD_FILE, Paths.get(System.getProperty("user.dir") + employeeDetails.getProfilePicturePath()));
    page.locator(SAVE_BUTTON).click();
    return this;
  }

  public void verifyWhetherEmployeeCreatedSuccessfully() {
    assertThat(page.locator(SUCCESS_MESSAGE)).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10_000));
  }
}