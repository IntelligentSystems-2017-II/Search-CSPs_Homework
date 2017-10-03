public class SchedulingMain {
    public static void main(String[] args) {
        Problem problem = new SchedulingProblem();
        //Assignment theAssignment = new Assignment();
        Assignment theAssignment = new SchedulingAssignment();
        BackTrackSolver solver = new BackTrackSolver();
        theAssignment = solver.solve(problem, theAssignment);

        if(theAssignment == null)
            System.out.println("No hay solucion");
        else
            System.out.println(theAssignment.toString());
    }
}
