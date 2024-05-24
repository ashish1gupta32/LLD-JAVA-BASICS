package enumPractice;

public enum Region {
    RE1("RE1","region-1") ,RE2("RE2","region-2"),
    RE3("RE3","region-3"),RE4("RE4","region-4"),
    RE5("RE5","region-5"){
        @Override
        String getRegion(){
            return val;
        }
    };
    String key;
    String val;
    static String value="Region";
    Region(String key,String val){
        this.key=key;
        this.val=val;
    }
    Region(){}
    String getRegion(){
        return key;
    }
    static void getRegionList(){
        for(Region val:Region.values()){
            System.out.println(val.ordinal());
            System.out.println(val.key);
            System.out.println(val.val);
            System.out.println("...........");
        }
//        System.out.println(region.getRegion());
    }



}
