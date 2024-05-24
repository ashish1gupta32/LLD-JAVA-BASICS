package lld.interpretorDesignPattern;

public class NumberTerminalExpression implements AbstractExpression{
    String stringVal;
    NumberTerminalExpression(String val){
        this.stringVal=val;
    }
    @Override
    public int interpret(Context context) {
        return context.getContext(stringVal);
    }
}
