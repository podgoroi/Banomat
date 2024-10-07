import java.util.Scanner;
public class Za4to {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String transaction = "";
        double usd = 0.00;
        double rub = 0.00;
        double cny = 0.00;
        double kzt = 0.00;
        double ttry = 0.00;
        double usdRate = 91.45;
        double rubRate = 1.00;
        double cnyRate = 11.91;
        double kztRate = 0.19;
        double ttryRate = 2.69;
        while (transaction != "Выход") {
            System.out.println("Выберите и введите нужную вам операцию: Внести, Снять, Обменять, Баанс ии введите Выход, чтобы выйти из программы");
            transaction = scanner.nextLine();
            if (transaction.equals("Внести")) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите сумму и ваюту (на ангийском)");
                String moneyVal = scan.nextLine();
                String[] data = moneyVal.split(" ");
                double coin = Double.parseDouble(data[0]);
                switch (data[1]) {
                    case "USD":
                        usd = usd + coin;
                        break;
                    case "RUB":
                        rub = rub + coin;
                        break;
                    case "CNY":
                        cny = cny + coin;
                        break;
                    case "KZT":
                        kzt = kzt + coin;
                        break;
                    case "TRY":
                        ttry = ttry + coin;
                        break;
                    default:
                        System.out.println("Вы ввели неверную валюту");

                }
            } else if (transaction.equals("Снять")) {
                System.out.println("Введите сумму и валюту (на ангийском");
                Scanner scan = new Scanner(System.in);
                String moneyVal = scan.nextLine();
                String[] data = moneyVal.split(" ");
                double coin = Double.parseDouble(data[0]);

                switch (data[1]) {
                    case "USD":
                        if (usd < coin) {
                            System.out.println("Недостаточно денег");
                        } else {
                            usd = usd - coin;
                        }
                        break;
                    case "RUB":
                        if (rub < coin) {
                            System.out.println("Недостаточно денег");
                        } else {
                            rub = rub - coin;
                        }
                        break;
                    case "CNY":
                        if (cny < coin) {
                            System.out.println("Недостаточно денег");
                        } else {
                            cny = cny - coin;
                        }
                        break;
                    case "KZT":
                        if (kzt < coin) {
                            System.out.println("Недостаточно денег");
                        } else {
                            kzt = kzt - coin;
                        }
                        break;
                    case "TRY":
                        if (ttry < coin) {
                            System.out.println("Недостаточно денег");
                        } else {
                            ttry = ttry - coin;
                        }
                        break;
                    default:
                        System.out.println("Вы ввели неверную валюту");
                }
            } else if (transaction.equals("Баланс")) {
                System.out.printf("%.2f USD\n%.2f RUB\n%.2f CNY\n%.2f KZT\n%.2f TRY\n", usd, rub, cny, kzt, ttry);
            } else if (transaction.equals("Обменять")) {
                System.out.println("Введите сумму и валюту дя обмена");
                Scanner scan = new Scanner(System.in);
                String moneyVal = scan.nextLine();
                String[] data = moneyVal.split(" ");
                double coin = Double.parseDouble(data[0]);
                if (data[1].equals("USD")) {
                    if (usd < coin) {
                        System.out.println("Недостаточно денег");
                    } else {
                        switch (data[2]) {
                            case "RUB":
                                rub = coin * usdRate;
                                usd = usd - coin;
                                break;
                            case "CNY":
                                cny = coin * usdRate / cnyRate;
                                usd = usd - coin;
                                break;
                            case "KZT":
                                kzt = coin * kztRate / kztRate;
                                usd = usd - coin;
                                break;
                            case "TRY":
                                ttry = coin * ttryRate / ttryRate;
                                usd = usd - coin;
                                break;

                        }
                    }
                } else if (data[1].equals("RUB")) {
                    if (rub < coin) {
                        System.out.println("Недоастаточно денег");
                    } else {
                        switch (data[2]) {
                            case "USD":
                                usd = coin / usdRate;
                                rub = rub - coin;
                                break;
                            case "CNY":
                                cny = coin / cnyRate;
                                rub = rub - coin;
                                break;
                            case "KZT":
                                kzt = coin / kztRate;
                                rub = rub - coin;
                                break;
                            case "TRY":
                                ttry = coin / ttryRate;
                                rub = rub - coin;
                                break;
                        }
                    }
                } else if (data[1].equals("CNY")) {
                    if (cny < coin) {
                        System.out.println("Недостаточно денег");
                    } else {
                        switch (data[2]) {
                            case "USD":
                                usd = coin * cnyRate / usdRate;
                                cny = cny - coin;
                                break;
                            case "RUB":
                                rub = coin * cnyRate;
                                cny = cny - coin;
                                break;
                            case "KZT":
                                kzt = coin * cnyRate / kztRate;

                                cny = cny - coin;
                                break;
                            case "TRY":
                                ttry = coin * cnyRate / ttryRate;
                                cny = cny - coin;
                                break;
                        }
                    }
                } else if (data[1].equals("KZT")) {
                    if (kzt < coin) {
                        System.out.println("Недостаточно денег");
                    } else {
                        switch (data[2]) {
                            case "USD":
                                usd = coin * kztRate / usdRate;
                                kzt = kzt - coin;
                                break;
                            case "RUB":
                                rub = coin * kztRate;
                                kzt = kzt - coin;
                                break;
                            case "CNY":
                                cny = coin * kztRate / cnyRate;
                                kzt = kzt - coin;
                                break;
                            case "TRY":
                                ttry = coin * kztRate / ttryRate;
                                kzt = kzt - coin;
                                break;
                        }
                    }
                } else if (data[1].equals("TRY")) {
                    if (ttry < coin) {
                        System.out.println("Недостаточно денег");
                    } else {
                        switch (data[2]) {
                            case "USD":
                                usd = coin * ttryRate / usdRate;
                                ttry = ttry - coin;
                                break;
                            case "RUB":
                                rub = coin * ttryRate;
                                ttry = ttry - coin;
                                break;
                            case "CNY":
                                cny = coin * ttryRate / cnyRate;
                                ttry = ttry - coin;
                                break;
                            case "KZT":
                                kzt = coin * ttryRate / kztRate;
                                ttry = ttry - coin;
                                break;
                        }
                    }
                } else {
                    System.out.println("Введены неверные данные");
                }

            } else if (transaction.equals("Выход")) {
                transaction = "Выход";
            }
        }
    }
}

