package Materials.Gasses;

public class Steam extends Gas{
    public Steam (int x,int y){
        super(x,y);
        this.color=(Math.random() < 0.8)? color(224, 224, 209): color(245, 245, 240);
        this.dispersal=1;
        this.density=-1000;
        this.lifetime=1000;
    }
}
