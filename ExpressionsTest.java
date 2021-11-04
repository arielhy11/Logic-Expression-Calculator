import java.util.HashMap;
import java.util.Map;

public class ExpressionsTest {
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
        System.out.println(e.toString());
        Map<String, Boolean> myMap = new HashMap<String, Boolean>();
        myMap.put("x", false);
        myMap.put("y", true);
        myMap.put("z", true);
        System.out.println(e.evaluate(myMap));
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}
