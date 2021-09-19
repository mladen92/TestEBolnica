@Login
Feature: Login funkcija u eBolnica aplikaciji

  Scenario Outline: Uspešna prijava i odjava korisnika sa 3 različita statusa
    When se ulogujem u eBolnica sa korisnickim imenom "<Korisnicko ime>" i lozinkom "<Lozinka>"
    Then title na stranici treba da bude "Dashboard"
    And prijavljen korisnik treba da bude "<Ime i Prezime>"
    When kliknem na Odjava
    Then treba da vidim Korisnicko Ime


    Examples:
      | Korisnicko ime | Lozinka                  | Ime i Prezime   |
      | admin          | 4PoXG5Pg7Mc=             | Marko Lazarevic |
      | milos          | hb6VWwzzsUc=             | Mirko Miskovic  |
      | nikolina       | AKEzyE1XMRfnS1lrDxI67A== | Nikola Nikolic  |


  Scenario: Neuspešna prijava sa pogresšnim kredencijalima
    When se ulogujem u eBolnica sa pogresnim korisnickim imenom "admin" i lozinkom "lozinka"
    Then treba da vidim Pogresni Kredencijali
    When se ulogujem u eBolnica sa pogresnim korisnickim imenom "lozinka" i lozinkom "admin"
    Then treba da vidim Pogresni Kredencijali

