import java.util.ArrayList;
import java.util.List;

/**
 * The binary expression class, top class of binary classes.
 */
public abstract class BinaryExpression extends BaseExpression implements Expression {
    private Expression e1, e2;

    /**
     * constructor.
     * @param e1 first expression.
     * @param e2 second expression.
     * @param sign the sign.
     */
    public BinaryExpression(Expression e1, Expression e2, String sign) {
        //passing the sign to BaseExpression class.
        super(sign);
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public List<String> getVariables() {
        List vars = new ArrayList();
        List<String> additionalVars = new ArrayList<String>();
        vars = e1.addVar(vars);
        additionalVars = e2.addVar(vars);
        for (int i = 0; i < additionalVars.size(); i++) {
            if (!vars.contains(additionalVars.get(i))) {
                vars.add(additionalVars.get(i));
            }
        }
        return (vars);
    }



    @Override
    public Expression assign(String var, Expression expression) {
        return null;
    }

    /**
     * getter of first expression.
     * @return first expression.
     */
    public Expression getE1() {
        return this.e1;
    }

    /**
     * getter of second expression.
     * @return second expression.
     */
    public Expression getE2() {
        return this.e2;
    }
}
