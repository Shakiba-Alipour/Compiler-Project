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
import java.util.ArrayList;

public class Compiler {
    public static void main(String[] args) throws IOException {
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

    public static void semanticAnalysis(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<Symbol_Table> tables = new ArrayList<>();
        // read file
        int i = 0;
        for (String line : reader.lines().toList()
        ) {
            i++;
            //remove spaces from the beginning of the line
            line = line.replaceFirst("^\\s*", "");
            boolean isNewScope = isNewScope(line);
            if (isNewScope) {
                String name = "";
                if (line.contains("if")) {
                    name = "if";
                } else if (line.contains("elif")) {
                    name = "elif";
                } else if (line.contains("else")) {
                    name = "else";
                } else if (line.contains("while")) {
                    name = "while";
                } else if (line.contains("for")) {
                    name = "for";
                } else {
                    String[] splitted = line.split(" ");
                    name = splitted[1];
                }
                Symbol_Table table = new Symbol_Table(name, i);
            }
        }

        //print file
//        for (int j = 0; j < tables.size(); j++) {
//            for (int k = 0; k < tables.get(j).; k++) {
//
//            }
//        }
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
