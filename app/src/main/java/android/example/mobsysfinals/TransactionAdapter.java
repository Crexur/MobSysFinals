package android.example.mobsysfinals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionFragmentViewHolder> {

    Context context;
    List<Items> items;

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
        holder.transaction.setText(items.get(position).getTransactionId());
        holder.person_image.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
