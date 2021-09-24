@DodajDijagnozu
Feature: Funkcija dodaj dijagnozu

  Background: Ulogujem se i verifikujem dashboard stranicu
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then title na stranici treba da bude "Dashboard"
    When kliknem na "Dodaj dijagnozu" u sidebar

  Scenario: Uspesno dodata dijagnoza
    Then title na stranici treba da bude "Dodaj dijagnoza"
    When unesem "Sizofrenija" u naziv dijagnoza
    And unesem "F23" u unesi sifru dijagnoze
    And unesem "Pacijent sizi" u unesi opis
    Then kliknem na potvrdi unos dijagnoze
    And treba da vidim uspesno dodata dijagnoza

  Scenario: Neuspesno dodata dijagnoza (nepotpuna forma)
    Then title na stranici treba da bude "Dodaj dijagnoza"
    When unesem "Sizofrenija" u naziv dijagnoza
    And unesem "F24" u unesi sifru dijagnoze
    Then kliknem na potvrdi unos dijagnoze
    And treba da vidim Nije uspelo upisivanje dijagnoze









