package antlr.srcfiles;

import antlr.entities.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;
import java.util.List;


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
            List<Operation> raetsel = new ArrayList<Operation>();

            Operation operation;
            StringBuilder builder;
            int zahlCounter;

            for (Object o : mainTree.getChildren()) {

//                System.out.println(o); //Operationssymbol

                operation = Operation.create();
                builder = new StringBuilder();
                operation.setCalcsym(Calcsym.evaluateStringToCalcSym(String.valueOf(o)));
                zahlCounter = 0;

                for (Object o1 : ((CommonTree) o).getChildren()) {

//                    System.out.println(o1); //ZAHL Token

                    for (Object o2 : ((CommonTree) o1).getChildren()) {
//                        System.out.print(o2); //Alle Zeichen die letzendlich eine Symbolzahl darstellt
                        builder.append(String.valueOf(o2));
                    }
//                    System.out.print("\n");

                    switch (zahlCounter) {
                        case 0: operation.setFirstOperand(antlr.entities.Number.create("",builder.toString()));
                            break;
                        case 1: operation.setSecondOperand(antlr.entities.Number.create("", builder.toString()));
                            break;
                        case 2: operation.setResult(antlr.entities.Number.create("", builder.toString()));
                            break;
                    }
                    zahlCounter++;
                }

                raetsel.add(operation);
            }


            for (Operation operation1 : raetsel) {
                System.out.println(operation1);
            }
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}