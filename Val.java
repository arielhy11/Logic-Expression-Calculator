import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The val class.
 */
public class Val implements Expression {
    private Boolean bool;

    /**
     * constructor.
     * @param bool a boolean.
     */
    public Val(Boolean bool) {
        this.bool = bool;
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.bool;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.bool;
    }

    @Override
    public List<String> getVariables() {
        List vars = new ArrayList();
        return vars;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
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
        return list;
    }

    @Override
    public String toString() {
        if (this.bool) {
            return "T";
        } else {
            return "F";
        }
    }


}
