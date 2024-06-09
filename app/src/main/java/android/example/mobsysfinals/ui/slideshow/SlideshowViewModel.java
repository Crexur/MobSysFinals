package android.example.mobsysfinals.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<Integer> amountValue;

    public SlideshowViewModel() {
        amountValue = new MutableLiveData<>();
    }

    public LiveData<Integer> getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(int amount) {
        amountValue.setValue(amount);
    }

}