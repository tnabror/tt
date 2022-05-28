package com.automation.tokotalk.pages.admin;

import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_APLIKASIKAN;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_CARI;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_CARI_DOMAIN_SAYA;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_LIHAT_TOKO_SAYA;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_SIMPAN_KATEGORI;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_SIMPAN_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_TAMBAHKAN_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_TAMBAHKAN_PRODUK_FOTO;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_TAMBAHKAN_PRODUK_SECARA_MANUAL;
import static com.automation.tokotalk.locator.admin.AdminLocators.BUTTON_TAMBAH_KATEGORI;
import static com.automation.tokotalk.locator.admin.AdminLocators.INPUT_DOMAIN_TOKO;
import static com.automation.tokotalk.locator.admin.AdminLocators.INPUT_HARGA;
import static com.automation.tokotalk.locator.admin.AdminLocators.INPUT_NAMA_KATEGORI;
import static com.automation.tokotalk.locator.admin.AdminLocators.INPUT_NAMA_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.LABEL_ERROR_GAGAL_SIMPAN;
import static com.automation.tokotalk.locator.admin.AdminLocators.LABEL_ERROR_MESSAGE;
import static com.automation.tokotalk.locator.admin.AdminLocators.LINK_TOKO;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_DOMAIN_AND_SEO;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_INVENTARIS;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_KATEGORI;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_SEMUA_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.MENU_TOKO_ONLINE;
import static com.automation.tokotalk.locator.admin.AdminLocators.POPUP_LIHAT_PREMIUM;
import static com.automation.tokotalk.locator.admin.AdminLocators.UPLOAD_GAMBAR_PRODUK;
import static com.automation.tokotalk.locator.admin.AdminLocators.UPLOAD_GAMBAR_SAMPUL;

import com.automation.tokotalk.base.WebPageObject;
import com.automation.tokotalk.properties.DataProperties;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AdminPages extends WebPageObject {

  DataProperties dataProperties = new DataProperties();

  public void openPage() {
    openUrl(dataProperties.getData("admin.home.url"));
  }

  public void clikButtonLihatTokoSaya() {
    click(BUTTON_LIHAT_TOKO_SAYA);
  }

  public String clickLinkCobalahTokomu() {
    click(LINK_TOKO);
    waitAbit(3);

    return getText(LINK_TOKO);
  }

  public void switchTab() {
    ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(tabs2.get(1));
  }

  public void clickMenu(String menuName) {
    switch (menuName) {
      case "Produk":
        click(MENU_PRODUK);
        break;
      case "Semua Produk":
        click(MENU_SEMUA_PRODUK);
        break;
      case "Kategori":
        click(MENU_KATEGORI);
        break;
      case "Inventaris":
        click(MENU_INVENTARIS);
        break;
      case "Toko Online":
        click(MENU_TOKO_ONLINE);
        break;
      case "Domain & SEO":
        click(MENU_DOMAIN_AND_SEO);
        break;
      default:
        try {
          throw new Exception();
        } catch (Exception e) {
          System.out.println("menu not found");
        }
    }
  }

  public void clickButtonTambahkanProduk() {
    click(BUTTON_TAMBAHKAN_PRODUK);
  }

  public void clickButtonTambahkanProdukSecaraManual() {
    click(BUTTON_TAMBAHKAN_PRODUK_SECARA_MANUAL);
  }

  public void clickTambahkanbProdukFoto() {
    click(BUTTON_TAMBAHKAN_PRODUK_FOTO);
  }

  public void uploadFotoProduk() {
    WebElement element = getDriver().findElement(UPLOAD_GAMBAR_PRODUK);
    String fileName = "baju" + RandomStringUtils.randomNumeric(1);
    waitAbit(1);
    element.sendKeys(
        System.getProperty("user.dir") + "/src/test/resources/image/" + fileName + ".jpeg");
    waitAbit(2);
  }

  public void inputNameProduk(String namaProduk) {
    type(INPUT_NAMA_PRODUK, namaProduk);
  }

  public void inputHarga(String harga) {
    type(INPUT_HARGA, harga);
  }

  public void clickButtonSimpanProduk() {
    click(BUTTON_SIMPAN_PRODUK);
    waitAbit(10);
  }

  public boolean checkData(String data) {
    List<WebElement> webElements = findAll(By.xpath("//td"));
    for (WebElement el : webElements) {
      if (el.getText().replaceAll("\\s", "").equals(data.replaceAll("\\s", ""))) {
        return true;
      }
    }
    return false;
  }

  public String getErrorMessage() {
    List<WebElement> webElements = findAll(LABEL_ERROR_MESSAGE);
    for (WebElement el : webElements) {
      if (el.isDisplayed()) {
        return el.getText();
      }
    }
    return null;
  }

  public void inputNamaKategori(String namaKategori) {
    type(INPUT_NAMA_KATEGORI, namaKategori);
  }

  public void clickButtonSimpanKategori() {
    click(BUTTON_SIMPAN_KATEGORI);
  }

  public void clickButtonTambahKategori() {
    click(BUTTON_TAMBAH_KATEGORI);
  }

  public void uploadGambarSampul() {
    String fileName = "baju" + RandomStringUtils.randomNumeric(1);
    getDriver().findElement(UPLOAD_GAMBAR_SAMPUL)
        .sendKeys(
            System.getProperty("user.dir") + "/src/test/resources/image/" + fileName + ".jpeg");
  }

  public String getErrorGagalSimpan() {
    return find(LABEL_ERROR_GAGAL_SIMPAN).getText();
  }

  public void clickCariDomainSaya() {
    click(BUTTON_CARI_DOMAIN_SAYA);
  }

  public void inputDomainToko(String domainToko) {
    find(INPUT_DOMAIN_TOKO).sendKeys(Keys.chord(Keys.COMMAND, "a"));
    find(INPUT_DOMAIN_TOKO).sendKeys(Keys.chord(Keys.BACK_SPACE));
    type(INPUT_DOMAIN_TOKO, domainToko);
  }

  public void clickButtonCari() {
    click(BUTTON_CARI);
    waitAbit(1);
  }

  public void clickButtonAplikasikan() {
    findAll(BUTTON_APLIKASIKAN).get(0).click();
    waitAbit(1);
  }

  public String getPopUpLihatPremiumText() {
    return find(POPUP_LIHAT_PREMIUM).getText();
  }
}
