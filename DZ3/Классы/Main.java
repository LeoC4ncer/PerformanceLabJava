import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String line;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            System.out.println("Введите номер для проверки (для выхода введите exit, для подсказок введите help):");
            line = reader.readLine();
            if (line.equals("help"))
            {
                System.out.println("Любые символы можно разделить любым количеством пробелов");
                System.out.println("Струткута ввода выглядит как: {Рус} номер {рус} код региона {рус}");
                System.out.println("Страну можно ввести лишь один раз при вводе номера");
                System.out.println("Можно использовать как кириллицу, так и латиницу, а также оба регистра");
                System.out.println("Поддерживаемые форматы номера:");
                System.out.println("Б ЧЧЧ ББ");
                System.out.println("ББ ЧЧЧЧ");
                System.out.println("ЧЧЧЧ ББ");
                System.out.println("Поддерживаются коды регионов:");
                Regions[] regions = Regions.values();
                for (Regions region : regions) {
                    System.out.println(region.toString());
                }

            }
            else if(!line.equals("exit"))
                new RegistrationNumber(line);
            else
                break;

        }

    }
}