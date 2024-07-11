package Materials.Liquids;

import Materials.Grid.Grid;

import static Materials.MaterialTypes.WATER;

public class Water extends Liquid{
    public Water(int x,int y){
        super(x,y);
        this.type=WATER;
        this.color=color(3, 177, 252);
    }
    @Override
    public void update(Grid grid) {
        if(updated){
            return;
        }
        fall(grid);
    }
}
