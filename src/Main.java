public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);  // Положить 15 000 сом на счет

        while (true) {
            try {
                account.withDraw(6000);  // Попытка снять 6000 сом
                System.out.println("Снято 6000 сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Снимаем оставшуюся сумму: " + e.getRemainingAmount());
                try {
                    account.withDraw((int) e.getRemainingAmount());  // Снять оставшуюся сумму
                } catch (LimitException ex) {
                    // Эта ошибка не должна возникнуть, т.к. мы снимаем ровно оставшуюся сумму
                }
                System.out.println("Остаток на счете после снятия: " + account.getAmount());
                break;  // Завершаем цикл
            }
        }
    }
}
