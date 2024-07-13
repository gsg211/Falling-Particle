package Materials;

import Materials.Liquids.Water;
import Materials.Powders.WetSand;
import processing.core.PApplet;
import Materials.Grid.MaterialGrid;

import static Materials.MaterialTypes.WATER;

/*
    Base class for the materials
*/

public class Material extends PApplet{
    public int color;
    public int x,y;
    public MaterialTypes type;
    public int density;

    public Boolean updated=false;
    public Material(){
    }

    public Material(int x, int y){
        this.x=x;
        this.y=y;
    }

    //used to swap to materials within the grid
    public void swap(MaterialGrid grid, Material elementToSwap){
        int x1,x2,y1,y2;

        x1=this.x;
        x2=elementToSwap.x;
        y1=this.y;
        y2=elementToSwap.y;

        grid.grid[x1][y1]=elementToSwap;
        grid.grid[x2][y2]=this;

        grid.grid[x1][y1].x=x1;
        grid.grid[x1][y1].y=y1;
        grid.grid[x2][y2].x=x2;
        grid.grid[x2][y2].y=y2;
    }

    //makes a material fall to the bottom of the grid
    public void fall(MaterialGrid grid) {
        if (this.y == grid.size - 1) {
            return;
        }
        //checks down neighbour
        if (grid.grid[this.x][this.y + 1].density < density ) {
            this.swap(grid, grid.grid[this.x][this.y + 1]);
            return;
        }
        //checks down-right neighbour
        if (this.x < grid.size - 1 && grid.grid[this.x + 1][this.y + 1].density < density) {
            this.swap(grid, grid.grid[this.x + 1][this.y + 1]);
            return;
        }
        //checks down-left neighbour
        if (this.x > 0 && grid.grid[this.x - 1][this.y + 1].density < density) {
            this.swap(grid, grid.grid[this.x - 1][this.y + 1]);
        }
    }

    public void moveRight(MaterialGrid grid){
        if (this.x<grid.size-1){
            this.swap(grid, grid.grid[this.x + 1][this.y]);
        }
    }

    public void moveLeft(MaterialGrid grid){
        if (this.x>0) {
            this.swap(grid, grid.grid[this.x - 1][this.y]);
        }
    }

    public void update(MaterialGrid grid){
        //stops materials from updating twice per update cycle
        if(updated){
            return;
        }
        fall(grid);
        //disperseRight(grid);
    }

    public void replaceMaterial(MaterialGrid grid, Material newMaterial){
        //replaces this material with another
        //used in reactions

        newMaterial.x=x;
        newMaterial.y=y;
        grid.setElement(x,y,newMaterial);
    }

    public Material checkForMaterial(MaterialGrid grid, Material material){
        //checks all neighbouring cells for a material
        //this method is used for reactions

        //upper cell
        int size=grid.size;
        if(y<size-2 && grid.grid[x][y+1].type==material.type){
            return grid.grid[x][y+1];
        }
        //down cell
        if(y>1 && grid.grid[x][y-1].type==material.type){
            return grid.grid[x][y-1];
        }
        //right cell
        if(x<size-2 && grid.grid[x+1][y].type==material.type){
            return grid.grid[x+1][y];
        }
        //left cell
        if(x>1 && grid.grid[x-1][y].type==material.type){
            return grid.grid[x-1][y];
        }
        //upper-right cell
        if(x<size-2 && y<size-2 && grid.grid[x+1][y+1].type==material.type){
            return grid.grid[x+1][y+1];
        }
        //upper-left
        if(x>1 && y<size-2 && grid.grid[x-1][y+1].type==material.type){
            return grid.grid[x-1][y+1];
        }
        //down-right cell
        if(x<size-2 && y>1 && grid.grid[x+1][y-1].type==material.type){
            return grid.grid[x+1][y-1];
        }
        //down-left cell
        if(x>1 && y>1 && grid.grid[x-1][y-1].type==material.type){
            return grid.grid[x-1][y-1];
        }
        return new Empty(0,0);
    }

    public void reactWithMaterial(MaterialGrid grid,Material reactant, Material product, Material reactantProduct) {
        //reactant is the other material needed for the reaction
        //product is the material that this material is replaced by
        //reactant product is the material that the reactant is replaced by

        Material result = checkForMaterial(grid, reactant);
        //println(result.type+": "+(x-result.x) + " "+ (y-result.y) );
        if (result.type == reactant.type) {
            replaceMaterial(grid, product);
            result.replaceMaterial(grid,reactantProduct);
        }
    }
}