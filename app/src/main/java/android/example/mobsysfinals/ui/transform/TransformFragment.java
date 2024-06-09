package android.example.mobsysfinals.ui.transform;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transform, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_transform);

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("#1", R.drawable.avatar_1));
        items.add(new Items("#2", R.drawable.avatar_10));
        items.add(new Items("#3", R.drawable.avatar_14));
        items.add(new Items("#4", R.drawable.avatar_8));
        items.add(new Items("#5", R.drawable.avatar_12));
        items.add(new Items("#6", R.drawable.avatar_13));
        items.add(new Items("#7", R.drawable.avatar_4));
        items.add(new Items("#1", R.drawable.avatar_1));
        items.add(new Items("#2", R.drawable.avatar_10));
        items.add(new Items("#3", R.drawable.avatar_14));
        items.add(new Items("#4", R.drawable.avatar_8));
        items.add(new Items("#5", R.drawable.avatar_12));
        items.add(new Items("#6", R.drawable.avatar_13));
        items.add(new Items("#7", R.drawable.avatar_4));
        items.add(new Items("#1", R.drawable.avatar_1));
        items.add(new Items("#2", R.drawable.avatar_10));
        items.add(new Items("#3", R.drawable.avatar_14));
        items.add(new Items("#4", R.drawable.avatar_8));
        items.add(new Items("#5", R.drawable.avatar_12));
        items.add(new Items("#6", R.drawable.avatar_13));
        items.add(new Items("#7", R.drawable.avatar_4));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TransactionAdapter(getContext(), items));


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}