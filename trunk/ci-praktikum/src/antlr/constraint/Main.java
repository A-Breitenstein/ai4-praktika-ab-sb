package antlr.constraint;

import java.io.*;

import antlr.srcfiles.*;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

public class Main {

    private static final String TEMPLATE_FILE = "template.stg";

    public static void main(String[] args) throws RecognitionException,FileNotFoundException, IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("__Test___input.txt"));
        artihmetic_puzzleLexer lexer = new artihmetic_puzzleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        artihmetic_puzzleParser parser = new artihmetic_puzzleParser(tokens);
        artihmetic_puzzleParser.starta_return result = parser.starta();
        Tree t = (Tree) result.getTree();
        System.out.println("nach dem parsen");
        System.out.println(t.toStringTree());

        CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        nodes.setTokenStream(tokens);
        treePaserPuzzel normalizer = new treePaserPuzzel(nodes);
        treePaserPuzzel.starta_return ast2 = normalizer.starta();
        CommonTree r2 = ((CommonTree) ast2.getTree());
        System.out.println("\n\nnach dem normalisieren");
        System.out.println(r2.toStringTree());


        CommonTreeNodeStream nodes2 = new CommonTreeNodeStream(r2);
        nodes2.setTokenStream(tokens);
        SymbolraetselEmitter2 emitter = new SymbolraetselEmitter2(nodes2);
        InputStream templateIs = Main.class.getClassLoader().getResourceAsStream(TEMPLATE_FILE);
        InputStream templateRichtig = new FileInputStream("template.stg");

        templateIs = templateRichtig;

        StringTemplateGroup templates = new StringTemplateGroup(new InputStreamReader(templateIs, "ISO-8859-15"),AngleBracketTemplateLexer.class);
        emitter.setTemplateLib(templates);
        SymbolraetselEmitter2.puzzle_return puzzle_return = emitter.puzzle();
        String output = puzzle_return.getTemplate().toString();
        System.out.println("\n\nausgabe");
        System.out.println(output);

        FileWriter writer = new FileWriter("src/ConstraintSolver.java");
        writer.write(output);
        writer.close();

    }
}
