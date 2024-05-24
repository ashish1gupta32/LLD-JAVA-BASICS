package lld.chainOfResponsibility.errorHandler;

public class InfoLogProcessor extends LogProcessor {

    InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    @Override
    public void log(int level, String msg) {
        if (INFO==level){
            System.out.println(STR."INFO : \{msg}");
        }
        else super.log(level,msg);
    }
}
