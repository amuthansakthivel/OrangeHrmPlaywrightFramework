package com.tests;

import com.manager.PlaywrightManager;
import com.pages.HomePage;
import com.tests.base.ReusableLoginTestSetup;
import org.junit.jupiter.api.Test;

class ReuseLoginStateTest extends ReusableLoginTestSetup {

  @Test
  void testReusableBrowserContext() {
    new HomePage(PlaywrightManager.getPage())
        .clickPIMMenu()
        .verifyEmployeeInformationTextIsDisplayed();
  }
}