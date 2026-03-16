import java.util.*;

public class Problem4_PlagiarismDetector {

    HashMap<String,Set<String>> ngrams=new HashMap<>();

    public void addDocument(String id,String text){

        String[] w=text.split(" ");

        for(int i=0;i<w.length-4;i++){

            String gram=w[i]+" "+w[i+1]+" "+w[i+2]+" "+w[i+3]+" "+w[i+4];

            ngrams.putIfAbsent(gram,new HashSet<>());
            ngrams.get(gram).add(id);
        }
    }

    public Map<String,Integer> checkDocument(String text){

        Map<String,Integer> result=new HashMap<>();

        String[] w=text.split(" ");

        for(int i=0;i<w.length-4;i++){

            String gram=w[i]+" "+w[i+1]+" "+w[i+2]+" "+w[i+3]+" "+w[i+4];

            if(ngrams.containsKey(gram)){

                for(String doc:ngrams.get(gram)){
                    result.put(doc,result.getOrDefault(doc,0)+1);
                }

            }
        }

        return result;
    }

    public static void main(String[] args){

        Problem4_PlagiarismDetector obj=new Problem4_PlagiarismDetector();

        obj.addDocument("doc1","this is a plagiarism detection system example");

        System.out.println(obj.checkDocument("this is a plagiarism detection system"));
    }
}
