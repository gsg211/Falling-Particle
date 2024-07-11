package Materials.Powders;

import Materials.Material;

import static Materials.MaterialTypes.LIQUID;

public class Powder extends Material {
    public Powder(int x, int y){
        this.x=x;
        this.y=y;
        this.type= LIQUID;
        this.canFall=true;
    }
}
