import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class QueryAnalyser {
    private String START_BRACKET = "{";
    private String END_BRACKET = "}";
    private String AND = "AND";
    private String OR = "OR";
    private String BUT_NOT = "BUT NOT";
    private String AND_NOT = "AND NOT";
    private String PROX = "\\";

    ArrayList<String> substringList = new ArrayList<String>();
    String new_query = "";
    private Integer counter = 1;
    Dictionary<ArrayList<String>, String> flow = new Hashtable<ArrayList<String>, String>();

    public String queryAnalyser(String query) {

        if (query.contains(START_BRACKET)) {
            int start_index = query.indexOf(START_BRACKET);
            int end_index = query.indexOf(END_BRACKET);
            String sub_query = query.substring(start_index + 1, end_index);
            this.subqueryParser(sub_query);
            this.substringList.add(sub_query);
            String replacement = "BRACKET" + Integer.toString(counter);
            counter++;
            new_query = query.replace(START_BRACKET + sub_query + END_BRACKET, replacement);
            this.queryAnalyser(new_query);
        }
        return new_query;

    }

    public void subqueryParser(String q) {
        String w1 = "";
        String w2 = "";
        String op = "";

        if (q.contains(AND)) {
            int index = q.indexOf(AND);
            op = "MULT";
            String[] wordlist = q.split(" ");
            w1 = wordlist[index - 2];
            w2 = wordlist[index];

        } else if (q.contains(OR)) {
            int index = q.indexOf(OR);
            op = "SUM";
            String[] wordlist = q.split(" ");
            w1 = wordlist[index - 2];
            w2 = wordlist[index];

        }

        ArrayList<String> words = new ArrayList<String>();
        words.add(w1);
        words.add(w2);

        this.flow.put(words, op);


    }
}
