import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegistrationNumber {
    private String regNum;
    private boolean isLettersCorrect;
    private ArrayList<Character> letters = new ArrayList<Character>();
    private String number;
    private boolean isNumberNumber;
    private boolean isNumberNotZero;

    private boolean isStateContains;
    private boolean isStateOne = true;
    private String code;
    private boolean isCodeExists = false;
    private boolean isCodeCorrect;
    private String regionName;
    private VehicleType vehicleType = null;
    private final String regexLetter = "[aAbBeEkKmMhHoOpPcCtTyYxXаАвВеЕкКмМнНоОрРсСтТуУхХ]";
    private final String regexAnyLetter = "[a-zA-Zа-яА-Я]";
    private final String regexState = "([рРrR][уУuU][сСsS])";

    public RegistrationNumber(String registrationNumber) {
        regNum = registrationNumber;
        regNum = regNum.replaceAll("\\s", "");
        checkState();
        //Проверяем является подходит ли введеный номер по структуре и количеству символов
        if(regNum.matches("......" + ".?.." ))
        {

            code = regNum.substring(6);
            checkCode();

            //Проверяем какому формату сооветсвует номер
            if (regNum.substring(0,6).matches(regexAnyLetter + "\\d\\d\\d" + regexLetter + regexAnyLetter))
            {
                //Формат Б ЧЧЧ ББ
                vehicleType = VehicleType.TYPE_1;
                number = regNum.substring(1, 4);
                checkNum("\\d\\d\\d");

                letters.add(regNum.charAt(0));
                letters.add(regNum.charAt(4));
                letters.add(regNum.charAt(5));
                checkLetters();
            }
            else if (regNum.substring(0,6).matches(regexAnyLetter + regexAnyLetter + "\\d\\d\\d\\d"))
            {
                // Формат ББ ЧЧЧЧ
                vehicleType = VehicleType.TYPE_2;
                number = regNum.substring(2, 6);
                checkNum("\\d\\d\\d\\d");

                letters.add(regNum.charAt(0));
                letters.add(regNum.charAt(1));
                checkLetters();
            } else if (regNum.substring(0,6).matches("\\d\\d\\d\\d" + regexAnyLetter + regexAnyLetter))
            {
                //Формат ЧЧЧЧ ББ
                vehicleType = VehicleType.TYPE_3;
                number = regNum.substring(0, 4);
                checkNum("\\d\\d\\d\\d");

                letters.add(regNum.charAt(4));
                letters.add(regNum.charAt(5));
                checkLetters();
            }
            writeResult();
        }
        else
            System.out.println("Не получается определить формат номера," +
                    " возможно введено неостаточно/слишком много символов");

    }

    //Проверка букв в номере на то являются ли они корректными
    private void checkLetters() {
        isLettersCorrect = true;
        for (char letter : letters)
        {
            if(!Character.toString(letter).matches(regexLetter))
            {
                isLettersCorrect = false;
                break;
            }
        }
    }

    //Проверка чисел в номере на соответсвие струтуре и не равенству нуля
    private void checkNum(String regNum) {
        if (number.matches(regNum))
        {
            isNumberNumber = true;
            checkNumZero();
        }
        else isNumberNumber = false;
    }

    private void checkNumZero()
    {
        isNumberNotZero = (Integer.valueOf(number) != 0);
    }

    //Проверяем введены ли обозначения страны, в каком количестве, а также удаляем их для простоты дальнейшей обработки
    private void checkState(){
        Pattern pattern = Pattern.compile(regexState);
        Matcher matcher = pattern.matcher(regNum);
        int countState = 0;
        int startIndex = 0;
        while(matcher.find(startIndex)){
            countState++;
            startIndex = matcher.start() + 1;
        }

        regNum = matcher.replaceAll("");
        if (countState == 0)
        {
            isStateContains = false;
            isStateOne = false;
        } else if (countState == 1) {
            isStateContains = true;
            isStateOne = true;
        } else
        {
            isStateContains = true;
            isStateOne = false;
        }
    }

    //Проверка код региона на соответвие формату и существованию
    private void checkCode()
    {
        if (code.matches("\\d?\\d\\d")) {
            isCodeCorrect = true;

            Regions[] regions = Regions.values();
            for (Regions region : regions) {
                for (String regionCode : region.getCodes()) {
                    if (code.equals(regionCode)) {
                        isCodeExists = true;
                        regionName = region.getName();
                        break;
                    }

                }
                if (isCodeExists) break;
            }
        }

    }

    //выписка результатов проверки номера
    private void writeResult()
    {
        if(isCodeExists && isLettersCorrect && isNumberNumber &&
                isNumberNotZero && ((isStateOne && isStateContains) || !isStateContains) && (vehicleType != null))
        {
            System.out.println("Номер существует в регионе " + regionName);
            System.out.println("Данный номер относится к типу: " + vehicleType.getDescription());
        }
        else
        {
            if (vehicleType == null)
                System.out.println("Не получается определить тип номера");
            else
            {
                if (!isLettersCorrect)
                    System.out.println("В номере не могут содеражаться введеные символы");
                if (!isNumberNumber)
                    System.out.println("В номере не хватает числа/чисел");
                if (!isNumberNotZero)
                    System.out.println("Номеров с номером состоящим из нулей не существует");

            }
            if (!isCodeCorrect)
                System.out.println("Код региона должен состоять только из цифр");
            else if (!isCodeExists)
                System.out.println("Данного кода региона не сушествует");
            if (!isStateOne && isStateContains)
                System.out.println("Страна введена несколько раз");
        }
    }

}
