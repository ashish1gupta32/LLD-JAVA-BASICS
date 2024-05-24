package lld.snakeLadder;

public class Player {
    static int idOffset=0;
    int id;
    int pos;
    Player(){
        this.id=getUniqueId();
        this.pos=0;
    }
    synchronized static int getUniqueId(){
        return idOffset++;
    }
}
