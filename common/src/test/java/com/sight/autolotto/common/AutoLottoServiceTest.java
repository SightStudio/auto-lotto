package com.sight.autolotto.common;

import com.sight.autolotto.common.autolotto.AutoLottoService;
import config.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoLottoServiceTest extends IntegrationTest {

  @Autowired
  AutoLottoService autoLottoService;

  @Test
  void test() {
    autoLottoService.test3();
  }
}
