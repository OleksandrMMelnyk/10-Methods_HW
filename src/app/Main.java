/*
Магазин продає товар зі знижкою, залежно від суми покупки:
- до 5000, включно, знижка 5% від суми купівлі;
- від 5000, виключно, до 10000, включно, знижка 10% від суми купівлі;
- понад 10000, знижка 15% від суми покупки.
Реалізуйте функціонал, що
- розраховує суму знижки,
- суму до оплати за вирахуванням знижки для певної суми купівлі.
Розрахунки знижки та суми до оплати проводяться кожен в окремих
методах.
Виведіть через окремий метод наступну інформацію:
- загальна сума покупки,
- сума знижки,
- сума до оплати.
Грошові значення, при виведенні, повинні мати два знаки після
десяткового роздільника.
*/

package app;

import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    static double purchaseCost;
    static double minPurchaseCost = 5000;
    static double maxPurchaseCost = 10000;
    static double discount;
    static double discountBronze = 5;
    static double discountSilver = 10;
    static double discountGold = 15;
    static double amountPay;
    static double amountDiscount;
    static final String CURRENCY = "UAH";

    public static void main(String[] args) {

        purchaseCost = getData();
        discount = getDiscount(purchaseCost);
        amountPay = calculatePay(purchaseCost, discount);
        amountDiscount = calculateDiscount(purchaseCost, discount);
        getOutput();
    }

    public static double getData() {

        System.out.print("Enter the purchase cost: ");
        Scanner salesScanner = new Scanner(System.in);
        salesScanner.useLocale(Locale.ENGLISH);
        return salesScanner.nextDouble();
    }

    public static double getDiscount(double amount) {

        if (amount <= minPurchaseCost) {
            return discountBronze;
        } else if (amount > minPurchaseCost && purchaseCost <= maxPurchaseCost) {
            return discountSilver;
        } else {
            return discountGold;
        }
    }

    public static double calculateDiscount(double amount, double discount) {
        return amount * discount / 100;

    }

    public static double calculatePay(double amount, double discount) {
        return amount - (amount * discount / 100);
    }

    public static void getOutput() {

        String roundPurchaseCost = roundCost(purchaseCost);
        String roundDiscount = roundCost(discount);
        String roundAmountDiscount = roundCost(amountDiscount);
        String roundAmountPay = roundCost(amountPay);

        System.out.println("---------------------------------------" +
                "\nTotal purchase amount," + CURRENCY + ":" + " " + roundPurchaseCost +
                "\nDiscount and amount of discount " + "(" + roundDiscount + "%" + ")," + CURRENCY + ":" + " " + roundAmountDiscount +
                "\nAmount to pay," + CURRENCY + ":" + " " + roundAmountPay +
                "\n**************************************" +
                "\nThank you for purchase!!!");
    }

    public static String roundCost(double value) {

        return new DecimalFormat("#.00").format(value);
    }
}
