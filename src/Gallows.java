import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gallows {

    private static ArrayList<String> variantsWords = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in, "Cp866");

    private static int Life = 0;

    private static void chosingTheme()
    {
        System.out.println(" Выберите тему для игры:\n\nприрода\n\nгеография\n\nмузыка\n\nНапшиите в консоль понравившийся вариант.\n");
        
        String theme = scanner.nextLine();
        
        variantsWords.clear();
        switch (theme) {
            case "природа":
                variantsWords.add("дерево");
                variantsWords.add("трава");
                variantsWords.add("море");
                variantsWords.add("река");
                variantsWords.add("гора");
                break;
            case "география":
                variantsWords.add("азия");
                variantsWords.add("европа");
                variantsWords.add("америка");
                variantsWords.add("австралия");
                variantsWords.add("африка");
                break;
            case "музыка":
                variantsWords.add("шансон");
                variantsWords.add("джаз");
                variantsWords.add("рок");
                variantsWords.add("поп");
                variantsWords.add("рэп");
                break;
            default:
                System.out.println("\n Неверно указана тема, повторите попытку\n");

                System.out.println(theme);

                chosingTheme();
                break;
            
        }
    }

    private static void outConsol(){
        
        StringBuilder drawing = new StringBuilder();

        switch (Life)
        {
            case 1:
                drawing.append("_____________________\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
            case 2:
                drawing.append("_____________________\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      | ___\n");
                drawing.append("  |      \\(-_-)\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
            case 3:
                drawing.append("_____________________\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      | ___\n");
                drawing.append("  |      \\(-_-)\n");
                drawing.append("  |        / \\ \n");
                drawing.append("  |        | |\n");
                drawing.append("  |        \\ /\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
            case 4:
                drawing.append("_____________________\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      | ___\n");
                drawing.append("  |      \\(-_-)\n");
                drawing.append("  |        / \\ \n");
                drawing.append("  |     ._/| |\\_.\n");
                drawing.append("  |        \\ /\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
            case 5:
                drawing.append("_____________________\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      | ___\n");
                drawing.append("  |      \\(-_-)\n");
                drawing.append("  |        / \\ \n");
                drawing.append("  |     ._/| |\\_.\n");
                drawing.append("  |        \\ /\n");
                drawing.append("  |        / \\\n");
                drawing.append("  |      _/   \\_\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
            default: 
                drawing.append("_____________________\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("  |\n");
                drawing.append("__|_____");
                break;
        }  
        System.out.println(drawing.toString()); 
    }
    private static String RandomVariant()
    {
        Random random = new Random();
        int randomCount = random.nextInt(variantsWords.size());
        return variantsWords.get(randomCount);
    }
    public static void main()
    {
        chosingTheme();
        String nowVariantOfGame = RandomVariant();

        int lenOfVariant = nowVariantOfGame

        outConsol();
    }
    
}
