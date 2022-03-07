Description
-----------------------
V1
--------------------------------------------------------------------------------------------
- kazda verze tady V1 bude mit svuj package ... example009.radek.v1.
- nasledujici verze bude vychazet z predchozi, je tedy zbytece ji delat dokud se nedokonci ta predchozi, plati pro vsechny priklady v budoucnu

Nakopiruj si zde predchozi kalkulacky. 
Kalkulacky budou obsahovat vnitrni atribut "result", do ktereho se bude ukladat prubezny vysledek. 
Hodnotu result nastavis v konstruktoru pri vytvoreni kalkulatoru.
Tzn. ze jednotlive operace nebudou nic vracet. 
Kalkucky budou navic obsahovat novou metodu getResult(), ktera vrati vysledek.


Takze v main budeme udelame toto
vytvoris kalulator
napr. init value 0

calculator.plus(5);
calculator.divide(5);
calculator.minus(4);

calculator.getResult() ... kterym si vytisknu -3 pokud to budes mit spravne.

V2 - example009.radek.v2.*
--------------------------------------------------------------------------------------------
Nastudovat praci s fily, streamy, kolekce, serializace.

Kalkulacka bude obsahovat novou metodu storeResult() ... kdykoliv ji zavolam, tak si ulozim prubezny vysledek.
- jak ukladani provedes necham na tobe
Dale bude obsahovat metodu getStoredResults() ... ktera bude ulozene hodnoty vracet. 
V metode main mi pak vracene hodnoty vytisknes. print(calculator.getStoredResults())

V3 - example009.radek.v3.*
--------------------------------------------------------------------------------------------
- nova funkcionalita kalkulacky ... metoda storeResultsIntoFile(nameOfFile); soubor bude ulozen ve slozce projektu ve slozce calculator-results 
- metoda ulozi prubezne vysledky - popremyslej v jakem formatu je ulozis - ruku mas volnou, ale slozite reseni nechci

- nova funkcionalita kalkulacky ... metoda loadResultsFromFile(nameOfFile); ... kdy nazev budes zadavat na konzoli, tak samo i pro ulozeni
- pokud soubor nebude existovat tak uzivatel bude pozadan, at zada nazev znovu nebo napise exit pro ukonceni programu

V4 - example009.radek.v4.*
--------------------------------------------------------------------------------------------
- upgraduj metodu storeResultsIntoFile ... kdy cestu pro ulozeni souboru budes vybirat pomoci dialogu, kde si cestu vyberes
- to same udelas pro nacitani filu

V5 - serializace / deserializace
--------------------------------------------------------------------------------------------
