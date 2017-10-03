import java.util.List;

public class SchedulingAssignment extends Assignment {

    @Override
    public void setAssignment(Variable theVariable, Object theValue) {
        super.setAssignment(theVariable, theValue);
        System.out.print("New assignment:");
        System.out.print(" Var: " + theVariable.getName());
        System.out.print(" value: "+ theValue.toString() + "  ");
    }

    @Override
    public boolean isConsistent(List list) {
        boolean b = super.isConsistent(list);
        if(!b)
            System.out.println("FAILURE");
        return b;
    }
}
