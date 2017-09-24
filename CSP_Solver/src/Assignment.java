import com.sun.xml.internal.fastinfoset.util.ValueArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assignment<T> {
    List<Variable> variables;
    HashMap<Variable, T> assignments;

    //returns blank assignment
    public Assignment(){
        variables = new ArrayList<>();
        assignments = new HashMap<Variable, T>();
    }

    public T getAssignment(Variable theVariable){
        return assignments.get(theVariable);
    }

    public void setAssignment(Variable theVariable, T theValue){
        if(!assignments.containsKey(theVariable))
            variables.add(theVariable);
        assignments.put(theVariable, theValue);
    }

    public boolean isComplete(List<Variable> vars){
        for(Variable var: vars)
            if(!hasAssignmentForVar(var)){
                return false;
            }
        return true;
    }

    public boolean hasAssignmentForVar(Variable var) {
        return assignments.get(var) != null;
    }

    public void removeAssignment(Variable var) {
        if (hasAssignmentForVar(var)) {
            variables.remove(var);
            assignments.remove(var);
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
        sb.append("{");

        for(Variable var: variables){
            sb.append("\n"+ var.getName() + ": " + assignments.get(var));
        }

        sb.append("}");
        return sb.toString();
    }
}
