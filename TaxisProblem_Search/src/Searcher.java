import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Searcher {
    PriorityQueue<Node> pq;
    HashSet<Node> visited;


    public Searcher(){
        pq = new PriorityQueue<>();
        visited = new HashSet<>();

    }

    public Node theAStar(Node root){
        Node tmp;
        visited.add(root);
        pq.add(root);
        while (!pq.isEmpty()){
            tmp = pq.poll();;
            tmp = expandNodes(tmp);
            if(tmp != null)
                return tmp;
        }
        return null;
    }

    public Node expandNodes(Node tmp){
        Node ex;
        //System.out.println("at expand:" + tmp.toString());
        //System.out.println("at expand:" + tmp.f());
        for(char c: Variable.domain){
            for(int i = 0; i < 4; i++){
                if(tmp.variables.get(i) == 'X'){
                    if(!tmp.variables.contains(c)){
                        ex = new Node(tmp);
                        ex.variables.set(i, c);
                        //System.out.println("added: "+ ex.toString());
                        if(ex.isOk())
                            return ex;
                        if(!visited.contains(ex)){
                          //  System.out.println("didnt have it: "+ ex.toString());
                            visited.add(ex);
                            pq.add(ex);
                        }
                    }
                }
            }

        }
        return null; //we haven't finished searching
    }
}
