import java.util.ArrayList;
import java.util.List;

public class UnaryConstraintP<T> implements Constraint {
    Variable theVariable;
    List<Variable> scope;
    boolean positiveType;
    List<T> values;
    String description;

    public UnaryConstraintP(boolean positiveType,Variable v, List<T> values, String description){
        this.values = new ArrayList<>();
        theVariable = v;
        this.positiveType = positiveType;

        for(int i  = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }

        for(T t: values)
            this.values.add(t);

        scope = new ArrayList<>();
        scope.add(v);

        this.description = description;
        for(T t: this.values)
            System.out.println(t);
    }
    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {
        if(!theAssignment.getAssignments().containsKey(theVariable)){
            return true;
        }else{
            if(positiveType){
                for(T value: values){
                    if(theAssignment.getAssignments().get(theVariable).equals(value))
                        return true;
                }
                return false;
            }
            else{
                for(T value: values){
                    if(theAssignment.getAssignments().get(theVariable).equals(value))
                        return false;
                }
                return true;
            }
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
