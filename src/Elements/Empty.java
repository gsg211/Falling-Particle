package Elements;

import static Elements.ElementTypes.EMPTY;

public class Empty extends  Element{
    public Empty(int x,int y){
        this.color=color(0);
        this.x=x;
        this.y=y;
        this.type=EMPTY;
        this.canFall=false;
    }
}
