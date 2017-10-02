import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeConstraint implements Constraint {
    List<Variable> scope;
    HashMap<String, Integer> times; //processors
    int deadline;

    public TimeConstraint(int deadline, List<Variable> involved){
        scope = new ArrayList<>();
        this.times = new HashMap<>();
        for(String s: times.keySet())
            this.times.put(s, times.get(s));

        this.deadline = deadline;
        for(Variable v: involved)
            scope.add(v);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        TasksAssignment assignment = (TasksAssignment) theAssignment;

        /*for(Object v: assignment.getAssignments().keySet()){
            //Variable var = (Variable)v;
            //System.out.println("Assignment for v:" + var.getName() +":"+theAssignment.getAssignments().get(v));
        //    String f = (String) theAssignment.getAssignments().get(v);
          //  System.out.println("times for :" +f + ":"+ times.get(f));
            //if(times.get(theAssignment.getAssignments().get(v)) >= deadline)
              //  return false;
            if(assignment.procLengths.get(assignment.getAssignments().get(v)) > deadline)
                return false;
        }*/

        int procLength;
        for(String s: assignment.processors.keySet()){
            procLength = 0;
            for(Variable v: assignment.processors.get(s)){
                procLength += ProcessorsProblem.tasksLength.get(v);
            }
            if(procLength > deadline)
                return false;
        }

        return true;
    }
}
