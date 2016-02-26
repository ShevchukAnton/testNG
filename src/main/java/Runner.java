import java.util.Scanner;

/**
 * @author anton
 * @date 26.02.16.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Здравствуйте " + System.getProperty("user_name") + ".");
        System.out.println("Введите делимое для первой дроби: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            if (scan.nextLine() == null) {
                throw new NullPointerException("Укажите целое число");
            }
            System.out.println("Делимое должно быть целым числом\n");
        }
        int divide = scan.nextInt();
        scan.close();

        System.out.println("Введите делитель для первой дроби: ");
        Scanner scan_1 = new Scanner(System.in);
        while (!scan_1.hasNextInt()) {
            if (scan_1.nextLine() == null) {
                throw new NullPointerException("Укажите целое число");
            }
            System.out.println("Делитель должен быть целым числом\n");
        }
        int divider = scan_1.nextInt();
        scan_1.close();

        System.out.println("Введите делимое для второй дроби: ");
        Scanner scan_2 = new Scanner(System.in);
        while (!scan_2.hasNextInt()) {
            if (scan_2.nextLine() == null) {
                throw new NullPointerException("Укажите целое число");
            }
            System.out.println("Делимое должно быть целым числом\n");
        }
        int divide_1 = scan_2.nextInt();
        scan_2.close();

        System.out.println("Введите делитель для второй дроби: ");
        Scanner scan_3 = new Scanner(System.in);
        while (!scan_3.hasNextInt()) {
            if (scan_3.nextLine() == null) {
                throw new NullPointerException("Укажите целое число");
            }
            System.out.println("Делитель должен быть целым числом\n");
        }
        int divider_1 = scan_3.nextInt();
        scan_3.close();


    }
}
