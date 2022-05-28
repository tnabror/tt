package com.automation.tokotalk.steps.admin;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.automation.tokotalk.pages.admin.AdminPages;
import com.automation.tokotalk.pages.admin.LoginPages;
import com.automation.tokotalk.properties.DataProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AdminStepDefs {

  LoginPages loginPages = new LoginPages();
  AdminPages adminPages = new AdminPages();
  DataProperties dataProperties = new DataProperties();

  private String namaToko = "";
  private String namaProduk = "";
  private String hargaProduk = "";
  private String namaKategori = "";
  private String stock = "";

  @Given("user is on tokotalk admin login page")
  public void userIsOnTokotalkAdminLoginPage() {
    loginPages.openLoginPage();
  }

  @When("user fill the email and password for the tokotalk admin user")
  public void userFillTheEmailAndPasswordForTheTokotalkAdminUser() {
    loginPages.inputCredentialLogin(dataProperties.getData("admin.user.email"),
        dataProperties.getData("admin.user.password"));
  }

  @When("user click button masuk")
  public void userClickButtonMasuk() {
    loginPages.clikButtonMasuk();
  }

  @Then("user should be able to see the home page of tokotalk admin")
  public void userShouldBeAbleToSeeTheHomePageOfTokotalkAdmin() {
    assertThat("user is not in home page of tokotalk admin", loginPages.getDriver().getCurrentUrl(),
        equalTo("https://tokoadmin.tokotalk.com/"));
  }

  @Given("user is already login into admin tokotalk")
  public void userIsAlreadyLoginIntoAdminTokotalk() {
    loginPages.openLoginPage();
    loginPages.inputCredentialLogin(dataProperties.getData("admin.user.email"),
        dataProperties.getData("admin.user.password"));
    loginPages.clikButtonMasuk();
    try {
      loginPages.clickTutupBanner();
    } catch (Exception e) {
      System.out.println("banner not closed!");
    }
  }

  @When("user click button lihat toko saya")
  public void userClickButtonLihatTokoSaya() {
    adminPages.clikButtonLihatTokoSaya();
  }

  @Then("user should be redirected to the online shop")
  public void userShouldBeRedirectedToTheOnlineShop() {
    adminPages.switchTab();
    assertThat("user not in correct url online shoping", adminPages.getDriver().getCurrentUrl(),
        containsStringIgnoringCase("https://toko.ly/" + namaToko));
  }

  @When("user click link on the cobalah tokomu")
  public void userClickLinkOnTheCobalahTokomu() {
    String linkToko = adminPages.clickLinkCobalahTokomu();
    namaToko = linkToko.split("/")[1];
  }

  @When("user click menu {string}")
  public void userClickMenu(String menu) {
    adminPages.clickMenu(menu);
  }

  @When("user click button tambahkan produk")
  public void userClickButtonTambahkanProduk() {
    adminPages.clickButtonTambahkanProduk();
  }

  @When("user click button tambahkan produk secara manual")
  public void userClickButtonTambahkanProdukSecaraManual() {
    adminPages.clickButtonTambahkanProdukSecaraManual();
  }

  @When("user tambahkan produk foto")
  public void userTambahkanProdukFoto() {
    adminPages.clickTambahkanbProdukFoto();
    adminPages.uploadFotoProduk();
  }

  @When("user fill nama produk")
  public void userFillNamaProduk() {
    namaProduk = "Produk Baju " + RandomStringUtils.randomNumeric(4);
    adminPages.inputNameProduk(namaProduk);
  }

  @When("user fill harga")
  public void userFillHarga() {
    hargaProduk = RandomStringUtils.randomNumeric(5);
    adminPages.inputHarga(hargaProduk);
  }

  @When("user click button simpan")
  public void userClickButtonSimpan() {
    adminPages.clickButtonSimpanProduk();
  }

  @Then("user is able to see product added with correct value")
  public void userIsAbleToSeeProductAddedWithCorrectValue() {
    assertThat("nama produk not inserted correctly", adminPages.checkData(namaProduk),
        equalTo(true));
  }

  @When("user fill harga with price {string}")
  public void userFillHargaWithPrice(String harga) {
    hargaProduk = harga;
    adminPages.inputHarga(hargaProduk);
  }

  @Then("user see warning message {string}")
  public void userSeeWarningMessage(String message) {
    assertThat("the input price is not correct",
        adminPages.getErrorMessage(), equalTo(message));
  }

  @When("user input category name")
  public void userInputCategoryName() {
    namaKategori = "Cat " + RandomStringUtils.randomNumeric(3);
    adminPages.inputNamaKategori(namaKategori);
  }

  @When("user click button simpan kategori")
  public void userClickButtonSimpanKategori() {
    adminPages.clickButtonSimpanKategori();
  }

  @Then("user see category name successfully created")
  public void userSeeCategoryNameSuccessfullyCreated() {
    assertThat("category name is not correct", adminPages.checkData(namaProduk),
        equalTo(true));
  }

  @When("user click button tambah kategori")
  public void userClickButtonTambahKategori() {
    adminPages.clickButtonTambahKategori();
  }

  @When("user upload a cover image")
  public void userUploadACoverImage() {
    adminPages.uploadGambarSampul();
  }

  @When("user input category name length more than {int}")
  public void userInputCategoryNameLengthMoreThan(int length) {
    namaKategori = "Cat " + RandomStringUtils.randomNumeric(length + 100);
    adminPages.inputNamaKategori(namaKategori);
  }

  @Then("user see error message {string} on category")
  public void userSeeErrorMessage(String errorMessage) {
    adminPages.clickButtonSimpanKategori();
    assertThat("error message not displayed", adminPages.getErrorGagalSimpan(),
        equalTo(errorMessage));
  }

  @When("user update stock of a product")
  public void userUpdateStockOfAProduct() {
    stock = "1" + RandomStringUtils.randomNumeric(4);
    WebElement element = adminPages.find(By.xpath("//tbody/tr/td[6]//input"));
    element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    element.sendKeys(stock);

    adminPages.find(By.xpath("//tbody/tr/td[6]//span[contains(text(),'Simpan')]")).click();
    adminPages.waitAbit(1);
  }

  @Then("user see that the stock updated")
  public void userSeeThatTheStockUpdated() {
    String activeStock = adminPages.find(By.xpath("//tbody/tr/td[5]/div/div")).getText();
    assertThat("stock not updated", activeStock, equalTo(stock));
  }

  @When("user update stock of a product with value more than max integer")
  public void userUpdateStockOfAProductWithValueMoreThanMaxInteger() {
    stock = "2147483648";
    WebElement element = adminPages.find(By.xpath("//tbody/tr/td[6]//input"));
    element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    element.sendKeys(stock);

    adminPages.find(By.xpath("//tbody/tr/td[6]//span[contains(text(),'Simpan')]")).click();
    adminPages.waitAbit(1);
  }

  @Then("user see error message {string} on inventaris")
  public void userSeeErrorMessageOnInventaris(String errorMessage) {
    adminPages.find(By.xpath("//tbody/tr/td[6]//span[contains(text(),'Simpan')]")).click();
    assertThat("error message not displayed", adminPages.getErrorGagalSimpan(),
        equalTo(errorMessage));
  }

  @When("user click cari domain")
  public void userClickCariDomain() {
    adminPages.clickCariDomainSaya();
  }

  @When("user input and search domain toko")
  public void userInputAndSearchDomainToko() {
    adminPages.inputDomainToko("domain" + RandomStringUtils.randomAlphabetic(3));
    adminPages.clickButtonCari();
  }

  @When("user click button aplikasikan")
  public void userClickButtonAplikasikan() {
    adminPages.clickButtonAplikasikan();
  }

  @Then("user should see popup message lihat premium")
  public void userShouldSeePopupMessageLihatPremium() {
    assertThat("popup not displayed", adminPages.getPopUpLihatPremiumText(),
        containsString("Kamu harus berlangganan Paket Premium untuk menggunakan fitur ini."));
  }
}