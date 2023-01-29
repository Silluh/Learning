package main.com.example012.v1;

public enum StringConstant {

    TABULATOR("\t"),
    NEW_LINE("\n");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
