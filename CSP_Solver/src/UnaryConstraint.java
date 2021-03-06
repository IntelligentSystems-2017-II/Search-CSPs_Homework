import java.util.List;

public class UnaryConstraint<T> implements Constraint {
    Variable theVariable;
    T value;

    public UnaryConstraint(Variable theVariable, T value){
        this.theVariable = theVariable;
        this.value = value;
    }

    @Override
    public List<Variable> getScope() {
        return null;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        if (!theAssignment.getAssignments().containsKey(theVariable))
            return false;
        else
            return theAssignment.getAssignments().get(theVariable).equals(value);
    }
}
