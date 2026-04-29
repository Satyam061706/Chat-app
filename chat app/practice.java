
import java.util.*;

public class practice {
    public static void main(String args[]){
        List<String> list=new ArrayList<>();
        list.add("john vii");
        list.add("david v");
        list.add("john v");
        list.add("henry vi");
        list.add("henry iv");
        Collections.sort(list);
        System.out.println(list);
    }
}
