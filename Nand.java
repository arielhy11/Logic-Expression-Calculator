import java.util.List;
import java.util.Map;

/**
 * The nand class.
 */
public class Nand extends BinaryExpression implements Expression {
    /**
     * constructor.
     * @param e1 first expression.
     * @param e2 second expression.
     */
    public Nand(Expression e1, Expression e2) {
        super(e1, e2, "A");
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        // if there are no vars, can evaluate.
        if (getVariables().size() != 0) {
            // going through all vars and checking if in map, if not trough exception.
            for (String var: getVariables()) {
                if (!(assignment.containsKey(var))) {
                    throw new Exception("Cannot evaluate!");
                }
            }
        }
        return !(super.getE1().evaluate(assignment) && super.getE2().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        // if there are variables in the expression, raise error.
        if (getVariables().size() != 0) {
            throw new Exception("Cannot evaluate!");
        }
        return !(super.getE1().evaluate() && super.getE2().evaluate());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nand(getE1().assign(var, expression), getE2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(getE1().nandify(), getE2().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(new Nor(getE1().norify(), getE1().norify()),
                new Nor(getE2().norify(), getE2().norify())),
                new Nor(new Nor(getE1().norify(), getE1().norify()),
                new Nor(getE2().norify(), getE2().norify())));
    }

    @Override
    public Expression simplify() {
        // if no variables, can calculate.
        if (getVariables().size() == 0) {
            try {
                return new Val(evaluate());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // according to:
        //x ↑ 1 = ~(x).
        //x ↑ 0 = 1.
        //x ↑ x = ~(x).
        if (getE1().simplify().toString().equals(getE2().simplify().toString())) {
            return new Not(getE1().simplify());
        } else if (getE1().toString().equals(new Val(false).toString())
                || getE2().toString().equals(new Val(false).toString())) {
            return new Val(true);
        } else if (getE1().toString().equals(new Val(true).toString())) {
            return new Not(getE2().simplify());
        } else if (getE2().toString().equals(new Val(true).toString())) {
            return new Not(getE1().simplify());
        } else {
            return new Nand(getE1().simplify(), getE2().simplify());
        }
    }

    @Override
    public List addVar(List list) {
        // searching for vars in both expressions to add them to list.
        getE1().addVar(list);
        getE2().addVar(list);
        return list;
    }

    @Override
    public String toString() {
        return "(" + getE1().toString() + " A " + getE2().toString() + ")";
    }
}
