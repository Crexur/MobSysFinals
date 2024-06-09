package android.example.mobsysfinals;

public class Items {
    String transaction;
    int image;

    public Items(String transactionId, int image) {
        this.transaction = transactionId;
        this.image = image;
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
