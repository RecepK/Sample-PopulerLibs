package com.rkurban.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rkurban.myapplication.part.rx.Rxx;
import com.rkurban.myapplication.part.toast.MToast;
import com.rkurban.myapplication.part.web.WebHelper;
import com.rkurban.myapplication.part.web.rss.Js;
import com.rkurban.myapplication.part.web.rss.Rss;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    Rxx rxx;

    @Inject
    MToast toast;

    @Inject
    WebHelper webHelper;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.text_view)
    TextView textView;

    @BindView(R.id.text_view_2)
    TextView textView2;


    private Consumer<List<String>> consumer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        //
        button.setOnClickListener(this);
        initConsumer();

    }

    private void initConsumer() {
        consumer = new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {

                toast.show(strings.get(0));

                webHelper.getObservableXmlList().subscribe(new Consumer<Rss>() {
                    @Override
                    public void accept(Rss rss) throws Exception {
                        toast.show("" + rss.getTask().getTitle());
                    }
                });
            }
        };
    }


    @Override
    public void onClick(View view) {

        String msg = rxx.Test();

        /*
        toast.show(msg);
        textView.setText(msg);
        textView2.setText(msg);
        */

        //rxx.getObservableList().subscribe(consumer);

        webHelper.getObservableJs().subscribe(new Consumer<Js>() {
            @Override
            public void accept(Js js) throws Exception {

                toast.show("Js:" + js.getIp());
            }
        });
    }
}
