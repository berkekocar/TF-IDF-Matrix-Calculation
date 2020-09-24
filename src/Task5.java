public class Task5 {
    public static void main(String[] args) {
        String query = "{a AND b} OR {b OR c} AND ";
        QueryAnalyser qa = new QueryAnalyser();
        String substringList= "";
        substringList = qa.queryAnalyser(query);
        System.out.println(qa.flow);


    }
}
