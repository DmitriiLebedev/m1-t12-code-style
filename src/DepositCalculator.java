import java.util.Scanner;

public class DepositCalculator {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new DepositCalculator().userInteraction();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double payout = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateDeposit(payout);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateDeposit(amount + amount * yearRate * depositPeriod);
    }

    double calculateDeposit(double payout) { //не совсем понял зачем была изменена сигнатура метода
        double scale = Math.pow(10, 2); 
        return Math.round(payout * scale) / scale;
    }

    void userInteraction() {
        int amount;
        int depositPeriod;
        int input;
        double payout = 0;
        double yearRate = 0.06;

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        input = scanner.nextInt(); //я бы эту переменную назвал более звучно, чтоб название отражало для чего она.
        if (input == 1) payout = calculateSimplePercent(amount, yearRate, depositPeriod);
        else if (input == 2) {
            payout = calculateComplexPercent(amount, yearRate, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + payout);
    }

}
