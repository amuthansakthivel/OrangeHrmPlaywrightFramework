package com.tests.base;

import com.manager.BrowserManager;
import com.manager.NavigationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ReusableLoginTestSetup {

  @BeforeEach
  public void setUp() {
    BrowserManager.initBrowserWithExistingLoginState();
    NavigationManager.launchUrl();
  }

  @AfterEach
  public void tearDown() {
    BrowserManager.tearDown();
  }
}