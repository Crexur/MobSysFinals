package android.example.mobsysfinals.ui.slideshow;

import android.example.mobsysfinals.MyViewPagerAdapter;
import android.example.mobsysfinals.ItemViewModel;
import android.example.mobsysfinals.R;
import android.example.mobsysfinals.ui.reflow.ReflowFragment;
import android.example.mobsysfinals.ui.settings.SettingsFragment;
import android.example.mobsysfinals.ui.transform.TransformFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.example.mobsysfinals.databinding.FragmentSlideshowBinding;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private ItemViewModel itemViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //view model logic to save data
        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        ImageButton settingsButton = binding.sendMoney;

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the SettingsFragment
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_settings);
            }
        });

        ImageButton receiveMoneyButton = binding.ReceiveMoney;

        receiveMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the ReflowFragment
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_reflow);
            }
        });


        // Observe the amountValue LiveData
        itemViewModel.getAmountValue().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer amount) {
                // Update the UI with the new amount
                String amountString = "PHP " + amount;
                binding.amount.setText(String.valueOf(amountString));
            }
        });


        binding.TLayout.setupWithViewPager(binding.viewPagerOnTab);
        MyViewPagerAdapter orderViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        orderViewPagerAdapter.addFragment(new TransformFragment(), "History");
        orderViewPagerAdapter.addFragment(new ReflowFragment(), "Send Money");
        binding.viewPagerOnTab.setAdapter(orderViewPagerAdapter);

        // Add the orderViewPagerAdapter to the viewPagerOnTab
        binding.viewPagerOnTab.setAdapter(orderViewPagerAdapter);

        binding.TLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPagerOnTab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}