package lld.chainOfResponsibility.errorHandler;

public abstract class LogProcessor {
    LogProcessor nextLogProcessor;
    static int ERROR=1;
    static int DEBUG=2;
    static int INFO=3;
    LogProcessor(LogProcessor logProcessor){
        this.nextLogProcessor =logProcessor;
    }
    void log(int level,String msg){
        if (nextLogProcessor != null)
            nextLogProcessor.log(level,msg);
    }

}
