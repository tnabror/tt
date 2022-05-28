@TokoFeatures @Web
Feature: Admin Features

  @Case11
  Scenario: user is able set alert email when the stok habis
    Given user is on toko online shop
    When user click on a produk that stok habis
    When user click button beri tahu saya jika produk tersedia kembali
    When user input jumlah
    When user input email
    When user click button konfirmasi
    Then user successfully set alert of a product

  @Case12 @Negative
  Scenario: user is not able set alert email when input jumlah with invalid format
    Given user is on toko online shop
    When user click on a product that have stok habis
    When user click button beri tahu saya jika produk tersedia kembali
    When user input jumlah with invalid format
    When user input email
    When user click button konfirmasi
    Then user see alert product "Gagal Disimpan"

  @Case13
  Scenario: user is able to create an order until pending payment
    Given user is on toko online shop
    When user click on a product that have ada stok
    When user click beli sekarang
    When user choose jumlah order
    When user click button cart
    When user click order sekarang
    When user input nama penerima
    When user input nomor hp penerima
    When user input alamat penerima
    When user input alamat lengkap penerima
    When user click pilih pengiriman
    When user click pilih pembarayan
    When user choose one of payment method
    When user click button order sekarang
    Then user successfully create an order with status menunggu pembayaran


  @Case14 @Negative
  Scenario: user see warning message when input jumlah more than inventaris stock
    Given user is on toko online shop
    When user click on a product that have ada stok
    When user click beli sekarang
    When user input jumlah order more that inventaris stock have
    Then user should see error message "Jumlah ini tidak tersedia. Mohon masukkan angka yang lebih rendah."

  @Case15
  Scenario: user guest can see popup message for login when try to send a chat
    Given user is on toko online shop
    When user click on a product that have stok habis
    When user click button kirim pesan
    When user input pesan
    When user click button kirim
    Then user see popup message "Login dengan Nomor HP" to send chat


  @Case16
  Scenario: user can see rating toko
    Given user is on toko online shop
    When user click button rating toko
    Then user can see rating toko page

  @Case17
  Scenario: user can see info toko
    Given user is on toko online shop
    When user click button info toko
    Then user can see info toko page

  @Case18
  Scenario: user can see blog toko
    Given user is on toko online shop
    When user click button blog toko
    Then user can see blog toko page

  @Case19
  Scenario: user is able to cari produk
    Given user is on toko online shop
    When user click on search button
    When user input a keyword on cari produk
    Then user should see list of products that match the keyword

  @Case20
  Scenario: user is able to see order page
    Given user is on toko online shop
    When user click button order page
    Then user can see order page


