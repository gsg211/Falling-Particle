import Materials.Gasses.Steam;
import Materials.Grid.MaterialGrid;
import Materials.*;
import Materials.Liquids.Water;
import Materials.Powders.Sand;
import Materials.Solids.Wood;
import processing.core.PApplet;
import processing.core.PFont;
import processing.event.MouseEvent;

public class Main extends PApplet{
    int x,y;
    int matrixSize=100;
    int pixelSize=5; //each "Material pixel" is a 5x5 square of pixels
    int scrollValue=0;
    int lastMaterial =3;

    Material printMaterial=new Sand(0,0);
    Material paintingMaterial;
    MaterialGrid grid =new MaterialGrid(this,matrixSize,pixelSize);

    String currentMaterialString="SAND";
    String cursorMaterialString="EMPTY";
    public void settings() {
        size(500, 525);
    }

    public void draw() {

        background(color(0));

        grid.renderGrid();
        grid.updateGrid();

        textSize(20);
        fill(color(255));
        text(currentMaterialString,0,520);

        checkMaterial();
        textSize(20);
        fill(color(255));
        text(cursorMaterialString,400,520);

    }
    public void checkMaterial(){
        int x=mouseX/pixelSize;
        int y=mouseY/pixelSize;

        //avoid out of bounds exception
            if(x<0 || x>matrixSize-1){
            return;
        }
        if(y<0 || y>matrixSize-1) {
            return;
        }
        cursorMaterialString=grid.grid[x][y].type.toString();

    }

    public void paintMaterial(){
        //converts cursor position to array position
        int x=mouseX/pixelSize;
        int y=mouseY/pixelSize;

        //avoid out of bounds exception
        if(x<0 || x>matrixSize-1){
            return;
        }
        if(y<0 || y>matrixSize-1){
            return;
        }
        paintingMaterial=selectPaintingMaterial(x,y);
        grid.setMaterial(x,y,paintingMaterial);
    }
    public void mouseDragged(){
        paintMaterial();
    }

    public void mousePressed(){
        paintMaterial();
    }

    public Material selectPaintingMaterial(int x,int y){
        return switch (scrollValue) {
            case -1 -> {
                //returns the last material
                scrollValue = lastMaterial;
                yield selectPaintingMaterial(x,y);
            }
            case 0 -> new Sand(x, y);
            case 1 -> new Water(x, y);
            case 2 -> new Wood(x, y);
            case 3 -> new Steam(x, y);
            default -> {
                //if scrollValue too big, material is reset
                scrollValue = 0;
                yield selectPaintingMaterial(x,y);
            }
        };
    }

    @Override
    public void mouseWheel(MouseEvent event) {
        super.mouseWheel(event);
        int readScrollValue = event.getCount();

        //subtraction so that forward increments;
        scrollValue-=readScrollValue;
        printMaterial=selectPaintingMaterial(0,0);
        currentMaterialString=printMaterial.type.toString();
    }

    public static void main(String[] args) {
        String[] processingArgs = {"mySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}