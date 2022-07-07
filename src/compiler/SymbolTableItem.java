package compiler;

public class SymbolTableItem {

    private String type;
    //    private ArrayList<String> parameters;
    private String name;
    private String class_name;
    private String key;
    private String returnType;
    private int scopeNumber;

    public SymbolTableItem(String name, String attributes, int scopeNumber) {

    }

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
