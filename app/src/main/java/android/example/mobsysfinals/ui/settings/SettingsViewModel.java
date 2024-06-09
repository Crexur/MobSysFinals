package android.example.mobsysfinals.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<Integer> amountValue;

    public SettingsViewModel() {
        amountValue = new MutableLiveData<>();
    }

    public LiveData<Integer> getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(int amount) {
        amountValue.setValue(amount);
    }


}