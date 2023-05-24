package main.com.example012.v1.model;

public enum Lottery {

    SPORTKA("Sportka", 49, 6, 7),
    STASTNYCH10("Štastných 10", 80, 10, 11),
    EUROJACKPOT("Eurojackpot", 50, 5, 6);

    final String name;
    final int maxNumber;
    final int maxGuessedNumbers;
    final int maxCorrectPossibilities;

    Lottery(
            String name, int maxNumber, int maxGuessedNumbers, int maxCorrectPossibilities) {

        this.name = name;
        this.maxNumber = maxNumber;
        this.maxGuessedNumbers = maxGuessedNumbers;
        this.maxCorrectPossibilities = maxCorrectPossibilities;
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

    public int getMaxCorrectPossibilities() {
        return maxCorrectPossibilities;
    }
}
