package android.example.mobsysfinals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionFragmentViewHolder> {

    private Context context;
    private List<Items> items;

    public TransactionAdapter(Context context, List<Items> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public TransactionFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionFragmentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_transform, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionFragmentViewHolder holder, int position) {
        Items item = items.get(position);
        if (item != null) {
            holder.transaction.setText(item.getTransactionId());
            holder.amount.setText(item.getAmount());
            holder.person_image.setImageResource(item.getImage());
        } else {
            holder.transaction.setText("");
            holder.amount.setText("");
            holder.person_image.setImageResource(0);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Items> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}