package main.com.example015.radek.model;

public enum StringConstant {

    FIND("-"),
    FIND_2("XXX"),
    REPLACE("_"),
    REPLACE_2("AAA");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
