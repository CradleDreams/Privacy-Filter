import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) {
        String inputFilePath = "input_letter.txt";
        try {
            String text = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            System.out.println("--- Исходный текст ---");
            System.out.println(text);

            String phoneRegex = "(\\+?\\d{1,3}[-.\\s]?)?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}";
            String nameRegex = "(?<![.!?]\\s)[A-ZА-ЯЁ][a-zа-яё]+(?:\\s+[A-ZА-ЯЁ][a-zа-яё]+)?";

            String censoredText = text.replaceAll(phoneRegex, "[censored]");
            censoredText = censoredText.replaceAll(nameRegex, "[censored]");
            
            System.out.println("\n--- Очищенный текст ---");
            System.out.println(censoredText);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
