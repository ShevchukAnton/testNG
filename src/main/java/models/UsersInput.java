package models;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author anton
 * @date 07.03.16.
 */
public class UsersInput {

    private int[] usersData;
    private Scanner scan = new Scanner(System.in);
    public UsersInput() {

    }

    public void input() {

        usersData = new int[4];
        System.out.println("Здравствуйте " + System.getProperty("user.name") + ".");
        System.out.println("Введите делимое для первой дроби: ");

        while (!scan.hasNextInt()) {
            System.out.println("Делимое должно быть целым числом");
            scan = new Scanner(System.in);
        }
        usersData[0] = scan.nextInt();


        System.out.println("Введите делитель для первой дроби: ");
        while (scan.hasNext()) {
            try {
                int tmp = Integer.parseInt(scan.next());
                if (tmp != 0) {
                    usersData[1] = tmp;
                    break;
                }
                System.out.println("Делитель должен быть целым числом отличным от 0");
                scan = new Scanner(System.in);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Делитель должен быть целым числом отличным от 0");
                scan = new Scanner(System.in);
            }
        }


        System.out.println("Введите делимое для второй дроби: ");
        while (!scan.hasNextInt()) {
            System.out.println("Делимое должно быть целым числом");
            scan = new Scanner(System.in);
        }
        usersData[2] = scan.nextInt();


        System.out.println("Введите делитель для второй дроби: ");
        while (scan.hasNext()) {
            try {
                int tmp = Integer.parseInt(scan.next());
                if (tmp != 0) {
                    usersData[3] = tmp;
                    break;
                }
                System.out.println("Делитель должен быть целым числом отличным от 0");
                scan = new Scanner(System.in);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Делитель должен быть целым числом отличным от 0");
                scan = new Scanner(System.in);
            }
        }

        operations();

        oneMoreCycle();
        scan.close();
    }

    private void operations() {
        //Fraction creation
        FractionNumber fraction_1 = new FractionNumber(usersData[0], usersData[1]);
        FractionNumber fraction_2 = new FractionNumber(usersData[2], usersData[3]);

        //Fraction Operations
        FractionNumOperations manipulations = new FractionNumOperations();
        System.out.println("Сумма ваших дробей = " + manipulations.add(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.add(fraction_1, fraction_2).value());
        System.out.println("Частное ваших дробей = " + manipulations.div(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.div(fraction_1, fraction_2).value());
        System.out.println("Разность от ваших дробей = " + manipulations.ded(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.ded(fraction_1, fraction_2).value());
        System.out.println("Произведение ваших дробей = " + manipulations.mul(fraction_1, fraction_2).toStringValue());
        System.out.println("Это равняется - " + manipulations.mul(fraction_1, fraction_2).value());
    }

    private void oneMoreCycle() {
        //Ask user for one more cycle
        System.out.println("Хотите произвести операции с другими дробями? y/n");
        while (scan.hasNext()) {
            String tmp = scan.nextLine();
            if (tmp.toLowerCase().equals("y")) {
                this.input();
            } else if (tmp.toLowerCase().equals("n")) {
                System.out.println("Спасибо что воспользовались услугами нашей компании");
                System.exit(0);
            }
        }
    }
}
