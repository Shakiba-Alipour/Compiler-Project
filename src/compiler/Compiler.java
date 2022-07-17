package compiler;


import gen.JythonLexer;
import gen.JythonListener;
import gen.JythonParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.HashMap;

public class Compiler {
    public static void main(String[] args) throws IOException, FieldAlreadyExistsException, MethodAlreadyExistsException, UndefinedFieldException, UndefinedClassWxception {
        System.out.println("Lexical Analysis:\n");
        lexicalAnalysis("./input.txt");
        System.out.println("Semantic Analysis:\n");
        semanticAnalysis("./input.txt");
    }

    public static void lexicalAnalysis(String path) throws IOException {
        CharStream stream = CharStreams.fromFileName(path);
        JythonLexer lexer = new JythonLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        JythonParser parser = new JythonParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        JythonListener listener = new ProgramPrinter();

        walker.walk(listener, tree);
    }

    public static void semanticAnalysis(String path) throws IOException, FieldAlreadyExistsException, MethodAlreadyExistsException, UndefinedFieldException, UndefinedClassWxception {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        HashMap<String, Symbol_Table> tables = new HashMap<>();
        // read file
        int i = 0;
        for (String line : reader.lines().toList()
        ) {
            i++;
            //remove spaces from the beginning of the line
            line = line.replaceFirst("^\\s*", "");
            boolean isNewScope = isNewScope(line);
            String name = "", itemName = "";
            if (isNewScope) {
                if (line.contains("if")) {
                    name = "if";
                    String[] splitted = line.split(" ");
                    itemName = "Field_" + splitted[1];
                } else if (line.contains("elif")) {
                    name = "if";
                    String[] splitted = line.split(" ");
                    itemName = "Field_" + splitted[1];
                } else if (line.contains("else")) {
                    name = "if";
                    String[] splitted = line.split(" ");
                    itemName = "Field_" + splitted[1];
                } else if (line.contains("while")) {
                    name = "while";
                    String[] splitted = line.split(" ");
                    itemName = "Field_" + splitted[0];
                } else if (line.contains("for")) {
                    name = "for";
                    String[] splitted = line.split(" ");
                    itemName = "Field_" + splitted[1];
                } else if (line.contains("import")) {
                    name = "program";
                    itemName = line.replace(' ', '_');
                } else {
                    String[] splitted = line.split(" ");
                    name = splitted[1];
                    itemName = name;
                    if ((line.split(" ")[1].charAt(0) >= 65) && (line.split(" ")[1].charAt(0) <= 65)) {
                        itemName = "constructor_" + splitted[1];
                    }
//                    if (line.contains("(")){
//                        splitted=line.split(" ()");
//                        name = splitted[1];
//                        itemName = name;
//                    }
                }
                Symbol_Table table = new Symbol_Table(name, i);
                tables.put(name, table);
            }
            System.out.println(tables);
            if (tables.get(name) != null) {
                tables.get(name).insert(itemName, line, i);
            }
        }

        //print file
        for (int j = 0; j < tables.size(); j++) {
            if (tables.get(j) != null) {
                for (int k = 0; k < tables.get(j).getSize(); k++) {
                    tables.get(j).toString();
                }
            }
        }
    }

    public static boolean isNewScope(String line) {
        if (line.contains("import") || line.contains("class") || line.contains("def") || line.contains("if") ||
                line.contains("elif") || line.contains("else") || line.contains("while") || line.contains("for")) {
            return true;
        } else {
            return false;
        }
    }
}
