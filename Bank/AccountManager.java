package Bank;

import java.util.HashMap;
import java.util.Map;

// 口座管理クラス
public class AccountManager {
    // 口座番号をキー、BankAccountオブジェクトを値とするHashMap
    private Map<String, BankAccount> accounts;

    // コンストラクタで空のHashMapを用意する
    public AccountManager() {
        this.accounts = new HashMap<>();
    }

    // 口座を追加するメソッド
    public void addAccount(BankAccount account) {
        // 口座がnullの場合は例外を投げる
        if (account == null) {
            throw new IllegalArgumentException("口座が指定されていません");
        }
        // 口座番号を取得してキーにし、Mapに登録
        this.accounts.put(account.getAccountNumber(), account);
    }

    //  口座の検索 (getAccount)
    public BankAccount getAccount(String accountNumber) {
        // Mapから口座番号をキーにして取得
        BankAccount account = this.accounts.get(accountNumber);
        
        // 該当する口座が見つからない場合はエラーにする
        if (account == null) {
            throw new IllegalArgumentException("口座番号 " + accountNumber + " は存在しません");
        }
        return account;
    }

    //  口座間の送金 (transfer)
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        // ① Mapから送金元と送金先の口座をそれぞれ取得
        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        // ② 送金元から出金
        // ※残高不足などのチェックは BankAccount.withdraw 内で例外が飛ぶため、
        //  エラーがあればここで処理が中断し、次の入金には進みません！
        fromAccount.withdraw(amount);

        // ③ 出金が成功した場合のみ、送金先へ入金
        toAccount.deposit(amount);
    }
}
