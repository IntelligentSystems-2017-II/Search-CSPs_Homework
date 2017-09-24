import java.util.ArrayList;
import java.util.List;

public class BinaryConstraint<T> implements Constraint {
    List<Variable> scope; //List of vars involved
    T valueVar1;
    T valueVar2;
    String description;

    public BinaryConstraint(Variable var1, Variable var2 , T valueVar1, T valueVar2, String description){
        // scope = vars;
        this.valueVar1 = valueVar1;
        this.valueVar2 = valueVar2;
        scope = new ArrayList<>(2);
        scope.add(var1);
        scope.add(var2);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
       // for(Variable v: scope)
         //   System.out.println("en binyari: " +v.getName());
        if (!theAssignment.assignments.containsKey(scope.get(0))
                || !theAssignment.assignments.containsKey(scope.get(1))) {
            return true;
        }
        else if(theAssignment.assignments.containsKey(scope.get(0))
                 &&theAssignment.assignments.containsKey(scope.get(1))){
            if(theAssignment.assignments.get(scope.get(0)).equals(valueVar1))
                return theAssignment.assignments.get(scope.get(1)).equals(valueVar2);

            if(theAssignment.assignments.get(scope.get(1)).equals(valueVar2))
                return theAssignment.assignments.get(scope.get(0)).equals(valueVar1);

            return true;

        }
        return false;
    }

}
