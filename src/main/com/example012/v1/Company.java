package main.com.example012.v1;

public enum Company {

    SPORTKA("Sportka", 49, 6),
    STASTNYCH10("Štastných 10", 80, 10),
    EUROJACKPOT("Eurojackpot", 50, 5);


    final String company;
    final int maxNumber;
    final int maxGuessedNumbers;

    Company(String company, int maxNumber, int maxGuessedNumbers) {

        this.company = company;
        this.maxNumber = maxNumber;
        this.maxGuessedNumbers = maxGuessedNumbers;
    }

    public String getCompany() {

        return company;
    }

    public int getMaxNumber() {

        return maxNumber;
    }

    public int getMaxGuessedNumbers() {

        return maxGuessedNumbers;
    }
}
