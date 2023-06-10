package com.sight.autolotto.common.autolotto;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.springframework.stereotype.Service;

@Service
public class AutoLottoService {

  public void purchaseLottoByAuto(int ticketCount) {
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

      page.navigate("https://ol.dhlottery.co.kr/olotto/game/game645.do");
      page.locator("#popupLayerAlert").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("확인"));

      page.click("text=자동번호발급");

      Thread.sleep(3000);

      page.selectOption("select", String.valueOf(ticketCount));

      page.click("text=확인");

      page.click("input:has-text(\"구매하기\")");

      Thread.sleep(3000);

      page.click("text=확인 취소 >> input[type=\"button\"]");
//      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

      page.click("input[name=\"closeLayer\"]");

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
