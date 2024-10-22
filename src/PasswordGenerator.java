import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator
{
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in, "Cp866");

    private static Map<Integer,Integer> numbers = new HashMap <>() {
        {
            put(48,9);
        }
    };
    private static Map<Integer,Integer> digit = new HashMap <>(){
        {
            put(33,14);
            put(58,6);
            put(91,5);
            put(123,3);
        }
    };
    private static Map<Integer,Integer> letterUp = new HashMap <>(){  
        {
            put(65,25);
        }
    };
    private static Map<Integer,Integer> letterDown = new HashMap <>(){
        {
            put(97,25);
        }
    };

    private static String GetDigitForNewPassword(Map<Integer,Integer> type)
    {
        Integer randomKey = GetRandomKey(type);
        int randomValue = random.nextInt(type.get(randomKey));
        int decimalCodePoint = randomKey + randomValue;
        char[] charArray = Character.toChars(decimalCodePoint);
        String newDigit = new String(charArray);
        return  newDigit;
    }

    private static Integer GetRandomKey(Map<Integer, Integer> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

    private static String GeneratePassword (int length)
    {
        List<String> readyPassword = new ArrayList<>();
        readyPassword.add(GetDigitForNewPassword(numbers));
        readyPassword.add(GetDigitForNewPassword(digit));
        readyPassword.add(GetDigitForNewPassword(letterUp));
        readyPassword.add(GetDigitForNewPassword(letterDown));

        while (readyPassword.size() < length) {
            int randomType = random.nextInt(4);
            
            switch (randomType) {
                case 0: 
                    readyPassword.add(GetDigitForNewPassword(numbers));
                    break;
                case 1: 
                    readyPassword.add(GetDigitForNewPassword(digit));
                    break;
                case 2: 
                    readyPassword.add(GetDigitForNewPassword(letterUp));
                    break;
                case 3: 
                    readyPassword.add(GetDigitForNewPassword(letterDown));
                    break;
            }
        }

        Collections.shuffle(readyPassword);

        String resultString = String.join("", readyPassword);
        
        return resultString;
    }

    private static void LogicTerminal()
    {
        System.out.println("\nВведите длину желаемого пароля (от 8 до 12)\n");
        int lenghtOfPassword = 0;
        String input = "";
        while (true) 
        { 
            input = scanner.next();
            try 
            {
                lenghtOfPassword = Integer.parseInt(input);
                if (lenghtOfPassword > 7 & lenghtOfPassword <13)
                {
                    break;
                }
                else
                {
                    throw new Exception();
                }
            } 
            catch (Exception e) 
            {
                System.out.println("\nВведите корректное число, от 8 до 12!!!\n");
            }
            
        }
        String password = GeneratePassword(lenghtOfPassword);

        System.out.println("\nВаш сгенерированный пароль " + password + "\n");

        System.out.println("Хотите повторно сгенерировать пароль? Напишите - да, для генерации, любой другой вариант - для завершения работы программы\n");

        input = scanner.next();

        if("да".equals(input.toLowerCase()))
        {
            LogicTerminal();
        }
    }

    public static void main()
    {
        LogicTerminal();
    }
}