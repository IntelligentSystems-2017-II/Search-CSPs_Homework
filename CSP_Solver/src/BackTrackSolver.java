import java.util.List;

public class BackTrackSolver {
    public Assignment solve(Problem csp) {
        return recursiveBackTrackingSearch(csp, new Assignment());
    }

    private Assignment recursiveBackTrackingSearch(Problem csp,
                                                   Assignment assignment) {
        Assignment result = null;
        if (assignment.isComplete(csp.getVariables())) {
            result = assignment;
        } else {
            Variable var = selectUnassignedVariable(assignment, csp);
            for (Object value : orderDomainValues(var, assignment, csp)) {
                assignment.setAssignment(var, value);
                //fireStateChanged(assignment, csp);
                if (assignment.isConsistent(csp.getConstraints(var))) {
                    //DomainRestoreInfo info = inference(var, assignment, csp);
                    //if (!info.isEmpty())
                      //  fireStateChanged(csp);
                    //if (!info.isEmptyDomainFound()) {
                      //  result = recursiveBackTrackingSearch(csp, assignment);
                        //if (result != null)
                          //  break;

                    //assignment.setAssignment(var, value);
                    result = recursiveBackTrackingSearch(csp, assignment);
                    if(result != null){
                        break;
                    }
                    //assignment.removeAssignment(var);
                   // info.restoreDomains(csp);
                }
                assignment.removeAssignment(var);
            }
        }
        return result;
    }

    protected Variable selectUnassignedVariable(Assignment assignment, Problem csp) {
        for (Variable var : csp.getVariables()) {
            if (!(assignment.hasAssignmentForVar(var)))
                return var;
        }
        return null;
    }

    protected Iterable<?> orderDomainValues(Variable var,
                                            Assignment assignment, Problem csp) {
        //return csp.getVariables();
        List<Variable> vars = csp.getVariables();
        int index = vars.indexOf(var);
        return vars.get(index).getDomain();
    }
}
