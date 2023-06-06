package com.sight.autolotto.common.autolotto;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class AutoLottoService {

  public void test() {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch();
      Page page = browser.newPage();
      page.navigate("http://playwright.dev");
      System.out.println(page.title());
    }
  }

  public void test2() {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page = browser.newPage();
      page.navigate("http://whatsmyuseragent.org/");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
    }
  }

  public void test3() {
    final String USER_ID = "";
    final String USER_PW = "";

    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page = browser.newPage();
      page.navigate("https://dhlottery.co.kr/user.do?method=login");

      page.click("[placeholder=\"아이디\"]");

      page.fill("[placeholder=\"아이디\"]", USER_ID);

      page.press("[placeholder=\"아이디\"]", "Tab");

      page.fill("[placeholder=\"비밀번호\"]", USER_PW);

      page.press("form[name=\"jform\"] >> text=로그인", "Enter");
      Thread.sleep(5000);
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
