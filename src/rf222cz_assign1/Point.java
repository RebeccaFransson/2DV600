package rf222cz_assign1;

import java.io.IOException;

/**
 * Created by ymafr on 2016-09-07.
 */
public class Point {
    public int x;
    public int y;

    //Default constructor
    public Point(){

    }
    //constructor with arguments
    public Point(int a, int b){
        this.x = a;
        this.y = b;
    }

    //I think the naming of the methods speek for themselfs.
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
    public boolean isEqualTo(Point compare){
        return this.x == compare.x && this.y == compare.y;
    }
    public double distanceTo(Point compare){
        return Math.sqrt( Math.pow((this.x-compare.x), 2) + Math.pow((this.y-compare.y), 2) );
    }
    public void move(int moveX, int moveY){
        this.x = this.x + moveX;
        this.y = this.y + moveY;
    }
    public void moveToXY(int moveX, int moveY){
        this.x = moveX;
        this.y = moveY;
    }


    public static void main(String[] args) throws IOException {
        try{
            Point p1 = new Point();
            Point p2 = new Point(3,4);

            System.out.println(p2.toString());   // ==> (3,4)
            System.out.println(p1.toString());   // ==> (0,0)

            if (p1.isEqualTo(p2))              // False!
                System.out.println("The two points are equal");

            double dist = p1.distanceTo(p2);
            System.out.println("Point Distance: "+dist);

            p2.move(5,-2);         // ==> (8,2)
            p1.moveToXY(8,2);      // ==> (8,2)

            if (p1.isEqualTo(p2))              // True!
                System.out.println("The two points are equal");

        }catch(NumberFormatException e ){
                System.err.println("Something went wrong");
        }
    }
}
