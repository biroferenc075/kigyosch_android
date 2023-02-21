# Snake Game for Android
originally made in 2022
(Remake of my previous snake game in C)
# Házi feladat specifikáció

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

![image](https://user-images.githubusercontent.com/100433458/220399125-4d9059bd-0f44-401c-a576-14f4f3db63d2.png)
![image](https://user-images.githubusercontent.com/100433458/220399187-a39765d2-569b-4eab-abf0-b42057dff3b8.png)
![image](https://user-images.githubusercontent.com/100433458/220399218-b422e6c8-ee8a-4467-8999-d3b90a6754d3.png)
![image](https://user-images.githubusercontent.com/100433458/220399412-c65c0650-7c7d-4d78-91f5-cc477dbdaf92.png)
