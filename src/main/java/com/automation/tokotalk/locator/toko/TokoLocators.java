package com.automation.tokotalk.locator.toko;

import org.openqa.selenium.By;

public interface TokoLocators {

  By BUTTON_RATING_TOKO = By.xpath("//a[contains(@href,'testimonials')]");
  By BUTTON_INFO_TOKO = By.xpath("//a[contains(@href,'info')]");
  By BUTTON_BLOG_TOKO = By.xpath("//a[contains(@href,'news')]");
  By BUTTON_BUTTON_SEARCH_PRODUK = By.xpath("//button[contains(@class,'app-bar__btn')][2]");
  By BUTTON_ORDER_PAGE = By.xpath("//a[contains(@href,'orders')]");
  By BUTTON_LIHAT_PRODUK_ADA_STOK = By.xpath("//div[contains(text(),'Ada Stok')]");
  By BUTTON_BERI_TAHU_SAYA = By
      .xpath(
          "//span[contains(text(),'Beri tahu saya jika produk tersedia kembali')]/parent::button");
  By INPUT_JUMLAH_FOR_ALERT = By
      .xpath("//label[contains(text(),'Jumlah')]/following-sibling::input");
  By INPUT_EMAIL_FOR_ALERT = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
  By BUTTON_KONFIRMASI_FOR_ALERT = By.xpath("//span[contains(text(),'Konfirmasi')]");
  By BUTTON_LIHAT_PRODUK_STOK_HABIS = By
      .xpath("//div[contains(text(),'Stok Habis')]/parent::div/parent::div/parent::div");
  By BUTTON_BELI_SEKARANG = By.xpath("//span[contains(text(),'Beli Sekarang')]");
  By BUTTON_KIRIM_PESAN = By.xpath("//span[contains(text(),'Kirim Pesan')]");
  By BUTTON_JUMLAH_STOK = By.xpath("//div[@class='v-card__text']//button[1]");
  By BUTTON_JUMLAH_STOK_LEBIH = By.xpath("//span[contains(text(),'+ Lebih')]");
  By INPUT_JUMLAH_STOK = By
      .xpath("//label[contains(text(),'Atau ketikkan jumlah (cth. 5)')]/following-sibling::input");
  By BUTTON_JUMLAH_OKE = By.xpath("//span[contains(text(),'Oke')]");
  By INPUT_PESAN = By.xpath("//label[contains(text(),'Ketik Pesan')]/following-sibling::input");
  By BUTTON_KIRIM = By.xpath(
      "//div[contains(text(),'Apa yang ingin kamu tanyakan soal produk ini?')]/following-sibling::div[@class='v-card__text']//button");
  By BUTTON_LIHAT_KERANJANG = By
      .xpath("//div[contains(text(),'Keranjang Saya')]/parent::div/parent::div//button");
  By BUTTON_ORDER_SEKARANG = By.xpath("//span[contains(text(),'Order Sekarang')]");
  By INPUT_NAMA_LENGKAP_PENERIMA = By
      .xpath("//label[text()='Nama Lengkap Penerima*']/following-sibling::input");
  By INPUT_NOMOR_HP_PENERIMA = By
      .xpath("//label[text()='Nomor HP Penerima*']/following-sibling::input");
  By BUTTON_ALAMAT_PENERIMA = By
      .xpath("//label[text()='Alamat Penerima*']/parent::div/parent::div");
  By BUTTON_PROVINSI = By.xpath("//div[contains(text(),'Bali')]");
  By BUTTON_KOTA = By.xpath("//div[contains(text(),'Kab. Badung')]");
  By BUTTON_KEC = By.xpath("//div[contains(text(),'Abiansemal')]");
  By BUTTON_PILIH_PENGIRIMAN = By.xpath("//span[contains(text(),'Pilih pengiriman')]");
  By INPUT_ALAMAT_LENGKAP_PENERIMA = By.xpath("//textarea");
  By BUTTON_PILIH_PEMBAYARAN = By.xpath("//span[contains(text(),'Pilih pembayaran')]");
  By BUTTON_OPSI_PAYMENT = By.xpath(
      "//div[contains(text(),'Transfer Bank')]/parent::div/following-sibling::div//div[@class='unicon v-icon v-icon']");
  By INPUT_CARI_PRODUK = By.xpath("//input[@id='product-search']");
  By LABEL_GAGAL_DISIMPAN = By.xpath("//div[contains(text(),'Gagal Disimpan')]");
  By LABEL_PENGINGAT_DISIMPAN = By.xpath("//div[contains(text(),'Pengingat disimpan')]");
  By LABEL_STATUS_ORDER = By.xpath("//div[contains(text(),'Status : Menunggu Pembayaran')]");
  By LABEL_JUMLAH_TIDAK_TERSEDIA = By
      .xpath("//div[contains(text(),'Jumlah ini tidak tersedia')]");
  By LABEL_LOGIN_DENGAN_NOMOR_HP = By.xpath("//div[contains(text(),'Login dengan Nomor HP')]");
  By LABEL_RATING_RATA_RATA = By.xpath("//div[contains(text(),'Rata-Rata')]");
  By LABEL_INFO_TOKO = By.xpath("//div[@class='pa-page']/div");
  By LABEL_BLOG_TOKO = By.xpath("//div[contains(text(),'Blog Toko')]");
  By LIST_SEARCH_PRODUK = By.xpath("//div[@class='v-card__text']//a//div[contains(@class,'font')]");
  By LABEL_ORDER_TAB = By.xpath("//a[contains(text(),'Order Saya')]");
}
