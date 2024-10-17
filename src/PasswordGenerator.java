import java.util.HashMap;
import java.util.Map;

public class PasswordGenerator
{
    public static void main()
    {
        Map<String,String> numbers = new HashMap <String,String>() {
            {
                put("48","9");
            }
        };
        Map<String,String> digit = new HashMap <String,String>(){
            {
                put("33","14");
                put("58","6");
                put("91","5");
                put("123","3");
            }
        };
        Map<String,String> letterUp = new HashMap <String,String>(){  
            {
                put("65","25");
            }
        };
        Map<String,String> letterDown = new HashMap <String,String>(){
            {
                put("97","25");
            }
        };

        

        digit.put("33","14");


        for (int i = 0; i <= 25; i++) 
        {
            int decimalCodePoint = 97 + i;
            char[] charArray = Character.toChars(decimalCodePoint);
            String digit = new String(charArray);
            System.out.println("Код Unicode: " + Integer.toHexString(decimalCodePoint) + "  Символ: " + digit);
        }
    }
}