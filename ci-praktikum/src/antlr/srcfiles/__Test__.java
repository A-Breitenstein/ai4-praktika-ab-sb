package antlr.srcfiles;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        artihmetic_puzzleLexer lex = new artihmetic_puzzleLexer(new ANTLRFileStream("__Test___input.txt", "UTF8"));
        TokenStream tokens = new CommonTokenStream(lex);

        artihmetic_puzzleParser g = new artihmetic_puzzleParser(tokens, null);
        System.out.println("Before Try");
        try {
            System.out.println("Going to Start");
            artihmetic_puzzleParser.start_return aReturn = g.start();
            System.out.println(aReturn.getTree());

            CommonTree mainTree = aReturn.getTree();

            for (Object o : mainTree.getChildren()) {
                System.out.println(o);
                for (Object o1 : ((CommonTree) o).getChildren()) {
                    System.out.println(((CommonTree) o1).getText());
                    for (Object o2 : ((CommonTree) o1).getChildren()) {
                        System.out.print(o2);
                    }
                    System.out.print("\n");
                }
            }


        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}