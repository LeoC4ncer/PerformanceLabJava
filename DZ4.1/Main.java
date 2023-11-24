import java.io.*;

public class Main {
    //static final String PATH = "D:\\Job\\PerformanceLab\\Java";
    //static final String FILE_NAME = "poem.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader consoleBReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = consoleBReader.readLine();

        //File poemToRead = new File(PATH, FILE_NAME);
        File poemToRead = new File(fileName);

        BufferedReader br = new BufferedReader (new FileReader(poemToRead));
        String line;
        int paragraph = 1;
        BufferedWriter bw = bufferedWriter(paragraph);
        while((line = br.readLine())!=null){

            if (line.isEmpty())
            {
                paragraph++;
                bw.close();
                bw = bufferedWriter(paragraph);
            }
            else
            {
                bw.write(line + '\n');
            }

        }
        bw.close();
        br.close();
    }

    private static BufferedWriter bufferedWriter(int paragraph) throws IOException {
        //File paragraphToWrite = new File(PATH, ("part" + paragraph + ".txt"));
        File paragraphToWrite = new File("part" + paragraph + ".txt");
        return new BufferedWriter(new FileWriter(paragraphToWrite));
    }

}