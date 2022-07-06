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


    public void insert(String idefName, String attributes) throws ItemAlreadyExistsException, FieldAlreadyExistsException {
        if (this.table.containsKey(idefName)) {
            if (this.table.get(idefName).getType().equals("method")) {
                throw new ItemAlreadyExistsException();
            } else if (this.table.get(idefName).getType().equals("field")) {
                throw new FieldAlreadyExistsException();
            }
        } else if (!this.table.containsKey(idefName)) {
//            if (this.table.get(idefName).getType().equals("method")) {
//                throw new ItemAlreadyExistsException();
//            } else if (this.table.get(idefName).getType().equals("field")) {
//                throw new FieldAlreadyExistsException();
//            }
        }
        SymbolTableItem item = new SymbolTableItem(idefName, attributes);
        this.table.put(idefName, item);
    }

    public String lookup(String idefName) {
        return this.table.get(idefName).toString();
    }

    public String printItems() {
        String itemsStr = "";
        for (Map.Entry<String, SymbolTableItem> entry :
                table.entrySet()) {
            itemsStr += "Key = " + entry.getKey() + " | Value = " + entry.getValue() + "\n";
        }
        return itemsStr;
    }

    public String toString() {
        return "------------- " + name + " : " + scopeNumber + " -------------\n" + printItems() + "-----------------------------------------\n";
    }

}
