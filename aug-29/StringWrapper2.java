public class StringWrapper2{

    public String s;

    static void changeString(StringWrapper2 t){
        t.s +="World";

    }
   static void change(StringWrapper s){
        s.concat(" World is Changed!");
        
    }
    
    public static void main(String[] args){
        StringWrapper2 sti = new StringWrapper2();
        sti.s = "Hello ";
       
        changeString(sti);
        System.out.println(sti.s);

        // change stii = new change();
        change(sti.s);
        // sti.s = change(sti.s);
        System.out.println(sti.s);
    }
}