package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double balance = 0.0;
        double vklad = 0.0;
        System.out.println("Расчет Баланса");
        System.out.println("Введите сумму с точностью до копеек");
        System.out.println("Разделяйте рубли и копейки запятой");
        while (true) {
            System.out.println("Хотите ли вы продолжить? (Да/Нет/Начислите проценты)");
            System.out.println("Введите 1, что-бы ввести расход/доход");
            System.out.println("Введите 2, что-бы посмотреть баланс и выйти");
            System.out.println("Введите 3, что-бы обозначить конец месяца");
            System.out.println("Введите 4, чтобы пополнить свой вклад");
            byte n;
            n = in.nextByte();

            if (n == 1) {
                try {
                    double transaction = in.nextDouble();
                    balance += transaction;
                } catch (InputMismatchException exc) {
                    System.out.println("Необходимо ввести вещественное число разделенное запятой");
                }
            } else if (n == 2) {
                System.out.println("Спасибо за пользование");
                System.out.println("Ваш баланс: " + balance);
                break;
            } else if (n == 3) {
                System.out.println("Вам начислено: " + (balance / 100) * 3);
                balance += (balance / 100) * 3;
                System.out.println("На конец месяца остаток по вашему балансу: " + balance);
                System.out.println("По вкладу вам начислено: " + ((vklad / 100) * 10));
                vklad += (vklad / 100) * 10;
                System.out.println("На конец месяца баланс вашего вклада составляет: "+ vklad);
            } else if (n == 4) {
                System.out.println("Введите сумму, которую хотите положить на вклад");
                double transaction = in.nextDouble();
                in.nextLine();
                if (balance < transaction) {
                    System.out.println("На вышем счете недостаточно средств для перевода");
                } else if (balance >= transaction) {
                    balance -= transaction;
                    vklad += transaction;
                    System.out.println("На вашем вкладе: " + vklad);

                }
            } else {
                System.out.println("Выберите опцию от 1 до 4");
            }
        }
    }
}
