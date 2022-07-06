package compiler;

public class SymbolTableItem {

    private String type;
//    private ArrayList<String> parameters;
    private String name;
    private String class_name;
    private String key;
    private String returnType;

    public SymbolTableItem(String name, String attributes) {

    }

    public void setKey(String str) {
        String newStr = "";
        if (str.contains("import")) {
            newStr = str.replace(' ', '_');

        } else if (str.contains("class")) {
            String[] splitted = str.split(" ");
            newStr = "class_" + splitted[1];
        } else if (str.split(" ").length == 2) {
            String[] splitted = str.split(" ");
            newStr = "Field_" + splitted[1];
        } else if (str.split(" ").length == 2 && str.split(" ")[1].equals(this.class_name)) {
            String[] splitted = str.split(" ");
            newStr = "constructor_" + splitted[1];
        }
        this.key = newStr;
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
