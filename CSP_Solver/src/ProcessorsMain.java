import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProcessorsMain {
    public static void main(String[] args) throws IOException {
        int n, m, d;
        Scanner scanner = new Scanner(System.in);
        List<String> tasks;
        List<Integer> tasksLenghts;
        List<String> processors;
        HashMap<Variable, List<String>> unaryConstraintsIn = new HashMap<>();
        HashMap<Variable, List<String>> unaryConstraintsEx = new HashMap<>();
        HashMap<Variable, Variable> binaryConstraintsIn  = new HashMap<>();
        HashMap<Variable, Variable> binaryConstraintsEx  = new HashMap<>();
        HashMap<HashMap<Variable, Variable>, List<String>> binaryNotSimul = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Variable> varNames = new HashMap<>();


        System.out.println("Ingrese la cantidad de tareas");
        n = scanner.nextInt();
        tasksLenghts = new ArrayList<>(n);
        tasks = new ArrayList<>(n);


        System.out.println("Ingrese la duracion maxima");
        d = scanner.nextInt();

        System.out.println("Ingrese la tarea T y su duracion");
        //String name;
        for(int i = 0; i < n; i++){
            //name = scanner.next();
            tasks.add(scanner.next());
            tasksLenghts.add(scanner.nextInt());
        }



        System.out.println("Ingrese la cantidad de procesadores");
        m = scanner.nextInt();
        processors = new ArrayList<>(m);

        System.out.println("Ingrese los valores de los procesadores");
        for(int i = 0; i < m; i++)
            processors.add(scanner.next());

        for(String s: tasks)
            varNames.put(s, new Variable(s, processors));


        System.out.println("Ingrese cantidad de restricciones unarias inclusivas");
        int qr = scanner.nextInt();
        String line;
        String[] splited;
        List<String> values;
        for(int i  = 1; i <= qr; i++){

            //System.out.println("Ingrese la restriccion");
            line = bf.readLine();
            //System.out.println(line);
            splited = line.split(" ");
            //System.out.println(splited.length);
            values = new ArrayList<>(splited.length-1);
            for(int j = 1; j < splited.length;j++)
                values.add(splited[j]);

            unaryConstraintsIn.put(varNames.get(splited[0]), values);

        }

        System.out.println("Ingrese cantidad de restricciones unarias exclusivas");
        qr = scanner.nextInt();

        for(int i  = 1; i <= qr; i++){
            System.out.println("Ingrese la restriccion");
            line = bf.readLine();
            splited = line.split(" ");
            values = new ArrayList<>(splited.length-1);

            for(int j = 1; j < splited.length;j++)
                values.add(splited[j]);

            unaryConstraintsEx.put(varNames.get(splited[0]), values);
        }
        //System.out.println("ex unanry size:" + unaryConstraintsEx.size());
        System.out.println("Ingrese cantidad de restricciones binarias iguales");
        qr = scanner.nextInt();

        for(int i  = 1; i <= qr; i++){
            binaryConstraintsIn.put(varNames.get(scanner.next()), varNames.get(scanner.next()));
        }


        System.out.println("Ingrese cantidad de restricciones binarias no iguales");
        qr = scanner.nextInt();

        for(int i  = 1; i <= qr; i++){
            binaryConstraintsEx.put(varNames.get(scanner.next()), varNames.get(scanner.next()));
        }

        System.out.println("Ingrese cantidad de restricciones binarias no simultaneas");
        qr = scanner.nextInt();


        HashMap<Variable, Variable> vars = new HashMap<>();
        for(int i  = 1; i <= qr; i++){
            splited = bf.readLine().split(" ");
            vars.put(varNames.get(splited[0]), varNames.get(splited[1]));

            values = new ArrayList<>();
            for(int k = 2; k < splited.length; k++)
                values.add(splited[k]);

            binaryNotSimul.put(vars, values);
        }

        Problem problem = new ProcessorsProblem(n, m, d,
                varNames, tasksLenghts, unaryConstraintsIn,
                unaryConstraintsEx, binaryConstraintsIn, binaryConstraintsEx, binaryNotSimul);

        Assignment theAssignment = new TasksAssignment();

        BackTrackSolver solver = new BackTrackSolver();
        theAssignment = solver.solve(problem,theAssignment);

        if(theAssignment != null)
            System.out.println(theAssignment.toString());
        else
            System.out.println("No hay solucion");
    }
}
