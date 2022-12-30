package com.pages;

import com.entity.LoginDetails;
import com.manager.PlaywrightManager;
import com.microsoft.playwright.Page;

public class LoginPage {

  private final Page page;

  private static final String USERNAME = "input[name='username']";
  private static final String PASSWORD = "input[name='password']";
  private static final String LOGIN_BUTTON = "button[type='submit']";

  private LoginPage(Page page) {
    this.page = page;
  }

  public static LoginPage getInstance() {
    return new LoginPage(PlaywrightManager.getPage());
  }

  public HomePage loginToApplication(LoginDetails loginDetails) {
    page.locator(USERNAME).fill(loginDetails.getUserName());
    page.locator(PASSWORD).fill(loginDetails.getPassword());
    page.locator(LOGIN_BUTTON).click();
    return new HomePage(page);
  }
}