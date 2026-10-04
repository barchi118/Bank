package Bank;

public class Main {
    public static void main(String[] args) {
        // BankAccountクラスのインスタンスを作成
        BankAccount account = new BankAccount("1234567890", "山田太郎", 10000.0);
        // 入金処理
        account.deposit(5000);
        // 残高確認
        System.out.println("残高: " + account.getBalance());
        // 出金処理
        account.withdraw(3000);
        // エラー確認
        try {
            // 不正な入金処理（マイナスの値）
            account.deposit(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
