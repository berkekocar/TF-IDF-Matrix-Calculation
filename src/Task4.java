import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IOException {
        File fileWords = new File("/Users/berkekocar/Desktop/IRWS_Assignment1/src/input4.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(fileWords));
        String line;

        //doc 1,2,3,4,5,6
        double[] Sm = new double[6];
        double[] length = new double[6];

        while ((line = br1.readLine()) != null) {
            String linePre[] = line.split("\t");
            if (linePre[0].equals("")) {
                //Titles first row of data
            } else {
                for (int i = 1; i < linePre.length; i++) {
                    //SM-> addition TW matrix
                    Sm[i - 1] += Double.parseDouble(linePre[i]);
                    //Calculating length of TW matrix
                    //length-> squareRoot(W1^2 * W2^2 * ..)
                    if (linePre[i] != "0" || linePre[i] != null) {
                        length[i - 1] = Math.pow(Double.parseDouble(linePre[i]), 2);
                    }

                }
            }
        }
        //SquareRoot part of length
        for (int i = 0; i < length.length; i++) {
            length[i] = Math.sqrt(length[i]);
        }
        br1.close();

        //cosine similarity below is used for result
        for (int i = 0; i < Sm.length; i++) {
            Sm[i] = Sm[i] / length[i];
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Document Number:");
        int fr = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Second Document Number:");
        int sec = Integer.parseInt(sc.nextLine());
        // A*B || |A|*|B|
        double similarity = Sm[fr - 1] * Sm[sec - 1] / length[fr - 1] * length[sec - 1];

        System.out.println("Doc" + fr + " " + Sm[fr - 1] + " Doc" + sec + " " + Sm[sec - 1]);
    }


}
