package lld.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        SupportHandler level1Handler=new Level1SupportHandler();
        SupportHandler level2Handler=new Level2SupportHandler();
        SupportHandler level3Handler=new Level3SupportHandler();

        level2Handler.setHandler(level3Handler);
        level1Handler.setHandler(level2Handler);

        level1Handler.handleRequest("Level1 Request");
        level1Handler.handleRequest("Level2 Request");
        level1Handler.handleRequest("Level3 Request");

        level2Handler.handleRequest("Level1 Request");
        level2Handler.handleRequest("Level3 Request");


    }
}
