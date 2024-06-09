package android.example.mobsysfinals;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionFragmentViewHolder extends RecyclerView.ViewHolder {

    ImageView person_image;
    TextView transaction, amount;

    public TransactionFragmentViewHolder(@NonNull View itemView) {
        super(itemView);
        person_image = itemView.findViewById(R.id.person_image);
        transaction = itemView.findViewById(R.id.transaction);
        amount = itemView.findViewById(R.id.amount);
    }
}
