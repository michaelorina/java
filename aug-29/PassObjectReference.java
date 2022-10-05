public class PassObjectReference{
    public Point pnt1 = new Point(0,0);
    public Point pnt2 = new Point(0,0);

    static void tricky(PassObjectReference por){
        por.pnt1.x=100;
        por.pnt1.y=150;

        Point temp = por.pnt1;
        por.pnt1 = por.pnt2;
        por.pnt2 = temp;
    }
    public static void main(String[] args){

        PassObjectReference por = new PassObjectReference();

        System.out.println("X:" + por.pnt1.x + " Y:" + por.pnt1.y);
        System.out.println("X:" + por.pnt2.x + " Y:" + por.pnt2.y);
        System.out.println("--");
        
        tricky(por);
        
        System.out.println("X:" + por.pnt1.x + " Y:" + por.pnt1.y);
        System.out.println("X:" + por.pnt2.x + " Y:" + por.pnt2.y);
    }
}