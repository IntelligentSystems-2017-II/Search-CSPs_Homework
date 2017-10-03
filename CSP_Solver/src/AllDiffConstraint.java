import java.util.ArrayList;
import java.util.List;

public class AllDiffConstraint<T> implements Constraint {
    String description;
    List<Variable> scope;

    public AllDiffConstraint(List<Variable> involvedVars, String description){
        scope = new ArrayList<>(involvedVars.size());
        for(Variable var: involvedVars)
            scope.add(var);

        this.description = description;
    }
    String getDescription(){
        return description;
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        List<T> values = new ArrayList<>(scope.size());
        for(Variable var: scope){
            if(theAssignment.getAssignments().get(var) != null)
                values.add((T) theAssignment.getAssignments().get(var));
        }

        for(int i = 0; i < values.size(); i++){
            for(int j = i+1; j < values.size(); j++){

                if(values.get(i).equals(values.get(j))){
                    return false;
                }

            }
        }
        return true;
    }
}
