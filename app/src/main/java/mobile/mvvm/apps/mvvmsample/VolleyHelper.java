package mobile.mvvm.apps.mvvmsample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mobile.mvvm.apps.mvvmsample.databinding.ActivityMainBinding;

/**
 * Created by madhu on 9/6/17.
 */

public class VolleyHelper {
    static String url="https://gist.githubusercontent.com/anonymous/85dbc2c71023f24c2e26/raw/849848a71a1805a314897f9fe98eb7dc43e2e9b9/gistfile1.json";
    static ArrayList<DataModel> dataModels = new ArrayList<>();
    static UserAdapter userAdapter;
    public static void CallApi(final Context mContext, final ActivityMainBinding activityMainBinding) {
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        DataModel dataModel = new DataModel();
                        dataModel.setName(json.getString("Name"));
                        dataModels.add(dataModel);
                    }
                    activityMainBinding.hitApiBtn.setVisibility(View.GONE);
                    activityMainBinding.recyclerView.setVisibility(View.VISIBLE);
                    userAdapter = new UserAdapter(dataModels);
                    activityMainBinding.recyclerView.setAdapter(userAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}
