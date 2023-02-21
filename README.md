# Snake Game on Android

# Házi feladat specifikáció

Információk [itt](https://viauac00.github.io/laborok/hf)

## Mobil- és webes szoftverek
### 2022.10.17.
### Kigyosch
### Biró Ferenc - (HR4VCG)
### biroferenc075@edu.bme.hu 
### Laborvezető: Pintér Petra

## Bemutatás

Az alkalmazás a jól ismert Snake játékot valósítja meg, ahol a játékos egy kígyót irányít. 
A játék célja, hogy a kígyó minél több almát egyen, ezáltal minél hosszabbra nyúljon, miközben saját magát elkerülve életben maradjon. 
Mivel a játék alapvetően egyszerű, könnyű előzetes ismeretek hiányában beleugrani, így azok is örömöt találhatnak benne, akik esetleg nem jártasak a mobileszközök világában.
Akik viszont kihívásra vágynak, ők is meg megtalálhatják azt, minél magasabb pontszámok és személyes rekordok elérésével.

## Főbb funkciók

Az alkalmazás indulásakor a kezdőképernyő jelenik meg, ahol új játékot lehet indítani, illetve a toplistát megnézni.
A játékos a kígyót a képernyőn megjelenő iránygombokkal tudja irányítani, ami folyamatosan mozog a legutoljára megnyomott gomb irányába.
A pályán megtalálható egy alma, amit ha a kígyó "megesz", azaz a feje és az alma azonos mezőn van, akkor a kígyó egyel hosszabb lesz, és az alma új, véletlenszerű helyre kerül a pályán.
Ha a kígyó önmagának ütközik, vége a játéknak. Ha "kimegy a képernyőről", akkor az ellenkező oldalon jelenik meg a kígyó feje, és ott folytatja a mozgását.
Játék közben a képernyőn látszik az eddig megevett almák száma, ami a pontszámnak felel meg, és a játék kezdete óta eltelt idő.
Ha a játéknak vége, akkor egy képernyő jelenik meg, ahol a felhasználó választhat, hogy elmenti rekordját a toplistára a saját nevével (amit ez esetben be kell gépelnie), megtekinti a toplistát, új játékot kezd, vagy visszalép a főmenübe.
A toplistán az előzőleg felvitt rekordok szerepelnek, ami egy név-pontszám-idő hármasból áll. Ezek pontszám alapján rendezve jelennek meg, ha két rekordnak azonos a pontszáma, akkor a rövidebb idejű kerül előrébb.  

## Választott technológiák:

- (UI)
- (Animációk)
- (RecyclerView)
- (Perzisztens adattárolás)
