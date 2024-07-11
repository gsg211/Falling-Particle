package Materials;

import static Materials.MaterialTypes.EMPTY;

public class Empty extends Material {
    public Empty(int x,int y){
        this.color=color(0);
        this.x=x;
        this.y=y;
        this.type=EMPTY;
        this.canFall=false;
    }
}
