package Bank;

// メインクラス
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
        // 履歴取得

        try {
            // 不正な入金処理（マイナスの値）
            account.deposit(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // AccountManagerクラスのテスト
        AccountManager manager = new AccountManager();
        // 口座を2つ作成して登録
        BankAccount taro = new BankAccount("1001", "山田太郎", 10000);
        BankAccount hanako = new BankAccount("1002", "鈴木花子", 5000);

        manager.addAccount(taro);
        manager.addAccount(hanako);

        // 太郎から花子へ 3000円 送金
        manager.transfer("1001", "1002", 3000);

        // それぞれの履歴を表示してみる
        taro.printHistory(); // 出金 3000円 が記録されているはず
        hanako.printHistory(); // 入金 3000円 が記録されているはず
    }
}
