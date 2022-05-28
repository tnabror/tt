package com.automation.tokotalk.locator.admin;

import org.openqa.selenium.By;

public interface LoginLocators {

  By INPUT_NOMOR_TELEPON_ATAU_EMAIL = By
      .xpath("//div[contains(text(),'Nomor Telepon atau Email')]/following-sibling::div//input");
  By INPUT_KATA_SANDI = By
      .xpath("//div[contains(text(),' Kata sandi')]/following-sibling::div//input");
  By BUTTON_MASUK = By.xpath("//button/span[contains(text(),'Masuk')]");

  By BUTTON_TUTUP_BANNER = By.xpath("//button[text()='Tutup']");

}
