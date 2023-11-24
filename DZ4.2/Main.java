import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    //static final String PATH = "D:\\Job\\PerformanceLab\\Java";
    //static final String FILE_NAME = "poem.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader consoleBReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleBReader.readLine();
        //File poemToRead = new File(PATH, FILE_NAME);
        File poemToRead = new File(fileName);
        BufferedReader br = new BufferedReader (new FileReader(poemToRead));
        String line;
        Queue<String> queue = new LinkedList<>();
        while((line = br.readLine())!=null){
            queue.add(line);
        }
        br.close();

        writeQueue(queue);
    }

    private static void writeQueue(Queue<String> queue) throws InterruptedException {
        Random rnd = new Random();
        while(queue.peek() != null) {
            TimeUnit.SECONDS.sleep(rnd.nextInt(3) + 1);
            System.out.println(queue.poll());
        }
    }
}