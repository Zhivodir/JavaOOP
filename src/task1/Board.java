package task1;

/**
 * Created by 1 on 14.10.2016.
 */
public class Board {
    private Shape [] shapeArray = new Shape[4];

    public Board(){}

    public void addShape(Shape shape, int position){
        if((shapeArray[position] == null)&&(position < 4)) {
            shapeArray[position] = shape;
        }else{
            System.out.println("This position is occupied by other shape");
        }
    }

    public void deleteShape(Shape shape){
        for (int i = 0; i < shapeArray.length; i++) {
            if(shapeArray[i] == shape){
                shapeArray[i] = null;
                return;
            }
        }
    }

    public void getInfo(){
        double commonArea = 0;
        for(int i=0; i<shapeArray.length; i++ ){
            if(shapeArray[i] == null){
                System.out.println(i + ".Position is empty...");
                continue;
            }
            commonArea += shapeArray[i].area();
            System.out.println(i + 1 + "." + shapeArray[i]);
        }
        System.out.println();

        System.out.println("Total area: " + commonArea);
    }
}
