package main.com.example012.daniel.domain;

public enum Lottery {

    SPORTKA("Sportka", 49, 6),
    STASTNYCH10("Štastných 10", 80, 10),
    EUROJACKPOT("Eurojackpot", 50, 5);

    final String name;
    final int maxNumber;
    final int maxGuessedNumbers;

    Lottery(String name, int maxNumber, int maxGuessedNumbers) {

        this.name = name;
        this.maxNumber = maxNumber;
        this.maxGuessedNumbers = maxGuessedNumbers;
    }

    public String getCompany() {

        return name;
    }

    public int getMaxNumber() {

        return maxNumber;
    }

    public int getMaxGuessedNumbers() {

        return maxGuessedNumbers;
    }
}
