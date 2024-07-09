package Elements.Liquids;

import Elements.Element;
import Elements.Grid.Grid;

import java.lang.annotation.ElementType;

import static Elements.ElementTypes.EMPTY;
import static Elements.ElementTypes.LIQUID;

public class Liquid extends Element {
    public Liquid(int x,int y){
        this.color=color(3, 169, 252);
        this.x=x;
        this.y=y;
        this.type= LIQUID;
        this.canFall=true;
        this.updated=false;
    }

    @Override public void gravity(Grid grid){
        if(this.y<grid.size-2 && grid.grid[this.x][this.y+1].type==EMPTY){
            this.swap(grid,grid.grid[this.x][this.y+1]);
        }
    }

}
