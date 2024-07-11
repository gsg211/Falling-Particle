package Materials.Liquids;

import Materials.Material;


import static Materials.MaterialTypes.LIQUID;

public class Liquid extends Material {


    public Liquid(int x,int y){
        this.color=color(3, 169, 252);
        this.x=x;
        this.y=y;
        this.type= LIQUID;
        this.canFall=true;
    }
}
