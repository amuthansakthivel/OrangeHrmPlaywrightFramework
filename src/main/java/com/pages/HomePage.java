package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {

  private final Page page;

  private static final String PIM = "text=PIM";
  private static final String EMPLOYEE_INFORMATION = "//h5";
  private static final String ADD_EMPLOYEE_BUTTON = "text='Add Employee'";

  public HomePage(Page page) {
    this.page = page;
  }

  public HomePage clickPIMMenu() {
    page.locator(PIM)
        .first()
        .click();
    return this;
  }

  public AddEmployeePage navigateToAddEmployeePage() {
    page.locator(ADD_EMPLOYEE_BUTTON).first().click(new Locator.ClickOptions().setForce(true));
    return new AddEmployeePage(page);
  }

  public void verifyEmployeeInformationTextIsDisplayed() {
    assertThat(page.locator(EMPLOYEE_INFORMATION))
        .containsText("Employee Information");
  }
}