package singleton;

public class SingletonBillPaugh {

    private static class InstanceClass{
        private  static  SingletonBillPaugh instance=new SingletonBillPaugh();
    }
    private SingletonBillPaugh(){

    }
    public  static synchronized SingletonBillPaugh getInstance() {
        return InstanceClass.instance;
    }
}

