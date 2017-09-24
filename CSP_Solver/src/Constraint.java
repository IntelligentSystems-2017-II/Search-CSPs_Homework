import java.util.ArrayList;
import java.util.List;

public interface Constraint {
    public List<Variable> getScope(); //vars involved
    public boolean satisfiedWith(Assignment theAssignment);

}
