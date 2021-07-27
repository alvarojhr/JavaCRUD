package Prueba3;

import Prueba3.UI.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        do {
            Menu.showMenu();
            option = scanner.nextInt();
            Menu.selectOption(option, scanner);
        }while (option != 0);

    }
}
