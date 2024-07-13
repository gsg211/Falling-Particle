package Materials.Liquids;

import static Materials.MaterialTypes.WATER;

public class Water extends Liquid{
    public Water(int x,int y){
        super(x,y);
        this.type=WATER;
        this.color=(Math.random() < 0.8)? color(3, 177, 252): color(2, 160, 227);
        this.dispersal=1;
        this.density=1000;
    }
}
