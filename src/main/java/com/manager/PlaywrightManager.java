package com.manager;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static java.util.Objects.isNull;

public final class PlaywrightManager {

  private PlaywrightManager() {
  }

  private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = ThreadLocal.withInitial(Playwright::create);
  private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
  private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();

  static Playwright getPlaywrightInstance() {
    return PLAYWRIGHT_THREAD_LOCAL.get();
  }

  public static BrowserContext getBrowserContext() {
    return BROWSER_CONTEXT_THREAD_LOCAL.get();
  }

  static void setBrowserContext(BrowserContext browserContext) {
    BROWSER_CONTEXT_THREAD_LOCAL.set(browserContext);
  }

  public static Page getPage() {
    if (isNull(PAGE_THREAD_LOCAL.get())) {
      setPage();
    }
    return PAGE_THREAD_LOCAL.get();
  }

  static void setPage() {
    PAGE_THREAD_LOCAL.set(getBrowserContext().newPage());
  }

  public static void cleanUp() {
    BROWSER_CONTEXT_THREAD_LOCAL.get().close();
    PLAYWRIGHT_THREAD_LOCAL.get().close();
    BROWSER_CONTEXT_THREAD_LOCAL.remove();
    PAGE_THREAD_LOCAL.remove();
    PLAYWRIGHT_THREAD_LOCAL.remove();
  }
}