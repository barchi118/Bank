package Bank;

// 取引クラス
public class Transaction {
    // 取引ID
    private String transactionId;
    // 日付
    private String date;
    // "入金"/"出金"
    private String type;
    // 金額
    private double amount;

    // コンストラクタ
    public Transaction(String transactionId, String date, String type, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    // 各種ゲッター
    public String getTransactionId() {
        return transactionId;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

}
