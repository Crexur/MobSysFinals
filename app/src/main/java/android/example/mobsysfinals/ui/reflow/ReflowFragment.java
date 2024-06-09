package android.example.mobsysfinals.ui.reflow;

import android.example.mobsysfinals.ItemViewModel;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.example.mobsysfinals.databinding.FragmentReflowBinding;

public class ReflowFragment extends Fragment {

    private FragmentReflowBinding binding;
    private ItemViewModel itemViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReflowViewModel reflowViewModel =
                new ViewModelProvider(this).get(ReflowViewModel.class);

        binding = FragmentReflowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Get the ItemViewModel instance


        binding.send.setOnClickListener(v -> {
            ItemViewModel itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

// Get the current value of amountValue
            int initialAmount = itemViewModel.getAmountValue().getValue();

// Get the value entered in userAmount
            int userAmountEditText = Integer.parseInt(binding.userAmount.getText().toString());
            int newAmount = initialAmount + userAmountEditText;
            itemViewModel.setAmountValue(newAmount);
        });

        return root;
    }

    private void onIncreaseButtonClicked() {
        // Get the current value of amountValue
        int currentAmount = itemViewModel.getAmountValue().getValue();

        // Get the value entered in userAmount
        Editable userAmountEditable = binding.userAmount.getText();
        int userAmount = userAmountEditable != null ? Integer.parseInt(userAmountEditable.toString()) : 0;

        // Increase the value by the user-entered amount
        int newAmount = currentAmount + userAmount;

        // Update the amountValue LiveData
        itemViewModel.setAmountValue(newAmount);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}