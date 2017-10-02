import java.util.ArrayList;
import java.util.List;


public class BinaryConstraintP<T> implements Constraint {
    short type; //1--> positive, 2--> negative, 3--> simultaneous
    List<Variable> scope;
    String description;

    T val1, val2; //for simultaneously assignment constraint

    public BinaryConstraintP(short type, Variable v1, Variable v2, String description){
        scope = new ArrayList<>(2);
        this.type = type;
        scope.add(v1);
        scope.add(v2);
        this.description = description;
    //    this.processor = processor;
    }

    public BinaryConstraintP(short type, Variable v1, Variable v2, T value1, T value2, String description){
        scope = new ArrayList<>(2);
        this.type = type;
        scope.add(v1);
        scope.add(v2);
        val1 = value1;
        val2 = value2;
        this.description = description;
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        if(theAssignment.getAssignments().containsKey(scope.get(0)) && theAssignment.getAssignments().containsKey(scope.get(1))){
            T value1 = (T) theAssignment.getAssignment(scope.get(0));
            T value2 = (T) theAssignment.getAssignment(scope.get(1));

            if(type == 1) //2 tasks must be assigned to same processor
                return value1.equals(value2);
            else if(type == 2) //2 tasks cannot be assigned to same processor
                return !value1.equals(value2);
            else{ //simultaneous constraint
                if(value1.equals(val1))
                    return !value2.equals(val2);
                if(value2.equals(val2))
                    return !value1.equals(val1);
            }
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(description + "\n");
        builder.append("variables involved:");
        for(Variable v: scope)
            builder.append(v.getName() + ", ");



        return builder.toString();
    }

}
