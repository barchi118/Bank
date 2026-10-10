package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 銀行口座クラス
public class BankAccount {
    // 口座番号
    private String accountNumber;
    // 名義人
    private String name;
    // 残高
    private double balance;
    // 取引履歴
    private List<Transaction> history;

    // コンストラクタ
    public BankAccount(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.history = new ArrayList<>();
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
    public void deposit(double amount) {
        // 「不正な値」をブロックするロジック
        if (amount < 0) {
            throw new IllegalArgumentException("マイナスの入金はできません");
        }
        // 残高に入金額を加算する
        this.balance += amount;

        // 履歴の記録
        recordTransaction("入金", amount);

        // 取引履歴
        printHistory();
    }

    // 出金ロジック
    public void withdraw(double amount) {
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
        recordTransaction("出金", amount);
    }

    // 取引履歴の作成
    private void recordTransaction(String type, double amount) {
        String txId = UUID.randomUUID().toString(); // 重複しないIDを自動生成
        String date = java.time.LocalDate.now().toString(); // 日付を取得する
        Transaction transaction = new Transaction(txId, date, type, amount);
        this.history.add(transaction);
    }

    // 取引履歴の表示
    public void printHistory() {
        System.out.println("=== " + this.name + "様の取引履歴 ===");

        // historyリストから Transactionオブジェクトを1つずつ「t」として取り出す
        for (Transaction t : this.history) {
            // 取り出した「t」のGetterを使ってデータを取得し、整形して出力する
            System.out.println(
                    "取引ID: " + t.getTransactionId() +
                            " | 日付: " + t.getDate() +
                            " | 種別: " + t.getType() +
                            " | 金額: " + t.getAmount() + "円");
        }
    }
}
