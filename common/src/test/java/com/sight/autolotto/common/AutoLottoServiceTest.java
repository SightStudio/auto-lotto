package com.sight.autolotto.common;

import com.sight.autolotto.common.autolotto.AutoLottoService;
import config.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoLottoServiceTest extends IntegrationTest {

  @Autowired
  AutoLottoService sut;

  @Test
  void 로또_자동_구매_1000() {

    // given
    int 자동_게임_구매_수 = 1;

    // when
    sut.purchaseLottoByAuto(자동_게임_구매_수);
  }
}
