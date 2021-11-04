import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test_part1 {
    public static void main(String[] args) throws Exception {
        Expression e = new Not(
            new Xor(
                new And(
                    new Val(true),
                    new Or(
                        new Var("x"),
                        new Var("y")
                    )
                    ),
                    new Var("z")
            )
        );
        Expression e7 = new Not(new Var("a"));
        Expression e8 = new And(new Var("a"), new Var("b"));
        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));
        Expression e3 = e2.assign("x", new Val(true));
        Expression e4 = e3.assign("y", new Val(false));
        Expression e5 = e3.norify();
        Expression e6 = e5.simplify();
        System.out.println(e.toString());//~(((T & (x | y)) ^ z))
        System.out.println(e2.toString());//((x & y) ^ T)
        System.out.println(e3.toString());//((T & y) ^ T)
        System.out.println(e4.toString());//((T & F) ^ T)
        System.out.println(e4.evaluate());//true
        System.out.println(e5.toString());//(((((T ↓ T) ↓ (y ↓ y)) ↓ ((T ↓ T) ↓ (y ↓ y))) ↓ (T ↓ T)) ↓ (((T ↓ T) ↓ (y ↓ y)) ↓ T))
        System.out.println(e6.toString());//((((T ↓ ~(y)) ↓ (T ↓ ~(y))) ↓ T) ↓ ((T ↓ ~(y)) ↓ T))
        System.out.println(e7.getVariables().toString());//a
        System.out.println(e8.getVariables().toString());//a,b
        System.out.println(e.getVariables().toString()); // x,y,z
        Map<String, Boolean> myMap = new HashMap<String, Boolean>();
        myMap.put("y", true);
        System.out.println(e5.evaluate(myMap));//true
        System.out.println(e5.assign("y", new Val(true)));//(((((T ↓ T) ↓ (T ↓ T)) ↓ ((T ↓ T) ↓ (T ↓ T))) ↓ (T ↓ T)) ↓ (((T ↓ T) ↓ (T ↓ T)) ↓ T))
        System.out.println(e5.assign("y", new Val(false)).simplify());
    }

}
