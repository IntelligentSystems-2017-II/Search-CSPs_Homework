import java.util.ArrayList;
import java.util.List;

public class Variable<T> {
    private String name;
    private List<T> domain; //possible values

    public Variable(String name, List<T> domain){
        this.name = name;
        this.domain = new ArrayList<>();
        for(T t: domain)
            this.domain.add(t);
    }

    public String getName() {
        return name;
    }

    public List<T> getDomain() {
        return domain;
    }

    public T deleteFromDomain(T theElement){
        int index = domain.indexOf(theElement);
        return (index != -1)? domain.remove(index): null;
    }
}
