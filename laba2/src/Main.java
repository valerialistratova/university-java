import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = processInput(reader);
        System.out.println("\nВащ введений текст: " + "\n" + text);

        System.out.println("Задайте пiдстроку: ");
        String symbol = reader.nextLine();

        System.out.println("Задайте номер символу: ");
        int number = reader.nextInt();

        System.out.println(modifyText(text, number, symbol));
    }

    private static String processInput(Scanner keyboard) {
        System.out.println("Введiть ваш текст: ");
        StringBuilder input = new StringBuilder();
        String line;
        while (keyboard.hasNextLine()) {
            line = keyboard.nextLine();
            if (line.isEmpty()) {
                break;
            }
            input.append(line).append("\n");
        }
        return input.toString();
    }

    private static String modifyText(String text, int number, String symbol) {
        String[] sentences = text.split("[.!?]");
        text = "";
        for (String sentence : sentences) {
            if (sentence.length() > number) {
                text = text.concat(sentence.substring(0, number).concat(symbol).concat(sentence.substring(number)).concat("."));
            } else if (sentence.length()!=0){
                text = text.concat(sentence.concat("."));
            }
        }
        return text;
    }
}


