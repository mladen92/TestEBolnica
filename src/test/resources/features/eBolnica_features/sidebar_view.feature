@Sidebar

Feature: Sidebar pogled za različite korisnike

  Scenario: Admin pogled na sidebar
    When se ulogujem u eBolnica sa korisnickim imenom "admin" i lozinkom "4PoXG5Pg7Mc="
    Then treba da vidim sledece stavke u sidebar
      | Dashboard       |
      | Pacijenti       |
      | Logovi          |
      | Dodaj radnika   |
      | Dodaj Adresu    |
      | Unos pacijenta  |
      | Statistika      |
      | Dodaj Lek       |
      | Dodaj dijagnozu |
      | Radnici         |

  Scenario Outline: Lekar i Tehničar pogled na sidebar
    When se ulogujem u eBolnica sa korisnickim imenom "<Korisnicko ime>" i lozinkom "<Lozinka>"
    Then treba da vidim sledece stavke u sidebar
      | Dashboard |
      | Pacijenti |
      | Lekovi    |
      | Dijagnoze |


    Examples:
      | Korisnicko ime | Lozinka                  |
      | milos          | hb6VWwzzsUc=             |
      | nikolina       | AKEzyE1XMRfnS1lrDxI67A== |

