package lld.chainOfResponsibility.errorHandler;

public class Main {
    public static void main(String[] args) {
        LogProcessor logHandler = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logHandler.log(LogProcessor.ERROR,"exception happens");
        logHandler.log(LogProcessor.DEBUG,"need to debug this");
        logHandler.log(LogProcessor.INFO,"just for info");
//        logHandler.log(1818,"just for info");
    }
}
