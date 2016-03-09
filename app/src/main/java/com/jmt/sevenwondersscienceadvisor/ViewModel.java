package com.jmt.sevenwondersscienceadvisor;

import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

/**
 * Created by qumbaala on 3/8/2016.
 */
    public class ViewModel {
    public ObservableInt value;
    public String initText;

    public ViewModel(String initText){
        value = new ObservableInt();
        this.initText = initText;
    }
    public ViewModel(){
    }
    public void incrementValue(View view){
        value.set(value.get()+1);
    }

    public void decrementValue(View view){
        value.set(value.get() > 0 ? value.get()-1:0);
    }
}
