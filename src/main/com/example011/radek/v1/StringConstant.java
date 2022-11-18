package main.com.example011.radek.v1;

public enum StringConstant {

    TABULATOR("\t"),
    EMPTY(" "),
    NEW_LINE("\n"),
    MINE("x"),
    EMPTY_SLOT("o");

    private final String Constant;

    StringConstant(String Constant) {
        this.Constant = Constant;
    }

    public String getConstant() {
        return this.Constant;
    }

}
