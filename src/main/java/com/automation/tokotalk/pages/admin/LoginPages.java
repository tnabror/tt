package com.automation.tokotalk.pages.admin;

import static com.automation.tokotalk.locator.admin.LoginLocators.BUTTON_MASUK;
import static com.automation.tokotalk.locator.admin.LoginLocators.BUTTON_TUTUP_BANNER;
import static com.automation.tokotalk.locator.admin.LoginLocators.INPUT_KATA_SANDI;
import static com.automation.tokotalk.locator.admin.LoginLocators.INPUT_NOMOR_TELEPON_ATAU_EMAIL;

import com.automation.tokotalk.base.WebPageObject;
import com.automation.tokotalk.properties.DataProperties;

public class LoginPages extends WebPageObject {

  DataProperties dataProperties = new DataProperties();

  public void openLoginPage() {
    openUrl(dataProperties.getData("admin.login.url"));
  }

  public void inputCredentialLogin(String teleponOrEmail, String password) {
    type(INPUT_NOMOR_TELEPON_ATAU_EMAIL, teleponOrEmail);
    type(INPUT_KATA_SANDI, password);
  }

  public void clikButtonMasuk() {
    click(BUTTON_MASUK);
    waitAbit(3);
  }

  public void clickTutupBanner() {
    click(BUTTON_TUTUP_BANNER);
  }

}
