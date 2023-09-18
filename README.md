# Product-Repository
Die Aufgabe bezieht sich auf die Aufgabe 'Product-Repository', die ihr zuletzt gemacht habt.
- Schritt 1: Füge in der von euch zuletzt gemachten Aufgabe eine Service Schicht hinzu.
- implementiert einen Endpunkt im ProductController, der ein Produkt erstellt.
- Erstelle ein DTO für den POST-Endpunkt, damit der Client keine Id für das neue Produkt mit angeben kann.
### Bonus Aufgabe CRUD
- implementiert einen Endpunkt im ProductController, der ein Produkt anhand seiner id zurückgibt.
- implementiert einen Endpunkt im ProductController, der ein Produkt anhand seiner id löscht.
- implementiert einen Endpunkt im ProductController, der ein Produkt anhand seiner id aktualisiert.
### Bonus Aufgabe Services
Nutze eine von Java zufalls generierte Id für neue Produkte.
- Erstelle eine IdService Klasse, mit ein Methode public String randomId() diese soll die Klasse UUID nutzen um eine zufällige Id zu generieren.
- Nutzte Dependency Injection im ProductService, um die IdService Klasse zu injecten und beim erstellen von neuen Produkten eine Id zu generieren.
### Bonus Aufgabe Query
Wenn nicht gestern schon bearbeitet, befolge die folgenden Schritte nacheinander:
- Schritt 1: Füge zu deinem getAllProducts-Endpunkt einen Query-Parameter price hinzu.
- Schritt 2: Filter anhand dieses Parameters alle Produkte die maximal diesen Preis haben. (Lade zuerst alle Products aus der Datenbank und nutze zum Filtern uns bekannte Java Methoden)
- Schritt 3: Schaue dir Generated Query Methods an und nutze diese um die Produkte direkt gefiltert aus der Datenbank zu laden query-methoden.(Nur Abschnitt 3 lesen)

# JUnit Test mit Mockito
- Erstelle Test für:
- - findAllProducts Methode,
- - findById Methode,
- - updateProduct Methode,
- - deleteProductMethode

### Aufgabe Id-Service Methode
- Erstelle eine IdService-Klasse, in der du eine Methode bereitstellst um eine zufällige Id zu generieren.
- Nutze diese Klasse im ProductService um die Id für ein neues Produkt zu erstellen. (Nutze Dependency Injection)
- Erstelle einen Unit-Test für die addProduct Methode aus dem ProductService, mocke dazu auch den IdService.

### Bonus
- Prüfe in jedem Unit-Test das auch nur einmal die Methode von deinem Mock aufgerufen wurde und auch sonst keine.

### Bonus Aufgabe Static Mocking
Erstelle einen Unit-Test für die Klasse IdService
- Recherchiere dazu wie du den statischen Methoden-Aufrufe UUID.randomUUID()mocken kannst.

### Bonus Aufgabe Datum/ArguementCaptor
- Erweiter deine Product Klasse um den Zeitpunkt der Erstellung.
- Nutze im ProductService die Methode addProduct, um den aktuellen Zeitpunk festzustellen und mit abzuspeichern.
- Passe deinen Unit-Test an und prüfe das der Erstellzeitpunkt nach dem 01.01.2020 und vor 21Uhr ist. Nutze dafür den ArgumentCaptor von Mockito Link: https://www.baeldung.com/mockito-argumentcaptor

### Bonus Aufgabe Random Product
- Erstelle im ProductService eine Methode public void setSeed(long seed)
- Erstelle eine Methode getRandomProduct im ProductService, die einen Seed nutzt um ein zufälliges Produkt zurück zu geben.
- Schreibe für diese Methode einen Unit-Test, setzte dazu den Seed auf einen festen Wert damit jedes mal das geiche Produkt ausgewählt wird.

### Bonus Aufgabe Ohne Mockito
- Schreibe alle deine Tests ohne Mockito.
