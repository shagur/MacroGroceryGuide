package edu.metrostate.ics.macrogroceryguide.model;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * https://medium.com/techpin/https-medium-com-s2purno-volley-get-and-post-jsonobject-request-46fb8a46f799
 */
public class RequestQueueSingleton {
    private static RequestQueueSingleton requestQueueSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private RequestQueueSingleton(Context ctx){
        context = ctx;
        requestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueSingleton getInstance(Context context){
        if(requestQueueSingleton == null){
            requestQueueSingleton = new RequestQueueSingleton(context);
        }
        return requestQueueSingleton;
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

}
