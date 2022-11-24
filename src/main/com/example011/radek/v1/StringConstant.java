package main.com.example011.radek.v1;

public enum StringConstant {

    TABULATOR("\t"),
    EMPTY(" "),
    NEW_LINE("\n"),
    MINE("x"),
    EMPTY_SLOT("o");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
