import java.util.*;

public class TasksAssignment extends Assignment {
    //HashMap<String, Integer> procLengths;
    int deadline;
    Variable lastAssigned;
    String lastProcessor;
    HashMap<String, List<Variable>> processors;


    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }


    public TasksAssignment(){
        super();
        //procLengths = new HashMap<>();
        this.deadline = ProcessorsProblem.deadline;
        processors = new HashMap<>();
    }

    @Override
    public void setAssignment(Variable theVariable, Object theValue) {
        System.out.println("new assigment" + theVariable.getName()+ "," + theValue.toString());
        super.setAssignment(theVariable, theValue);
        lastAssigned = theVariable;
        lastProcessor = theValue.toString();
/*
        int lengthSoFar = 0;
        if(procLengths.containsKey(theValue))
            lengthSoFar = procLengths.get(theValue);

        lengthSoFar += ProcessorsProblem.tasksLength.get(theVariable);
        procLengths.put((String) theValue, lengthSoFar);

        for(String s: procLengths.keySet()){
            System.out.println("processor: " + s + "l: " + procLengths.get(s));
        }
        */
        List<Variable> vars;

        if(!processors.containsKey(theValue.toString()))
            vars = new LinkedList<>();
        else
            vars = processors.get(theValue.toString());

        vars.add(theVariable);

        processors.put(theValue.toString(), vars);

        for(String s: processors.keySet()){
            for(Variable v: processors.get(s)){
                System.out.println("processor: " + s + "var: " + v.getName() + " l:" + ProcessorsProblem.tasksLength.get(v));
            }
        }
    }


    @Override
    public void removeAssignment(Variable var) {
        super.removeAssignment(var);

        List<Variable> vars;

        for(String s: processors.keySet()){
         vars = processors.get(s);
         if(vars != null){
             vars.remove(var);
         }
        }
    }

    @Override
    public boolean isConsistent(List list) {
        /*boolean consistent =super.isConsistent(list);
        if(!consistent){
            reverseAssignedLength();
        }*/
        //return consistent;
        return super.isConsistent(list);
    }


    /*public void reverseAssignedLength(){
        int wL = procLengths.get(lastProcessor);
        wL -= ProcessorsProblem.tasksLength.get(lastAssigned);
        procLengths.put(lastProcessor, wL);
    }

    public boolean validLenghts(){
        for(String s: procLengths.keySet()){
            if(procLengths.get(s) > deadline)
                return false;
        }

        return true;
    }
*/
}
