public class TaxisMain {
    public static void main(String[] args) {

        Taxis tp = new Taxis();
        Assignment theAssignment1 = new Assignment();
        BackTrackSolver solver = new BackTrackSolver();
        theAssignment1 = solver.solve(tp, theAssignment1);

        if(theAssignment1 != null)
            System.out.println(theAssignment1.toString());
        else
            System.out.println("No se encontró respuesta");
    }
}
