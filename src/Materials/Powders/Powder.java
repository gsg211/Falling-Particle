package Materials.Powders;

import Materials.Grid.MaterialGrid;
import Materials.Material;
import Materials.MaterialStates;

import static Materials.MaterialTypes.POWDER;

//Base class for powdery materials like sand

public class Powder extends Material {
    public Powder(int x, int y){
        super(x,y);
        this.type= POWDER;
        this.state=MaterialStates.SOLID;
    }

    public void fall(MaterialGrid grid) {
        if (this.y == grid.size - 1) {
            return;
        }
        //checks down neighbour
        Material nb=grid.grid[this.x][this.y + 1];
        if (nb.density < density && nb.state!= MaterialStates.SOLID) {
            this.swap(grid, nb);
            return;
        }
        //checks down-right neighbour
        if(this.x < grid.size - 1 ){
            nb=grid.grid[this.x+1][this.y + 1];
            Material nb2=grid.grid[this.x + 1][this.y];
            if ( nb.density < density && nb.state!= MaterialStates.SOLID
                    && (nb2.density < density && nb2.state!= MaterialStates.SOLID)) {

                this.swap(grid, grid.grid[this.x + 1][this.y + 1]);
                return;
            }
        }


        //checks down-left neighbour

        if(this.x >0){
            nb=grid.grid[this.x - 1][this.y + 1];
            Material nb2=grid.grid[this.x - 1][this.y];

            if ( nb.density < density && nb.state!= MaterialStates.SOLID
                    && (nb2.density < density && nb2.state!= MaterialStates.SOLID)) {
                this.swap(grid, grid.grid[this.x - 1][this.y + 1]);
            }
        }

    }

    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
        this.fall(grid);
    }
}
