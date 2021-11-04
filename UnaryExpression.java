import java.util.ArrayList;
import java.util.List;

/**
 * The unary class, top class of unary expressions.
 */
public abstract class UnaryExpression extends BaseExpression implements Expression {
    private Expression e;

    /**
     * constructor.
     * @param e the expression.
     * @param sign the sign.
     */
    public UnaryExpression(Expression e, String sign) {
        // passing the sign to BaseExpression.
        super(sign);
        this.e = e;
    }

    /**
     * getter for expression.
     * @return the expression.
     */
    public Expression getE() {
        return e;
    }

    @Override
    public List<String> getVariables() {
        List vars = new ArrayList();
        vars = e.addVar(vars);
        return vars;
    }
}
