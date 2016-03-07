import java.util.Scanner;

/**
 * @author anton
 * @date 07.03.16.
 */
public class UsersInput {

    public UsersInput() {

    }

    public void input() {

        int[] usersData = new int[4];
        System.out.println("Здравствуйте " + System.getProperty("user.name") + ".");
        System.out.println("Введите делимое для первой дроби: ");
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {
            System.out.println("Делимое должно быть целым числом");
            scan = new Scanner(System.in);
        }
        usersData[0] = scan.nextInt();


        System.out.println("Введите делитель для первой дроби: ");
        Scanner scan_1 = new Scanner(System.in);
        while (!scan_1.hasNextInt()) {
            System.out.println("Делитель должен быть целым числом");
            scan_1 = new Scanner(System.in);
            if (scan_1.nextInt() == 0) {
                System.out.println("Делитель не может быть равен 0");
                scan_1 = new Scanner(System.in);
            }
        }
        usersData[1] = scan_1.nextInt();


        System.out.println("Введите делимое для второй дроби: ");
        Scanner scan_2 = new Scanner(System.in);
        while (!scan_2.hasNextInt()) {
            System.out.println("Делимое должно быть целым числом");
            scan_2 = new Scanner(System.in);
        }
        usersData[2] = scan_2.nextInt();


        System.out.println("Введите делитель для второй дроби: ");
        Scanner scan_3 = new Scanner(System.in);
        while (!scan_3.hasNextInt()) {
            System.out.println("Делитель должен быть целым числом");
            scan_3 = new Scanner(System.in);
            if (scan_3.nextInt() == 0) {
                System.out.println("Делитель не может быть равен 0");
                scan_3 = new Scanner(System.in);
            }
        }
        usersData[3] = scan_3.nextInt();

        //Fraction creation
        FractionNumber fraction_1 = new FractionNumber(usersData[0], usersData[1]);
        FractionNumber fraction_2 = new FractionNumber(usersData[2], usersData[3]);

        //Fraction Operations
        FractionNumOperations manipulations = new FractionNumOperations();
        System.out.println("Сумма ваших дробей = " + manipulations.add(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.add(fraction_1, fraction_2).value());
        System.out.println("Разность ваших дробей = " + manipulations.sub(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.sub(fraction_1, fraction_2).toStringValue());
        System.out.println("Частное от ваших дробей = " + manipulations.div(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.div(fraction_1, fraction_2).value());
        System.out.println("Произведение ваших дробей = " + manipulations.mul(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.mul(fraction_1, fraction_2).value());

        //Ask user for one more cycle
        System.out.println("Хотите произвести операции с другими дробями? y/n");
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextLine().toLowerCase().equals("n")) {
            scanner = new Scanner(System.in);
            if (scanner.nextLine().toLowerCase().equals("y")) {
                this.input();
            }
        }
        System.out.println("Спасибо что воспользовались услугами нашей компании");
        System.exit(0);
    }
}
