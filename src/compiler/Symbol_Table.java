package compiler;

import java.util.Hashtable;
import java.util.Map;

public class Symbol_Table {
    Map<String, SymbolTableItem> table;
    private int scopeNumber;
    private String name;

    public Symbol_Table(String name, int scopeNumber) {
        this.table = new Hashtable<String, SymbolTableItem>();
        this.name = name;
        this.scopeNumber = scopeNumber;
    }


    public void insert(String idefName, String attributes, int scopeNumber) throws FieldAlreadyExistsException, MethodAlreadyExistsException, UndefinedClassWxception, UndefinedFieldException {
        if (this.table.containsKey(idefName)) {
            if (this.table.get(idefName).getType().equals("method")) {
                throw new MethodAlreadyExistsException(idefName,scopeNumber);
            } else if (this.table.get(idefName).getType().equals("field")) {
                throw new FieldAlreadyExistsException(idefName,scopeNumber);
            }
        } else if (!this.table.containsKey(idefName)) {
//            if (this.table.get(idefName).getType().equals("class")) {
//                throw new UndefinedClassWxception(idefName,scopeNumber);
//            } else if (this.table.get(idefName).getType().equals("field")) {
//                throw new UndefinedFieldException(idefName,scopeNumber);
//            }
        }
        SymbolTableItem item = new SymbolTableItem(idefName, attributes, scopeNumber);
        this.table.put(idefName, item);
    }

    public String lookup(String idefName) {
        return this.table.get(idefName).toString();
    }

    public String printItems() {
        String itemsStr = "";
        if (!table.isEmpty()) {
            for (Map.Entry<String, SymbolTableItem> entry :
                    table.entrySet()) {
                itemsStr += "Key = " + entry.getKey() + " | Value = " + entry.getValue() + "\n";
            }
        }
        return itemsStr;
    }

    public int getSize() {
        return this.table.size();
    }

    public String toString() {
        return "------------- " + name + " : " + scopeNumber + " -------------\n" + printItems() + "-----------------------------------------\n";
    }

}
