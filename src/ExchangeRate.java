import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExchangeRate {
    private static Map<String, Double> exchangeRates = new HashMap<>(){
        {
        put("RUB", 1.0);
        put("EUR", 104.4);
        put("USD", 96.09);
        put("KZT", 0.2);
        put("CNY", 13.47);
        }
    };
    private static Scanner scanner = new Scanner(System.in, "Cp866");
    private static String input = "";

    private  static double convert(String fromCurrency, String toCurrency, double amount) {
        double amountInUSD = amount * exchangeRates.get(fromCurrency);
        return amountInUSD / exchangeRates.get(toCurrency);
    }
    private static void ExchangeLogic()
    {
        String currency = String.join(", ", exchangeRates.keySet());
        double amount = 0;

        System.out.println(MessageFormat.format("Введите валюту для конвертации ({0}): ", currency));
        String fromCurrency = scanner.nextLine().toUpperCase();
        if (!exchangeRates.containsKey(fromCurrency))
        {
            System.out.println("Указанной валюты нет в списке! Повторите попытку");
            ExchangeLogic();
            return;
        }

        System.out.println(MessageFormat.format("Введите валюту, в которую хотите конвертировать ({0}): ", currency));
        String toCurrency = scanner.nextLine().toUpperCase();
        if (!exchangeRates.containsKey(toCurrency))
        {
            System.out.println("Указанной валюты нет в списке! Повторите попытку");
            ExchangeLogic();
            return;
        }

        if (fromCurrency.equals(toCurrency))
        {
            System.out.println("Нет смысла конвертировать валюту в саму себя! Повторите попытку");
            ExchangeLogic();
            return;
        }

        System.out.println("Введите сумму для конвертации: ");
        
        while (true) { 
            try
            {
                amount = Double.parseDouble(scanner.nextLine());
                break;
            } catch(Exception e) 
            {
                System.out.println("Некорректно указана сумма для конвертации (необходимо ввести число, возможно с плавающей точкой)");
                continue;
        }
        }
        double convertedAmount = convert(fromCurrency, toCurrency, amount);
        System.out.printf("Конвертированная сумма: %.2f %s%n", convertedAmount, toCurrency);
        System.out.println("Хотите повторно провести конвертацию? Напишите - да, для продолжения, любой другой вариант - для завершения работы программы");

        input = scanner.nextLine();
        if("да".equals(input.toLowerCase()))
        {
            ExchangeLogic();
        }
    }
    private static void SetNewExchange()
    {
        exchangeRates.clear();
        String nameOfCurrency = "";
        double valueOfCurrency = 0;
        System.out.println("Первая введенная валюта будет расцениваться как основная, остальные курсы следует указывать отталкиваясь от нее");
        while (true) 
            { 
                System.out.println("Укажите название 1 валюты (в сокращенном формате 3 символов)");
                nameOfCurrency = scanner.nextLine();
                if (nameOfCurrency.length() != 3)
                {
                    System.out.println("Некорректно указано название");
                    continue;
                }
                break;
            }
        exchangeRates.put(nameOfCurrency.toUpperCase(), 1.0);
        for (int i = 2; i < 6;i++)
        {
            while (true) 
            { 
                System.out.println(MessageFormat.format("Укажите название {0} валюты (в сокращенном формате 3 символов)",i));
                nameOfCurrency = scanner.nextLine();
                if (nameOfCurrency.length() != 3)
                {
                    System.out.println("Некорректно указано название");
                    continue;
                }
                System.out.println(MessageFormat.format("Укажите курс {0} валюты относительно первой",i));
                try
                {
                    valueOfCurrency = Double.parseDouble(scanner.nextLine());
                } catch(Exception e) 
                {
                    System.out.println("Некорректно указан курс валюты (курс валюты - число, возможно с плавающей точкой)");
                    continue;
                }
                break;
            }
            exchangeRates.put(nameOfCurrency.toUpperCase(), valueOfCurrency);
        }
    }
    private static void ChosingVariant()
    {
        while (true) 
        { 
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    return;
                case "2":
                    SetNewExchange();
                    return;
                default:
                    System.out.println("Укажите корректный вариант");
            }  
        }
        
    }
    public static void main(String[] args) 
    {
        System.out.println("Выберите вариант по которому вы хотите конвертировать валюту:\n1. Константные значения заложенные разработчиком\n2. Вручную задать валюты и их значения\n(Введите номер выбранного варината)");
        ChosingVariant();
        System.out.println(exchangeRates);
        ExchangeLogic();
    }
}