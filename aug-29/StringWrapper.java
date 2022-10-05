public class StringWrapper{

    public String s;

    static void changeString(StringWrapper t){
        t.s +="World";
    }
    public static void main(String[] args){
        StringWrapper sti = new StringWrapper();
        sti.s = "Hello ";

        changeString(sti);

        System.out.println(sti.s);
    }
}