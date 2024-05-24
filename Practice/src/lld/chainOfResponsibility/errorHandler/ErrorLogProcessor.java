package lld.chainOfResponsibility.errorHandler;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }
    @Override
    void log(int level,String msg){
        if (ERROR==level) System.out.println(STR."ERROR : \{msg}");
        else super.log(level,msg);
    }
}
