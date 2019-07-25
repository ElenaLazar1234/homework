package Coding_Assignment;

public class Drawing_Tool {
        static double totalSum =0;
        static Shape shapes[] = new Shape[1000];
        static int i=0;

        public static void main(String[] args) {

            Rectangle rectangle= new Rectangle(2,3);
            Add(rectangle);
            Square square = new Square(5);
            Add(square);
            Circle circle = new Circle(4);
            Add(circle);
            Triangle triangle = new Triangle(1,2,3);
            Add(triangle);
            System.out.println(Sum());
        }
        public static void Add(Shape newShape){
            shapes[i]=newShape;
            i++;

        }
        public static double Sum(){

            for (int k=0;k<i-1;k++){
                 totalSum= totalSum + shapes[k].Area()+shapes[k].Perimeter();
            }
            return totalSum;
        }


    }
