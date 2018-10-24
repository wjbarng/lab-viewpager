package edu.uw.viewpager

import android.content.Context

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.Volley.newRequestQueue

//import com.android.volley.toolbox.Volley.newRequestQueue

class RequestSingleton//private constructor; cannot instantiate directly
private constructor(ctx: Context) {

    //get queue from singleton for direct action
    var requestQueue = null //the singleton's RequestQueue

    init {
        //create the requestQueue
        this.requestQueue = newRequestQueue(ctx.applicationContext)
    }

    //convenience wrapper method
    fun <T> add(req: Request<T>) {
        requestQueue!!.add(req)
    }

    companion object {

        //the single instance of this singleton
        private var instance: RequestSingleton? = null

        //call this "factory" method to access the Singleton
        fun getInstance(ctx: Context): RequestSingleton {
            //only create the singleton if it doesn't exist yet
            if (instance == null) {
                instance = RequestSingleton(ctx)
            }

            return instance //return the singleton object
        }
    }
}