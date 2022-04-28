package compiler;

import gen.JythonLexer;
import gen.JythonListener;
import gen.JythonParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.IOException;

public class Compiler {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("./sample/test.cl");
        JythonLexer lexer = new JythonLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        JythonParser parser = new JythonParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        JythonListener listener = new ProgramPrinter();

        walker.walk(listener, tree);
    }
}
