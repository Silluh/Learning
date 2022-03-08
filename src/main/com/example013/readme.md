Description
-----------------------
V1
-----------------------
Napiseme hru slosovaci hry. 

Zadani:
Vytvor enum Company, kde kazda Company bude mit hodnoty
- oficialni nazev
- pocet cisel z kterych se losuje
- pocet cisel ktere je potreba uhodnout pro maximalni vyhru
- pouzij hodnoty z her SAZKA, STASTNYCH 10 a jestli jeste nejakou znas, tak tam dej treti

Vytvor nejakou clasu Game, ktera bude provede slosovani a vyhodnoti vsechny tikety, ktere ji posles. 
Slosovani se bude zakladat na hodnotach v enumech a pro vsechny bude system stejny.
Vyhodnoceni bych si predstavoval tak, ze bude mit nasledujici format:

Hra: napr. Sazka
Vylosovana cisla: ... (tabulator pro odsazeni cisel)
Pocet prijatych tiketu: 
Pocet tiketu s max uhodnutymi cisly:
Pocet tiketu s max-1 uhodnutymi cisly:
Pocet tiketu s max-2 uhodnutymi cisly: 
atd ... 
Tiket bude samostatny objekt a vlastnosti bude mit seznam cisel, unikatni kod, cim je budes rozlisovat.

Pro generovani tiketu vytvor classu, kde v mainu hodis typ hry a pocet tiketu kolik chces vygenerovat.

Tech class muzes vytvorit libovolne kolik chces, nemusis se drzet zadani. Jde o to, at to je co nejcistsi, citelne, prehledne, jednoduche...

V2
-----------------------
Vytvor si novy package, kde nakopirujes vse, co budes potrebovat z V1.

Napis classu GameTest, ktera bude prijmat parametr Company,
provede slosovani, opet klidne vyuzij predchozich trid, at to logicky je spravne. 
Po slosovani generuj tikety a zjisti, kolik potrebujes koupit tiketu, abys vyhral prvni cenu. 
Pokud to nebude dlouho trvat, zjisti kolik prumerne potrebujes tiketu pro 100 vyher prvnich cen.
Ve vypisu pak staci jen Vylosovana cisla a poradi tiketu, ktery byl vitezny. 
Tzn. kupujes tolik tiketu, dokud nevyhrajes. 

V3
-----------------------
Cilem bude vygenerovat text. soubor, kde se provede slosovani. 
Takze v souborou budou vylosovana cisla a pak budes generovat tikety a bude to vypada takhle

Ticket GHDNF6456D56
Vsazena cisla
Pocet uhodnutych cisel
Poradi koupeneho tiketu

Posledni zaznam bude vitezny tiket, takze v souboru muze byt jeden tiket nebo milion. 