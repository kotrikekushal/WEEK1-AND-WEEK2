import java.util.*;

public class Problem4_PlagiarismDetector {

    HashMap<String,Set<String>> map=new HashMap<>();

    public void addDoc(String id,String text){

        String[] w=text.split(" ");

        for(int i=0;i<w.length-4;i++){

            String gram=w[i]+" "+w[i+1]+" "+w[i+2]+" "+w[i+3]+" "+w[i+4];

            map.putIfAbsent(gram,new HashSet<>());

            map.get(gram).add(id);
        }
    }

    public Map<String,Integer> check(String text){

        Map<String,Integer> res=new HashMap<>();

        String[] w=text.split(" ");

        for(int i=0;i<w.length-4;i++){

            String gram=w[i]+" "+w[i+1]+" "+w[i+2]+" "+w[i+3]+" "+w[i+4];

            if(map.containsKey(gram)){

                for(String d:map.get(gram)){
                    res.put(d,res.getOrDefault(d,0)+1);
                }

            }

        }

        return res;
    }

    public static void main(String[] args){

        Problem4_PlagiarismDetector obj=new Problem4_PlagiarismDetector();

        obj.addDoc("doc1","this is a simple plagiarism detection system example");

        System.out.println(obj.check("this is a simple plagiarism detection system"));
    }
}
