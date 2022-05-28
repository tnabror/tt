@AdminFeatures @Web
Feature: Admin Features

  @Case1
  Scenario: User is able to login and can see the home page of tokotalk admin
    Given user is on tokotalk admin login page
    When user fill the email and password for the tokotalk admin user
    When user click button masuk
    Then user should be able to see the home page of tokotalk admin

  @Case2
  Scenario: User is able to access online shop when using lihat toko saya
    Given user is already login into admin tokotalk
    When user click button lihat toko saya
    When user click link on the cobalah tokomu
    Then user should be redirected to the online shop

  @Case3
  Scenario: user is able to add product with only mandatory field
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Semua Produk"
    When user click button tambahkan produk
    When user click button tambahkan produk secara manual
    When user tambahkan produk foto
    When user fill nama produk
    When user fill harga
    When user click button simpan
    Then user is able to see product added with correct value

  @Case4 @Negative
  Scenario: user is not able to save product when the price is not below than 1000,000,000
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Semua Produk"
    When user click button tambahkan produk
    When user click button tambahkan produk secara manual
    When user tambahkan produk foto
    When user fill nama produk
    When user fill harga with price "1000000000"
    When user click button simpan
    Then user see warning message "Harga harus di bawah Rp1.000.000.000"

  @Case5
  Scenario: user is able to create a category without a cover image
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Kategori"
    When user click button tambah kategori
    When user input category name
    When user click button simpan kategori
    Then user see category name successfully created

  @Case6
  Scenario: user is able to create a category with a cover image
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Kategori"
    When user click button tambah kategori
    When user input category name
    When user upload a cover image
    When user click button simpan kategori
    Then user see category name successfully created

  @Case7 @Negative
  Scenario: user isn't able to create a category with length of name more than 252
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Kategori"
    When user click button tambah kategori
    When user input category name length more than 252
    When user click button simpan kategori
    Then user see error message "Gagal Disimpan" on category

  @Case8
  Scenario: user is able to update stock in inventaris
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Inventaris"
    When user update stock of a product
    Then user see that the stock updated

  @Case9 @Negative
  Scenario: user is not able to update stock in inventaris with value more than max integer
    Given user is already login into admin tokotalk
    When user click menu "Produk"
    When user click menu "Inventaris"
    When user update stock of a product with value more than max integer
    Then user see error message "Gagal Disimpan" on inventaris

  @Case10
  Scenario: user can see popup message lihat premium when try to aplikasikan custom domain
    Given user is already login into admin tokotalk
    When user click menu "Toko Online"
    When user click menu "Domain & SEO"
    When user click cari domain
    When user input and search domain toko
    When user click button aplikasikan
    Then user should see popup message lihat premium


