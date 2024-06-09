package android.example.mobsysfinals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {

    private final MutableLiveData<Integer> amountValue = new MutableLiveData<>();
    private final MutableLiveData<List<Items>> itemList;

    public ItemViewModel() {
        // Set an initial value for the amountValue LiveData
        amountValue.setValue(4000);
        itemList = new MutableLiveData<>();
        itemList.setValue(new ArrayList<>());
    }

    public LiveData<List<Items>> getItemList() {
        return itemList;
    }

    public void addItem(Items item) {
        List<Items> currentList = itemList.getValue();
        if (currentList != null) {
            currentList.add(item);
            itemList.setValue(currentList);
        }
    }

    public void setAmountValue(int amount) {
        amountValue.setValue(amount);
    }

    public LiveData<Integer> getAmountValue() {
        return amountValue;
    }
}
