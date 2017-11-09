package mobile.mvvm.apps.mvvmsample;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mobile.mvvm.apps.mvvmsample.databinding.ActivityMainBinding;
import mobile.mvvm.apps.mvvmsample.databinding.RowBinding;

/**
 * Created by madhu on 7/6/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomViewHolder> {
    private ArrayList<DataModel> modelArrayList = new ArrayList<>();
    public UserAdapter(ArrayList<DataModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowBinding rowBinding = RowBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CustomViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(UserAdapter.CustomViewHolder holder, int position) {
        UserViewModel userViewModel= new UserViewModel(modelArrayList.get(position));
        ((RowBinding) holder.getBinding()).setUser(userViewModel);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public static class CustomViewHolder extends RecyclerView.ViewHolder {
            private RowBinding rowBinding;
           CustomViewHolder(RowBinding itemView) {
              super(itemView.getRoot());
              rowBinding = itemView;
          }
              ViewDataBinding getBinding() {
                  return rowBinding;
        }
    }
}
