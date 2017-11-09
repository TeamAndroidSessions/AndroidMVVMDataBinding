package mobile.mvvm.apps.mvvmsample;

import android.databinding.ObservableField;

/**
 * Created by madhu on 5/6/17.
 */

public class UserViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> lName = new ObservableField<>();

    private DataModel dataModel;

    public UserViewModel(DataModel dataModel) {
        setInitialState(dataModel);
    }

    private void setInitialState(DataModel dataModel) {
        name.set(dataModel.getName());
        lName.set(dataModel.getName());
    }
}