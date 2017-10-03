import java.util.ArrayList;
import java.util.List;

public class NextHouseConstraint<T> implements Constraint {
    List<Variable> scope;
    String description;
    T expectedValue1;
    T expectedValue2;
    T el1, el2;

    public NextHouseConstraint(Variable v1, Variable v2, T expectedValue1, T expectedValue2, String description){
        scope = new ArrayList<>(4);
        //scope.add(); //left location
        //scope.add();//right location
        scope.add(v1); //previous color
        scope.add(v2); //this color
        //scope.add(v3); //previous location
        //scope.add(v4); //this location
        this.expectedValue1 = expectedValue1;
        this.expectedValue2 = expectedValue2;

        this.description = description;
    }

    public NextHouseConstraint(Variable l1, Variable l2, Variable v1, Variable v2, T el1, T el2, T ev1, T ev2, String description){
        this.description = description;
        scope.add(l1); //left location
        scope.add(l2);//right location
        scope.add(v1); //left
        scope.add(v2); //right

        this.el1 = el1;
        this.el2 = el2;
        this.expectedValue1 = ev1;
        this.expectedValue2 = ev2;
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

        if(theAssignment.getAssignments().containsKey(scope.get(1))){
            if(theAssignment.getAssignments().get(scope.get(1)).equals(expectedValue2)) {//green
                if(theAssignment.getAssignments().get(scope.get(0)) != null)
                    return theAssignment.getAssignments().get(scope.get(0)).equals(expectedValue1);
                //return true;
            }
        }

        if(theAssignment.getAssignments().containsKey(scope.get(0))) {
            if(theAssignment.getAssignments().get(scope.get(0)).equals(expectedValue1)) {//ivory
                if(theAssignment.getAssignments().get(scope.get(1))!= null)
                    return theAssignment.getAssignments().get(scope.get(1)).equals(expectedValue2);
                //return true;
            }
        }

/*       if(theAssignment.getAssignments().containsKey(scope.get(0)) && theAssignment.getAssignments().containsKey(scope.get(1))
               && theAssignment.getAssignments().containsKey(scope.get(2)) && theAssignment.getAssignments().containsKey(scope.get(3))){
           if(theAssignment.getAssignments().get(scope.get(2)).equals(expectedValue1)){
               if(theAssignment.getAssignments().get(0).equals(el1)){
                   if(theAssignment.getAssignments().get(1).equals(el2)){
                       return theAssignment.getAssignments().get(3).equals(expectedValue2);
                   }
               }
           }
           else if(theAssignment.getAssignments().get(scope.get(3)).equals(expectedValue2)){
               if(theAssignment.getAssignments().get(1).equals(el2)){
                   if(theAssignment.getAssignments().get(0).equals(el1)){
                       return theAssignment.getAssignments().get(2).equals(expectedValue1);
                   }
               }
           }
       }*/

       return true;
    }
}
