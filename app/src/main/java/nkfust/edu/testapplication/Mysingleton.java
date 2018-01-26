package nkfust.edu.testapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by RED on 2017/11/16.
 */

public class Mysingleton {
    private static Mysingleton mInstance;
    private RequestQueue requestQueue;
    public static Context mCtx;

    private Mysingleton(Context context) {
        mCtx = context ;
        requestQueue = getRequestQueue() ;
    }

    public static  synchronized Mysingleton getInstance(Context context) {
        if(mInstance == null)
        {
            mInstance = new Mysingleton(context);
        }
        return  mInstance ;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        }
        return requestQueue ;
    }

    public <T>void addTorequestque(Request<T> request){
        requestQueue.add(request);

    }
}
