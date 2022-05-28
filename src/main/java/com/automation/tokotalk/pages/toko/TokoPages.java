package com.automation.tokotalk.pages.toko;

import com.automation.tokotalk.base.WebPageObject;
import com.automation.tokotalk.properties.DataProperties;

public class TokoPages extends WebPageObject {

  DataProperties dataProperties = new DataProperties();

  public void openPage() {
    openUrl(dataProperties.getData("toko.home.url"));
  }

}
