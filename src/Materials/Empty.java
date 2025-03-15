package Materials;

import static Materials.MaterialTypes.EMPTY;

public class Empty extends Material {
    public Empty(int x,int y){

        super(x,y);
        this.color=color(0);
        type=EMPTY;
        this.density=Integer.MIN_VALUE;
        this.state=MaterialStates.EMPTY;
    }
}
