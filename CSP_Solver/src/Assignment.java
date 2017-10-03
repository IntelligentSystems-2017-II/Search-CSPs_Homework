import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assignment<T> {
    List<Variable> variables;
    private HashMap<Variable, T> assignments;

    //returns blank assignment
    public Assignment(){
        variables = new ArrayList<>();
        setAssignments(new HashMap<Variable, T>());
    }

    public T getAssignment(Variable theVariable){
        return getAssignments().get(theVariable);
    }

    public void setAssignment(Variable theVariable, T theValue){
        if(!getAssignments().containsKey(theVariable))
            variables.add(theVariable);
        getAssignments().put(theVariable, theValue);
    }

    public boolean isComplete(List<Variable> vars){
        for(Variable var: vars)
            if(!hasAssignmentForVar(var)){
                return false;
            }
        return true;
    }

    public boolean hasAssignmentForVar(Variable var) {
        return getAssignments().get(var) != null;
    }

    public void removeAssignment(Variable var) {
        if (hasAssignmentForVar(var)) {
            variables.remove(var);
            getAssignments().remove(var);
        }
    }


    public boolean isConsistent(List<Constraint> constraints){
        for(Constraint constraint: constraints){
            if(!constraint.satisfiedWith(this))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n{");

        for(Variable var: variables){
            sb.append("\n"+ var.getName() + ": " + getAssignments().get(var));
        }

        sb.append("  }");
        return sb.toString();
    }

    public HashMap<Variable, T> getAssignments() {
        return assignments;
    }

    public void setAssignments(HashMap<Variable, T> assignments) {
        this.assignments = assignments;
    }
}
