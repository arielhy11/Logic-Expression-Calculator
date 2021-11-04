import java.util.List;
import java.util.Map;

/**
 * The not class.
 */
public class Not extends UnaryExpression implements Expression {
    /**
     * constructor.
     * @param e1 the expression.
     */
    public Not(Expression e1) {
        super(e1, "~");
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
        return !(getE().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        // if there are variables in the expression, raise error.
        if (getVariables().size() != 0) {
            throw new Exception("Cannot evaluate!");
        }
        return !(getE().evaluate());
    }

    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(getE().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(this.getE().nandify(), this.getE().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(this.getE().norify(), this.getE().norify());
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
        return new Not(getE().simplify());
    }

    @Override
    public List addVar(List list) {
        // searching for vars in expression to add them to list.
        getE().addVar(list);
        return list;
    }

    @Override
    public String toString() {
        return "~(" + getE().toString() + ")";
    }


}
