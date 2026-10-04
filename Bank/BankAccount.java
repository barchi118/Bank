package Bank;

public class BankAccount {
    // 口座番号
    private String accountNumber;
    // 名義人
    private String name;
    // 残高
    private double balance;

    // コンストラクタ
    public BankAccount(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // 各種ゲッター、センターはBankAccountクラスのフィールドを変更できなくするために未作成
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // 入金ロジック
    public void deposit(int amount) {
        // 「不正な値」をブロックするロジック
        if (amount < 0) {
            throw new IllegalArgumentException("マイナスの入金はできません");
        }
        // 残高に入金額を加算する
        this.balance += amount;
    }

    // 出金ロジック
    public void withdraw(int amount) {
        // 「不正な値」をブロックするロジック
        if (amount < 0) {
            throw new IllegalArgumentException("マイナスの出金はできません");
        }
        // 残高が不足している場合は例外を投げる
        if (this.balance < amount) {
            throw new IllegalArgumentException("残高不足です");
        }
        // 残高から出金額を減算する
        this.balance -= amount;
    }
}
