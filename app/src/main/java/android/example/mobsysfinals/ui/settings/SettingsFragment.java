package android.example.mobsysfinals.ui.settings;

import android.example.mobsysfinals.ItemViewModel;
import android.example.mobsysfinals.Items;
import android.example.mobsysfinals.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.example.mobsysfinals.databinding.FragmentSettingsBinding;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private ItemViewModel itemViewModel;
    private EditText subtractAmountEditText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);


        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to continue?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked "Yes"
                        subtractAmount(); // Subtract the amount
                        sendItemsToTransformFragment(); // Add the items to the TransformFragment
                        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                        navController.popBackStack(R.id.nav_slideshow, false); // Navigate back to the SlideshowFragment
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked "No", do nothing
                        dialog.dismiss();
                    }
                });

                // Create and show the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return root;
    }

    private void subtractAmount() {
        String amountString = binding.userAmount.getText().toString();
        if (!amountString.isEmpty()) {
            int amountToSubtract = Integer.parseInt(amountString);
            Integer currentAmount = itemViewModel.getAmountValue().getValue();
            if (currentAmount != null) {
                if (amountToSubtract <= currentAmount) {
                    int newAmount = currentAmount - amountToSubtract;
                    itemViewModel.setAmountValue(newAmount);
                    Toast.makeText(requireContext(), "Amount subtracted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Cannot subtract more than the current amount", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(requireContext(), "Please enter a valid amount", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendItemsToTransformFragment() {
        // Retrieve data from textboxes
        String num = binding.userNumber.getText().toString();
        String moohlah = binding.userAmount.getText().toString();
        int itemImage = R.drawable.avatar_2; // Replace with your actual data

        if (num.isEmpty() || moohlah.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter valid values", Toast.LENGTH_SHORT).show();
            return;
        }

        int amountToSend = Integer.parseInt(moohlah);
        Integer currentAmount = itemViewModel.getAmountValue().getValue();
        if (currentAmount != null && amountToSend <= currentAmount) {
            String accountString = "Account#: " + num;
            String amountString = "Amount sent#: PHP" + moohlah;

            // Create new Items object
            Items newItem = new Items(accountString, amountString, itemImage);

            itemViewModel.addItem(newItem);

            binding.userNumber.setText("");
            binding.userAmount.setText("");
        } else {
            Toast.makeText(requireContext(), "Cannot send more than the current amount", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}