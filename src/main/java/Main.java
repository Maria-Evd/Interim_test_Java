import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String FILENAME = "toys.csv";
    public static void main(String[] args) {
        try {
            ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);
            if (!toyFile.exists()) {
                toyFile.createNewFile();
                shop.add(new Toy(1, "Кукла Даша", 5, 20));
                shop.add(new Toy(2, "Котенок Гав", 2, 15));
                shop.add(new Toy(3, "Гусь-Обнимусь", 10, 10));
                shop.saveToFile(FILENAME);
            } else {
                shop.loadFromFile(FILENAME);
            }
            shop.setWeight(1, 30);
            ArrayList<String> toyList = shop.getToyList();
            for (String toy : toyList) {
                System.out.println(toy);
            }
            ArrayList<Toy> winners = shop.playGame(3);
            System.out.println("Выиграли следующие игрушки: ");
            for (Toy t : winners) {
                System.out.println(t.getName());
            }
            shop.saveToFile(FILENAME);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
