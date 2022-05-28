package com.automation.tokotalk.steps.toko;

import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_ALAMAT_PENERIMA;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_BELI_SEKARANG;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_BERI_TAHU_SAYA;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_BLOG_TOKO;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_BUTTON_SEARCH_PRODUK;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_INFO_TOKO;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_JUMLAH_OKE;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_JUMLAH_STOK;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_JUMLAH_STOK_LEBIH;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_KEC;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_KIRIM;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_KIRIM_PESAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_KONFIRMASI_FOR_ALERT;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_KOTA;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_LIHAT_KERANJANG;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_LIHAT_PRODUK_ADA_STOK;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_LIHAT_PRODUK_STOK_HABIS;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_OPSI_PAYMENT;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_ORDER_PAGE;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_ORDER_SEKARANG;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_PILIH_PEMBAYARAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_PILIH_PENGIRIMAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_PROVINSI;
import static com.automation.tokotalk.locator.toko.TokoLocators.BUTTON_RATING_TOKO;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_ALAMAT_LENGKAP_PENERIMA;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_CARI_PRODUK;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_EMAIL_FOR_ALERT;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_JUMLAH_FOR_ALERT;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_JUMLAH_STOK;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_NAMA_LENGKAP_PENERIMA;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_NOMOR_HP_PENERIMA;
import static com.automation.tokotalk.locator.toko.TokoLocators.INPUT_PESAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_BLOG_TOKO;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_GAGAL_DISIMPAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_INFO_TOKO;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_JUMLAH_TIDAK_TERSEDIA;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_LOGIN_DENGAN_NOMOR_HP;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_ORDER_TAB;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_PENGINGAT_DISIMPAN;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_RATING_RATA_RATA;
import static com.automation.tokotalk.locator.toko.TokoLocators.LABEL_STATUS_ORDER;
import static com.automation.tokotalk.locator.toko.TokoLocators.LIST_SEARCH_PRODUK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.automation.tokotalk.pages.toko.TokoPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.interactions.Actions;

public class TokoStepDefs {

  TokoPages tokoPages = new TokoPages();

  @Given("user is on toko online shop")
  public void userIsOnTokoOnlineShop() {
    tokoPages.openPage();
    tokoPages.waitAbit(3);
  }

  @When("user click on a produk that stok habis")
  public void userClickOnAProdukThatStokHabis() {
    tokoPages.click(BUTTON_LIHAT_PRODUK_STOK_HABIS);
  }

  @When("user click button beri tahu saya jika produk tersedia kembali")
  public void userClickButtonBeriTahuSayaJikaProdukTersediaKembali() {
    tokoPages.click(BUTTON_BERI_TAHU_SAYA);
  }

  @When("user input jumlah")
  public void userInputJumlah() {
    tokoPages.waitAbit(1);
    tokoPages.type(INPUT_JUMLAH_FOR_ALERT, "3");
  }

  @When("user input email")
  public void userInputEmail() {
    tokoPages.type(INPUT_EMAIL_FOR_ALERT, RandomStringUtils.randomAlphanumeric(5) + "@mail.com");
  }

  @When("user click button konfirmasi")
  public void userClickButtonKonfirmasi() {
    tokoPages.click(BUTTON_KONFIRMASI_FOR_ALERT);
  }

  @Then("user successfully set alert of a product")
  public void userSuccessfullySetAlertOfAProduct() {
    assertThat("reminder not successfully set",
        tokoPages.find(LABEL_PENGINGAT_DISIMPAN).isDisplayed(), equalTo(true));
  }

  @When("user click on a product that have stok habis")
  public void userClickOnAProductThatHaveStokHabis() {
    tokoPages.click(BUTTON_LIHAT_PRODUK_STOK_HABIS);
    tokoPages.waitAbit(2);
  }

  @When("user input jumlah with invalid format")
  public void userInputJumlahWithInvalidFormat() {
    tokoPages.waitAbit(1);
    tokoPages.type(INPUT_JUMLAH_FOR_ALERT, RandomStringUtils.randomAlphabetic(5));
  }

  @Then("user see alert product {string}")
  public void userSeeAlertProduct(String alert) {
    tokoPages.click(BUTTON_KONFIRMASI_FOR_ALERT);
    assertThat("alert not displayed", tokoPages.find(LABEL_GAGAL_DISIMPAN).isDisplayed(),
        equalTo(true));
    assertThat("alert not displayed", tokoPages.find(LABEL_GAGAL_DISIMPAN).getText(),
        equalTo(alert));
  }

  @When("user click on a product that have ada stok")
  public void userClickOnAProductThatHaveAdaStok() {
    tokoPages.click(BUTTON_LIHAT_PRODUK_ADA_STOK);
    tokoPages.waitAbit(2);
  }

