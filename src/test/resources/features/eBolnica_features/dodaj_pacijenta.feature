@DodajPacijenta
Feature: Funkcija dodaj Pacijenta

  Background: Ulogujem se i verifikujem dashboard stranicu
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then title na stranici treba da bude "Dashboard"
    When kliknem na "Unos pacijenta" u sidebar

  Scenario: Uspesno dodat pacijent
    Then title na stranici treba da bude "Dodaj pacijenta"
    When unesem "Milovan" u unesite ime pacijenta
    And unesem "Miric" u unesite prezime pacijenta
    And izaberem "M" iz izaberite pol
    And unesem "112233445667" u unesite jmbg
    And unesem "LBO" u unesite lbo
    And unesem "06311122233" u unesite broj telefona
    And izaberem "Beograd, Beogradska, 21" iz izaberite adresu pacijenta
    And izaberem "Da" iz da li je pacijent vakcinisan
    And unesem "Polen" u unesite alergije
    And izaberem "AB+" iz izaberite krvnu grupu
    And izaberem "POZITIVAN" iz opcije covid testa
    Then kliknem na potvrdi unos pacijenta
    And treba da vidim uspesno dodat Pacijent
    When kliknem na "Pacijenti" u sidebar
    Then verifikujemo da je poslednji pacijent "Milovan, Miric, 112233445667"


  Scenario: Neuspesno dodat pacijent
    Then title na stranici treba da bude "Dodaj pacijenta"
    When unesem "Milovan" u unesite ime pacijenta
    And unesem "Miric" u unesite prezime pacijenta
    And izaberem "M" iz izaberite pol
    And unesem "112233445667" u unesite jmbg
    And unesem "LBO" u unesite lbo
    And unesem "06311122233" u unesite broj telefona
    And izaberem "Beograd, Beogradska, 21" iz izaberite adresu pacijenta
    And izaberem "Da" iz da li je pacijent vakcinisan
    And unesem "Polen" u unesite alergije
    And izaberem "AB+" iz izaberite krvnu grupu
    Then kliknem na potvrdi unos pacijenta
    And treba da vidim Niste Uneli sve podatke

