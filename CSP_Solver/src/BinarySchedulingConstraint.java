import java.util.ArrayList;
import java.util.List;

public class BinarySchedulingConstraint<T> implements Constraint {
    List<Variable> scope;
    short type;
    T val1, val2;

    public BinarySchedulingConstraint(Variable v1, Variable v2, short type){
        scope = new ArrayList<>();
        scope.add(v1);
        scope.add(v2);
        this.type = type;
    }

    public BinarySchedulingConstraint(Variable v1, Variable v2, short type, T val1, T val2){
        scope = new ArrayList<>();
        scope.add(v1);
        scope.add(v2);
        this.type = type;
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        if(theAssignment.getAssignments().containsKey(scope.get(0)) && theAssignment.getAssignments().containsKey(scope.get(1))){
            if(type == 1){ //>
                return Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))) > 0;
            }else if(type == 2){ //>=
                return (Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))) > 0) ||
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                                Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))) == 0;
            }
            else if(type == 3){ //=
                return Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))) == 0;
            }
            else if(type == 4){ //!=
                return Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))) != 0;
            }
            else if(type == 5){
                return Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(0))).compareTo(
                        Integer.valueOf((Integer) theAssignment.getAssignment(scope.get(1)))+1) != 0;
            }
        }

        return true;
    }
}
