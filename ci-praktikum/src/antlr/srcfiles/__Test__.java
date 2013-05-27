package antlr.srcfiles;

import antlr.constraint.AlphametricSample;
import antlr.constraint.ConstraintSolver;
import antlr.entities.Calcsym;
import antlr.entities.Number;
import antlr.entities.Operation;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class __Test__ {

    public static void main(String args[]) throws Exception {

        Map<String, String> tokenMap = new HashMap<String, String>();
        int tokenIDCounter = 0;

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

                    String token = builder.toString();
                    Number number;
                    String tokenID = tokenMap.get(token);

                    if ( tokenID == null) {
                        tokenID = String.valueOf(tokenIDCounter++);
                        tokenMap.put(token, tokenID);
                        number = Number.create(tokenID, token);

                    } else {
                        number = Number.create(tokenID,token);
                    }

                    switch (zahlCounter) {
                        case 0:
                            operation.setFirstOperand(number);
                            break;
                        case 1:
                            operation.setSecondOperand(number);
                            break;
                        case 2:
                            operation.setResult(number);
                            break;
                    }
                    builder = new StringBuilder();
                    zahlCounter++;
                }

                raetsel.add(operation);
            }

            System.out.println("Standard:");
            for (Operation op : raetsel) {
                System.out.println(op);
            }

            ConstraintSolver constraintSolver = new ConstraintSolver();

            System.out.println("Normalized:");
            for (Operation oper : raetsel) {
                oper.normalize();
                System.out.println(oper);

                System.out.println("---beispiel---");
                new AlphametricSample(oper.getFirstOperand().getNumber(), oper.getSecondOperand().getNumber(), oper.getResult().getNumber()).run();

                System.out.println("---nachgemacht---");
                constraintSolver.addOperation(oper.getFirstOperand().getNumber(),
                        oper.getSecondOperand().getNumber(),
                        oper.getResult().getNumber());
            }

            constraintSolver.solveModel();


        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}