@DodajRadnik
Feature: Funkcija dodaj radnika

  Background: Ulogujem se i verifikujem dashboard stranicu
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then title na stranici treba da bude "Dashboard"
    When kliknem na "Dodaj radnika" u sidebar

  Scenario: Uspesno dodat radnik
    Then title na stranici treba da bude "Dodaj radnika"
    When unesem "Petar" u unesite ime radnika
    And unesem "Peric" u unesite prezime radnika
    And izaberem "Beograd, Vojvode Stepe, 320" iz izaberite adresu radnika
    And izaberem "Intenzivna nega" iz izaberite odeljenje
    And unesem "Kardiologija" u unesite specijalizaciju
    And unesem "09/27/2021" u kalendar radnika
    And unesem "pera123" u unesite korisnicko ime
    And unesem "pericP!123" u unesite lozinku
    And izaberem "Lekar" iz izaberite status
    Then kliknem na potvrdi unos radnika
    And treba da vidim uspesno dodat radnik
    When kliknem na "Radnici" u sidebar
    Then verifikujemo da je poslednji radnik "Petar, Peric, Kardiologija, lekar, 2021-09-27, Intenzivna nega"


  Scenario: Neuspesno dodat radnik
    Then title na stranici treba da bude "Dodaj radnika"
    And unesem "Peric" u unesite prezime radnika
    And izaberem "Beograd, Vojvode Stepe, 320" iz izaberite adresu radnika
    And izaberem "Intenzivna nega" iz izaberite odeljenje
    And unesem "Kardiologija" u unesite specijalizaciju
    And unesem "09/27/2021" u kalendar radnika
    And unesem "pera123" u unesite korisnicko ime
    And unesem "pericP!123" u unesite lozinku
    And izaberem "Lekar" iz izaberite status
    Then kliknem na potvrdi unos radnika
    And treba da vidim Niste Uneli sve podatke