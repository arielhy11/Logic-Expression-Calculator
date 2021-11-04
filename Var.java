import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The var class.
 */
public class Var implements Expression {

    private String variable;
    /**
     * constructor.
     * @param var a variable.
     */
    public Var(String var) {
        this.variable = var;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(variable)) {
            return assignment.get(variable);
        } else {
            throw new Exception("no value was attached.");
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        return null;
    }

    @Override
    public List<String> getVariables() {
        List vars = new ArrayList();
        vars.add(variable);
        return vars;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.variable.equals(var)) {
            return expression;
        } else {
            return this;
        }
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public List addVar(List list) {
        list.add(this.variable);
        return list;
    }

    @Override
    public String toString() {
        return this.variable;
    }


}
