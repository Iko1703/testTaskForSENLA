import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gallows {

    private static ArrayList<String> variantsWords = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in, "Cp866");

    private static int stickForDrawEnd = 0;
    private static int i = 0;

    private static void ChosingTheme()
    {
        System.out.println(" Выберите тему для игры:\n\nприрода\n\nгеография\n\nмузыка\n\nНапишите в консоль понравившийся вариант.\n");
        String theme = scanner.nextLine();
        theme = theme.toLowerCase();
        theme = theme.trim();
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
                ChosingTheme();
                return;           
        }
        System.out.println("\nВыбранная тема - " + theme + "\n\nУдачи!");
    }

    private static String PictureGenerate(int life)
    {
        StringBuilder drawing = new StringBuilder();
        switch (life)
        {
            case 1:
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                drawing.append("  |      |\n");
                stickForDrawEnd = 8;
                break;
            case 2:
                drawing.append(PictureGenerate(1));
                drawing.append("  |      \\(-_-)\n");
                stickForDrawEnd = 7;
                break;
            case 3:
                drawing.append(PictureGenerate(2));
                drawing.append("  |        / \\ \n");
                drawing.append("  |        | |\n");
                drawing.append("  |        \\ /\n");
                stickForDrawEnd = 4;
                break;
            case 4:
                drawing.append(PictureGenerate(2));
                drawing.append("  |        / \\ \n");
                drawing.append("  |     ._/| |\\_.\n");
                drawing.append("  |        \\ /\n");
                stickForDrawEnd = 4;
                break;
            case 5:
                drawing.append(PictureGenerate(4));
                drawing.append("  |        / \\\n");
                drawing.append("  |      _/   \\_\n");
                stickForDrawEnd = 2;
                break;
            default: 
                stickForDrawEnd = 11;
                break;
        }  
        return drawing.toString();
    }
    private static String DrawAnd(String withoutAnd){
        for (i = 0; i < stickForDrawEnd ; i ++)
        {
            withoutAnd+=("  |\n");
        }
        withoutAnd += ("__|_____");
        return withoutAnd;
    }
    private static String RandomVariant()
    {
        Random random = new Random();
        int randomCount = random.nextInt(variantsWords.size());
        return variantsWords.get(randomCount);
    }
    private static void Game()
    {
        ChosingTheme();
        String nowVariantOfGame = RandomVariant();
        String encryptedWord = "";
        String continueGame = "";
        String usedChar = "Использованные символы: ";
        int life = 0;
        int indexOfChar = 0;
        int lenghtOfWord = nowVariantOfGame.length();
        for (i = 0; i < lenghtOfWord;i++)
        {
            encryptedWord += "_ ";
        }
        
        System.out.println("\n--------------------------------------\n");
        while (life < 6)
        {
            
            System.out.println(DrawAnd("_____________________\n" + PictureGenerate(life)) + "\n");
            if (lenghtOfWord <= 0)
            {
                System.out.println("\nВы победили!");
                System.out.println(" /\\_/\\");
                System.out.println("( o.o )");
                System.out.println(" > ^ <");
                break;
            }
            
            System.out.println(encryptedWord + "\n");
            System.out.println(usedChar);
            System.out.println("\nВведите букву!\n");

            String nextChar = scanner.nextLine();

            try 
            {
                if (nextChar.length()>1 || !Character.isLetter(nextChar.toCharArray()[0]))
                {
                    System.out.println("\nВведите 1 букву!\n");
                    continue;
                }
            } 
            catch (Exception e) 
            {
                System.out.println("\nВведите 1 букву!\n");
                continue;
            }
            
            usedChar += String.valueOf(nextChar.toCharArray()[0]) + ", ";

            System.out.println("\n--------------------------------------\n");

            if (nowVariantOfGame.contains(String.valueOf(nextChar.toCharArray()[0])))
            {
                System.out.println("Данная буква есть в слове !\n");
                indexOfChar = nowVariantOfGame.indexOf(String.valueOf(nextChar.toCharArray()[0]));
                nowVariantOfGame = nowVariantOfGame.substring(0, indexOfChar) + "`" + nowVariantOfGame.substring(indexOfChar + 1);
                lenghtOfWord--;
            }
            else
            {
                System.out.println("Данной буквы нет в слове или вы ее уже отгадали\n");
                life++;
                continue;
            }
            
            encryptedWord = encryptedWord.substring(0, indexOfChar * 2) + String.valueOf(nextChar.toCharArray()[0]) + encryptedWord.substring(indexOfChar * 2 + 1);
        }
        if (life>5)
            {
                System.out.println("\nВы проиграли!\n");
            }

        System.out.println("\nХотите повторить игру? Введите - да, для продолжения; любой другой вариант - для выхода\n");

        continueGame = scanner.next();

        if("да".equals(continueGame.toLowerCase()))
        {
            Game();
        }
    }
    public static void main()
    {
        System.out.println("Добро пожаловать в игру виселица!!!\n");
        System.out.println(DrawAnd("_____________________\n" + PictureGenerate(5)));
        System.out.println("\n Правила игры следующие - вы должны угадать зашифованное слово по выбранной теме. У вас есть возможность допустить ошибку 5 раз, иначе вы проиграли. Удачи! \n");

        Game();
    }
}
