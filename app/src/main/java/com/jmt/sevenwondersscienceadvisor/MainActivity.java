package com.jmt.sevenwondersscienceadvisor;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind({R.id.gear_txt, R.id.tablet_txt, R.id.compass_txt, R.id.score_txt})
    List<TextView> textViews;
    @Bind(R.id.reset_btn)
    Button resetBtn;
    @Bind(R.id.calc_btn)
    Button calcBtn;
    ViewModel gearModel, tabModel, compassModel, gtcModel;
    ViewModel[] viewModels;

    ObservableInt bestScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.jmt.sevenwondersscienceadvisor.MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);
        gearModel = new ViewModel("Gear");
        tabModel = new ViewModel("Tablet");
        compassModel = new ViewModel("Compass");
        gtcModel = new GtcModel("G/T/C");
        viewModels =  new ViewModel[]{gearModel, tabModel, compassModel, gtcModel};
        bestScore = new ObservableInt();
        binding.setViewModels(viewModels);
        binding.setBestScore(bestScore);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.calc_btn)
    public void calcScore(){
        bestScore.set(ScoreCalcUtils.findBestScore(gearModel.value.get(), tabModel.value.get(), compassModel.value.get(), gtcModel.value.get()));
    }

    @OnClick(R.id.reset_btn)
    public void resetValues(){
        for (ViewModel viewModel : viewModels){
            viewModel.value.set(0);
            bestScore.set(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.rate_item:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.jmt.sevenwondersscienceadvisor"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
