/**
 * The base expression, holding the sign. Top abstract class.
 */
public abstract class BaseExpression implements Expression {
    private String sign;

    /**
     * constructor.
     * @param sign the sign of the expression.
     */
    public BaseExpression(String sign) {
        this.sign = sign;
    }
}
