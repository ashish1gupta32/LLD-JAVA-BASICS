package lld.chainOfResponsibility.errorHandler;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int level, String msg) {
        if (DEBUG==level) System.out.println(STR."DEBUG : \{msg}");
        else super.log(level,msg);
    }
}
