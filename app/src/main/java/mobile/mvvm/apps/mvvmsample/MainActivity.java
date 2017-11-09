package mobile.mvvm.apps.mvvmsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import mobile.mvvm.apps.mvvmsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //Recyclerview setup
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        activityMainBinding.hitApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolleyHelper.CallApi(mContext,activityMainBinding);
            }
        });
    }
}
