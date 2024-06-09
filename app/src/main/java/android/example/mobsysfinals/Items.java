package android.example.mobsysfinals;

public class Items {
    String transaction;
    String moohlah;

    int image;

    public Items(String transactionId, String moohlah, int image) {
        this.transaction = transactionId;
        this.image = image;
        this.moohlah = moohlah;

    }

    public String getAmount() {
        return moohlah;
    }

    public void setAmount(String amount) {
        this.moohlah = amount;
    }

    public String getTransactionId() {
        return transaction;
    }

    public void setTransactionId(String transactionId) {
        this.transaction = transactionId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
