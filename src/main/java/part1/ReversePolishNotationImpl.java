package part1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotationImpl implements ReversePolishNotation {
    @Override
    public Operacion procesarOperacion(Operacion o) {
        Stack<Integer> nombres=new Stack<>();
        String input;
        int n;
        boolean parsable;
        String[] operacion= o.getOperacion().split(" ");
        for (int i=0;i<operacion.length;i++){
            input=operacion(i);
            try {
                n=Integer.parseInt(input);
                parsable=true;

            }catch(ParseException e){
            parsable = false;
            }
            if (parsable){
                nombres.push(n);
            }
            else{
                int a,b;
                switch (input){
                    case "+":
                        a=nombres.pop();
                        b=nombres.pop();
                        nombres.push(a+b);
                        break;
                    case "-":
                        a=nombres.pop();
                        b=nombres.pop();
                        nombres.push(a-b);
                        break;
                    case "*":
                        a=nombres.pop();
                        b=nombres.pop();
                        nombres.push(a*b);
                        break;
                    case "/":
                        a=nombres.pop();
                        b=nombres.pop();
                        nombres.push(a/b);
                }
            }
        }
        o.setResultat(nombres.pop());
        return o;
    }
}
