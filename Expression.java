import java.util.List;
import java.util.Map;

/**
 * the interface expression.
 */
public interface Expression {
    /**
     *  * Evaluate the expression using the variable values provided
     *  * in the assignment, and return the result. If the expression
     *  * contains a variable which is not in the assignment, an exception
     *  * is thrown.
     * @param assignment holds values to pass to vars.
     * @return evaluated expression.
     * @throws Exception if vars are left, raise error.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;
    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return evaluated expression.
     * @throws Exception if vars are left, raise error.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     * @return list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     * @return nice string representation of the expression.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var variable to be assigned to.
     * @param expression to be assigned to variable.
     * @return the expression after assignment.
     */
    Expression assign(String var, Expression expression);
    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return expression tree.
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return expression tree.
     */
    Expression norify();

    /**
     * Returned a simplified version of the current expression.
     * @return simplified version of the current expression.
     */
    Expression simplify();

    /**
     * if existing, put the var inside the list.
     * @param list the list which will contain the variable.
     * @return the list with the variable inside.
     */
    List addVar(List list);
}