  @When("user click beli sekarang")
  public void userClickBeliSekarang() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_BELI_SEKARANG);
  }

  @When("user choose jumlah order")
  public void userChooseJumlahOrder() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_JUMLAH_STOK);
  }

  @When("user click button cart")
  public void userClickButtonCart() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_LIHAT_KERANJANG);
  }

  @When("user click order sekarang")
  public void userClickOrderSekarang() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_ORDER_SEKARANG);
  }

  @When("user input nama penerima")
  public void userInputNamaPenerima() {
    tokoPages
        .type(INPUT_NAMA_LENGKAP_PENERIMA, "Penerima " + RandomStringUtils.randomAlphabetic(5));
  }

  @When("user input nomor hp penerima")
  public void userInputNomorHpPenerima() {
    tokoPages.type(INPUT_NOMOR_HP_PENERIMA, "0812" + RandomStringUtils.randomNumeric(8));
  }

  @When("user input alamat penerima")
  public void userInputAlamatPenerima() {
    Actions action = new Actions(tokoPages.getDriver());
    action.moveToElement(tokoPages.find(BUTTON_ALAMAT_PENERIMA)).click().build().perform();
    tokoPages.click(BUTTON_PROVINSI);
    tokoPages.click(BUTTON_KOTA);
    tokoPages.click(BUTTON_KEC);
    tokoPages.waitAbit(1);
  }

  @When("user input alamat lengkap penerima")
  public void userInputAlamatLengkapPenerima() {
    tokoPages.type(INPUT_ALAMAT_LENGKAP_PENERIMA,
        "Alamat Lengkap " + RandomStringUtils.randomAlphabetic(6));
  }

  @When("user click pilih pengiriman")
  public void userClickPilihPengiriman() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_PILIH_PENGIRIMAN);
  }

  @When("user click pilih pembarayan")
  public void userClickPilihPembarayan() {
    tokoPages.waitAbit(2);
    tokoPages.click(BUTTON_PILIH_PEMBAYARAN);
  }

  @When("user choose one of payment method")
  public void userChooseOneOfPaymentMethod() {
    tokoPages.findAll(BUTTON_OPSI_PAYMENT).get(1).click();
  }

  @When("user click button order sekarang")
  public void userClickButtonOrderSekarang() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_ORDER_SEKARANG);
  }

  @Then("user successfully create an order with status menunggu pembayaran")
  public void userSuccessfullyCreateAnOrderWithStatusMenungguPembayaran() {
    tokoPages.waitAbit(2);
    assertThat("status is not correct", tokoPages.find(LABEL_STATUS_ORDER).getText(),
        containsString("Menunggu Pembayaran"));
  }

  @When("user input jumlah order more that inventaris stock have")
  public void userInputJumlahOrderMoreThatInventarisStockHave() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_JUMLAH_STOK_LEBIH);
    tokoPages.type(INPUT_JUMLAH_STOK, RandomStringUtils.randomNumeric(10));
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_JUMLAH_OKE);
  }

  @Then("user should see error message {string}")
  public void userShouldSeeErrorMessage(String error) {
    tokoPages.click(BUTTON_JUMLAH_OKE);
    assertThat("alert not displayed", tokoPages.find(LABEL_JUMLAH_TIDAK_TERSEDIA).getText(),
        equalTo(error));
  }

  @When("user click button kirim pesan")
  public void userClickButtonKirimPesan() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_KIRIM_PESAN);
  }

  @When("user input pesan")
  public void userInputPesan() {
    tokoPages.waitAbit(1);
    tokoPages.type(INPUT_PESAN, "Hallo Apakah bisa ? ");
  }

  @When("user click button kirim")
  public void userClickButtonKirim() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_KIRIM);
  }

  @Then("user see popup message {string} to send chat")
  public void userSeePopupMessageToSendChat(String message) {
    tokoPages.waitAbit(1);
    assertThat("popup not displayed", tokoPages.find(LABEL_LOGIN_DENGAN_NOMOR_HP).isDisplayed(),
        equalTo(true));
  }

  @When("user click button rating toko")
  public void userClickButtonRatingToko() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_RATING_TOKO);
  }

  @Then("user can see rating toko page")
  public void userCanSeeRatingTokoPage() {
    tokoPages.waitAbit(1);
    assertThat("rating toko page not displayed",
        tokoPages.find(LABEL_RATING_RATA_RATA).isDisplayed(), equalTo(true));
  }

  @When("user click button info toko")
  public void userClickButtonInfoToko() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_INFO_TOKO);
  }

  @Then("user can see info toko page")
  public void userCanSeeInfoTokoPage() {
    tokoPages.waitAbit(1);
    assertThat("info toko page not displayed", tokoPages.find(LABEL_INFO_TOKO).isDisplayed(),
        equalTo(true));
  }

  @When("user click button blog toko")
  public void userClickButtonBlogToko() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_BLOG_TOKO);
  }

  @Then("user can see blog toko page")
  public void userCanSeeBlogTokoPage() {
    assertThat("blog toko page not displayed", tokoPages.find(LABEL_BLOG_TOKO).isDisplayed(),
        equalTo(true));
  }

  @When("user click on search button")
  public void userClickOnSearchButton() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_BUTTON_SEARCH_PRODUK);
  }

  @When("user input a keyword on cari produk")
  public void userInputAKeywordOnCariProduk() {
    tokoPages.waitAbit(1);
    tokoPages.type(INPUT_CARI_PRODUK, "Baju");
  }

  @Then("user should see list of products that match the keyword")
  public void userShouldSeeListOfProductsThatMatchTheKeyword() {
    tokoPages.waitAbit(1);
    assertThat("product not displayed", tokoPages.findAll(LIST_SEARCH_PRODUK).get(0).getText(),
        containsStringIgnoringCase("baju"));
  }

  @When("user click button order page")
  public void userClickButtonOrderPage() {
    tokoPages.waitAbit(1);
    tokoPages.click(BUTTON_ORDER_PAGE);
  }

  @Then("user can see order page")
  public void userCanSeeOrderPage() {
    assertThat("order page not displayed", tokoPages.find(LABEL_ORDER_TAB).isDisplayed(),
        equalTo(true));
  }
}
