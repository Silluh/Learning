Description
-----------------------
V1
-----------------------
Nauka rozhraní. 

budeme mit interface BaseFighter s nasledujicimi metodami(vlastnostmi)
shooting()
defense()
running()
Kazda bude vracet int hodnotu.

Pak budeme mit tridu Soldier, ktery bude mit vlastnosti(shooting, defense, running) typu int a nastavene na 10.
Tato trida bude implementovat rozhrani 

V2 nezacinej dokud se nedokonci V1

V2
-----------------------
Udelejme mensi refaktor nebo uplne cele znova, dle toho, jestli to budes potrebovat.

Prejmenuj metodu shooting() na attack().

A mejme nasledujici classy, ktere budou implementovat nase rozhrani. 
Hodnoty vlastnosti jim nastav takoveto (shooting, defense, running)
Attacker (15, 5, 10)
Defender (5, 15, 10)
Runner (5, 5, 20)
Universal (Prejmenuj Soldiera na Universal) (10, 10, 10)
Vsechny tridy budou dedit z tridy Soldier, ktera bude mit propertu life a name, ktere se bude nastavovat pres konstruktor a bude mit getter a setter.

Vytv or classu Battle, ktera bude mit jeden attribut List ... tento list bude genericky a popremyslej, co tam bude, aby fungoval nasledujici pozadevek. Kdyz tak nastuduj polymorfismus. 
V classe battle bude jedna motoda battle(int rounds), ktera nahodne z listu vezme bojovnika a ten bojovnik zautoci na vsechny ostatni
- to znamena, ze od hodnoty shooting od utocnika odectes obranu napadneho a tento vysledek pak odectes od hodnoty life a to same udelas s druhym bojovnikem(uvazujme jen dva bojovniky, ale jde to napsat i univerzalne pro x bojovniku)
- po kazdem battlu vypis stav hodnoty life u fighterů   name: xxx    life: xxx a tyto dva radky budou oddeleny ---------------------------- ... uvazujeme ze budou bojovat zatim vzdy jen dva bojovnici 

v mainu vytvor 2 bojovniky, Attacker a Universal a ty pak vloz do battlu ... kdo myslis, ze vyhraje? 