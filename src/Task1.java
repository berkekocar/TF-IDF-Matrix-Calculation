import java.io.*;
import java.util.ArrayList;

public class Task1 {

    public static void main(String[] args) throws IOException {
        //
        File file = new File("/Users/berkekocar/Desktop/IRWS_Assignment1/src/input1.txt");
        File stopwords = new File("/Users/berkekocar/Desktop/IRWS_Assignment1/src/input1.txt");


        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br1 = new BufferedReader(new FileReader(stopwords));
        ArrayList<String> stopwordList = new ArrayList<String>();
        String sw;
        while ((sw = br1.readLine()) != null) {
            String[] control;
            control = sw.split("\t");

            if (control.length > 1) {
                stopwordList.add(control[0]);
                stopwordList.add(control[1]);
            } else {
                stopwordList.add(sw);
            }

        }

        String st;
        //open output file
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/berkekocar/Desktop/IRWS_Assignment1/src/output1.txt"));

        while ((st = br.readLine()) != null) {
            st = st.replaceAll("\\p{Punct}", "");
            //Split each line by " ", change words to lowercase
            String[] words = st.split(" ");
            //Check the word if it is in stopword list. If not stopword apply stemming and add to wordList
            ArrayList<String> wordList = new ArrayList<String>();
            for (int i = 0; i < words.length; i++) {
                if (!stopwordList.contains(words[i].toLowerCase())) {
                    Stemmer stm = new Stemmer();

                    char[] w = words[i].toCharArray();
                    stm.add(w, w.length);
                    stm.stem();
                    words[i] = stm.toString();


                    writer.write(words[i].toLowerCase());
                    writer.write(' ');
                }
            }

            System.out.println(st);
            //give \n to output file
            writer.write("\n");





        }
        //close output file
        writer.close();


    }


}



