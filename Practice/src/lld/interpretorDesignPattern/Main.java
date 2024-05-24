package lld.interpretorDesignPattern;

public class Main {
    public static void main(String[] args){
        Context context=new Context();
        context.addContext("a",3);
        context.addContext("b",5);
        context.addContext("c",4);
        context.addContext("d",7);

        //a*b
        System.out.println(new BinaryNonTerminalExpression(new NumberTerminalExpression("a"),
                new NumberTerminalExpression("b"),'*').interpret(context));

        //a+(c*d)
        System.out.println(new BinaryNonTerminalExpression(new NumberTerminalExpression("a"),
                new BinaryNonTerminalExpression(new NumberTerminalExpression("c"),
                        new NumberTerminalExpression("d"),'*'),'+').interpret(context));


    }
}
