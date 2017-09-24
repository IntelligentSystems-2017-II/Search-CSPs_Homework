import java.util.HashMap;
import java.util.List;

public class Problem {
    //variables
    List<Variable> variables;
    List<Constraint> constraints;
    HashMap<Variable, List<Constraint>> varConst;

    public List<Variable> getVariables(){
        return variables;
    }

    public List<Constraint> getConstraints(){
        return constraints;
    }

    public List<Constraint> getConstraints(Variable var){
        return varConst.get(var);
    }

}
