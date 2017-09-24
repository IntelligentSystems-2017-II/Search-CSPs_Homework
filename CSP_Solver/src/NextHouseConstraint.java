import java.util.ArrayList;
import java.util.List;

public class NextHouseConstraint<T> implements Constraint {
    List<Variable> scope;
    String description;
    T expectedValue1;
    T expectedValue2;

    public NextHouseConstraint(Variable v1, Variable v2, T expectedValue1, T expectedValue2, String description){
        scope = new ArrayList<>(4);
        scope.add(v1); //previous color
        scope.add(v2); //this color
        //scope.add(v3); //previous location
        //scope.add(v4); //this location
        this.expectedValue1 = expectedValue1;
        this.expectedValue2 = expectedValue2;

        this.description = description;
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public boolean satisfiedWith(Assignment theAssignment) {

        if(theAssignment.assignments.containsKey(scope.get(1))){
            if(theAssignment.assignments.get(scope.get(1)).equals(expectedValue2)) {//green
                if(theAssignment.assignments.get(scope.get(0)) != null)
                    return theAssignment.assignments.get(scope.get(0)).equals(expectedValue1);
                return true;
            }
        }

        if(theAssignment.assignments.containsKey(scope.get(0))) {
            if(theAssignment.assignments.get(scope.get(0)).equals(expectedValue1)) {//ivory
                if(theAssignment.assignments.get(scope.get(1))!= null)
                    return theAssignment.assignments.get(scope.get(1)).equals(expectedValue2);
                return true;
            }
        }

        return true;
    }
}
