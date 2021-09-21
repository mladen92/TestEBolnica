@DodajAdresu
Feature: Funkcija dodaj adresu

  Background: Ulogujem se i verifikujem dashboard stranicu
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then title na stranici treba da bude "Dashboard"

    Scenario: Uspesno dodata adresa
      When kliknem na "Dodaj Adresu" u sidebar
      Then title na stranici treba da bude "Unos nove adrese"
      When unesem "Beograd" u unesi grad
      And unesem "Cvijiceva" u unesi ulicu
      And unesem "123" u unesi broj ulice
      And unesem "11000" u unesi postanski broj
      Then kliknem na potvrdi unos adrese
      And treba da vidim uspesno dodata adresa
      When kliknem na "Dodaj radnika" u sidebar
      And kliknem na izaberi adresu u Dodaj radnika
      Then verifikujemo da je poslednja adresa "Beograd, Cvijiceva, 123"







