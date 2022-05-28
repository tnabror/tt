package com.automation.tokotalk.locator.admin;

import org.openqa.selenium.By;

public interface AdminLocators {

  By BUTTON_LIHAT_TOKO_SAYA = By.xpath("//div[contains(text(),'Lihat Toko Saya')]");
  By LINK_TOKO = By.xpath("//div[contains(text(),'Cobalah tokomu')]/following-sibling::a");

  //Produk
  By BUTTON_TAMBAHKAN_PRODUK = By.xpath("//span[contains(text(),'Tambahkan produk')]");
  By BUTTON_TAMBAHKAN_PRODUK_SECARA_MANUAL = By
      .xpath("//span[contains(text(),'Tambahkan produk secara manual')]");
  By UPLOAD_GAMBAR_PRODUK = By.xpath("//input[@class='file-input']");
  By MENU_PRODUK = By.xpath("//div[contains(@class,'v-list-item')]/div[text()=' Produk ']");
  By MENU_SEMUA_PRODUK = By.xpath("//div[text()=' Semua produk ']");
  By MENU_KATEGORI = By.xpath("//div[text()=' Kategori ']");
  By BUTTON_TAMBAHKAN_PRODUK_FOTO = By.xpath("//span[contains(text(),'+ Tambahkan produk foto')]");
  By INPUT_NAMA_PRODUK = By.xpath("//div[@class='textfield product-name']/div//input");
  By INPUT_HARGA = By
      .xpath("//div[text()=' Harga']/following-sibling::div//input[contains(@placeholder,'Rp')]");
  By BUTTON_SIMPAN_PRODUK = By.xpath("//span[contains(text(),'Simpan')]");
  By LABEL_ERROR_MESSAGE = By.xpath("//div[@role='alert']//div");
  By BUTTON_SIMPAN_KATEGORI = By.xpath("//span[contains(text(),'Simpan')]");
  By INPUT_NAMA_KATEGORI = By.xpath("//input[@placeholder='Nama']");
  By BUTTON_TAMBAH_KATEGORI = By.xpath("//span[contains(text(),'Tambah Kategori')]");
  By UPLOAD_GAMBAR_SAMPUL = By.xpath("//input[@class='file-input']");
  By LABEL_ERROR_GAGAL_SIMPAN = By.xpath("//div[contains(text(),'Gagal Disimpan')]");
  By MENU_INVENTARIS = By.xpath("//div[text()=' Inventaris ']");
  By MENU_TOKO_ONLINE = By.xpath("//div[text()=' Toko online ']");
  By MENU_DOMAIN_AND_SEO = By.xpath("//div[text()=' Domain & SEO ']");
  By BUTTON_CARI_DOMAIN_SAYA = By.xpath("//span[contains(text(),'CARI DOMAIN SAYA')]");
  By INPUT_DOMAIN_TOKO = By.xpath("//input[@type='text']");
  By BUTTON_CARI = By.xpath("//span[contains(text(),'Cari')]");
  By BUTTON_APLIKASIKAN = By.xpath("//span[text()=' Aplikasikan ']");
  By POPUP_LIHAT_PREMIUM = By.xpath("//div[@class='v-card__title']/span");
}
