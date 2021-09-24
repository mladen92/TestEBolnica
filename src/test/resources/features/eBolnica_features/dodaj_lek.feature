@DodajLek
Feature: Funkcija dodaj lek

  Background: Ulogujem se i verifikujem dashboard stranicu
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then title na stranici treba da bude "Dashboard"
    When kliknem na "Dodaj Lek" u sidebar

  Scenario: Uspesno dodat lek
    Then title na stranici treba da bude "Dodaj lek"
    When unesem "Paracetamol" u naziv leka
    And unesem "500mg" u unesi jedinicu mere
    And unesem "1" u unesi kolicinu
    And unesem "Acetaminofen" u unesi supstancu
    And unesem "simpomatski" u unesi tip leka
    And unesem "tableta" u unesi oblik leka
    Then kliknem na potvrdi unos adrese
    And treba da vidim uspesno dodat lek

  Scenario: Neuspesno dodata adresa (nepotpuna forma)
    When unesem "Paracetamol" u naziv leka
    And unesem "500mg" u unesi jedinicu mere
    And unesem "1" u unesi kolicinu
    And unesem "Acetaminofen" u unesi supstancu
    And unesem "simpomatski" u unesi tip leka
    And unesem "tableta" u unesi oblik leka
    Then kliknem na potvrdi unos adrese
    And treba da vidim Nije uspelo upisivanje leka









