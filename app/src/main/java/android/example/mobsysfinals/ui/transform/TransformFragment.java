package android.example.mobsysfinals.ui.transform;

import android.example.mobsysfinals.ItemViewModel;
import android.example.mobsysfinals.Items;
import android.example.mobsysfinals.TransactionAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.example.mobsysfinals.TransactionAdapter;
import android.example.mobsysfinals.Items;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.example.mobsysfinals.R;
import android.example.mobsysfinals.databinding.FragmentTransformBinding;
import android.example.mobsysfinals.databinding.ItemTransformBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fragment that demonstrates a responsive layout pattern where the format of the content
 * transforms depending on the size of the screen. Specifically this Fragment shows items in
 * the [RecyclerView] using LinearLayoutManager in a small screen
 * and shows items using GridLayoutManager in a large screen.
 */
public class TransformFragment extends Fragment {

    private FragmentTransformBinding binding;
    private ItemViewModel itemViewModel;
    private TransactionAdapter adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transform, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_transform);
        adapter = new TransactionAdapter(getContext(), new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        itemViewModel.getItemList().observe(getViewLifecycleOwner(), new Observer<List<Items>>() {
            @Override
            public void onChanged(List<Items> items) {
                adapter.setItems(items);
            }
        });

        return view;
    }

    public void updateRecyclerView(List<Items> items) {
        TransactionAdapter adapter = (TransactionAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}