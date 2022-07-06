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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public static void semanticAnalysis(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader reader = new FileReader(file);

    }
}
