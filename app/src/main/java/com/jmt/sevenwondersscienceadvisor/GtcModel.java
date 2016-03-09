package com.jmt.sevenwondersscienceadvisor;

import android.view.View;

/**
 * Created by qumbaala on 3/8/2016.
 */
public class GtcModel extends ViewModel {
    public GtcModel(String initText){
        super(initText);
    }

    @Override
    public void incrementValue(View view) {
        value.set(value.get() < 3 ? value.get()+1:3);
    }
}
