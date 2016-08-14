package com.ray.demo.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ray.demo.sample.badge.BadgeGraph;
import com.ray.demo.sample.badge.BadgeHelper;
import com.ray.demo.sample.badge.BadgeNumber;

/**
 * Created by qq448 on 2016/8/14.
 */
public class BadgeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);

        final BadgeView tabService = (BadgeView) findViewById(R.id._service);
        final BadgeView tab1 = (BadgeView) findViewById(R.id.tab_1);
        final BadgeView tab2 = (BadgeView) findViewById(R.id.tab_2);
        final BadgeView tab11 = (BadgeView) findViewById(R.id.tab_1_1);
        final BadgeView tab12 = (BadgeView) findViewById(R.id.tab_1_2);
        final BadgeView tab13 = (BadgeView) findViewById(R.id.tab_1_3);
        final BadgeView tab14 = (BadgeView) findViewById(R.id.tab_1_4);
        final BadgeView tab_item = (BadgeView) findViewById(R.id.item);


        bind(tabService, BadgeGraph.task);
        bind(tab1, BadgeGraph.t_tab_l);
        bind(tab2, BadgeGraph.t_tab_r);
        bind(tab11, BadgeGraph.t_tl_tab_all);
        bind(tab12, BadgeGraph.t_tl_tab_active);
        bind(tab13, BadgeGraph.t_tl_tab_name);
        bind(tab14, BadgeGraph.t_tl_tab_push);
        bind(tab_item, BadgeGraph.t_tl_tab_all_item);

        BadgeHelper.I().plus(BadgeGraph.t_tl_tab_all_item, 1, BadgeNumber.BadgeMode.NUMBER);
        BadgeHelper.I().plus(BadgeGraph.t_tl_tab_name, 2, BadgeNumber.BadgeMode.NUMBER);
        BadgeHelper.I().plus(BadgeGraph.t_tl_tab_push, 1, BadgeNumber.BadgeMode.DOT);
    }

    void bind(final BadgeView badgeView, int id) {
        badgeView.setTag(id);
        BadgeHelper.I().addListener(id, new BadgeHelper.OnChangeListener() {
            @Override
            public void onChange(BadgeNumber badge) {
                badgeView.setCount(badge.getCount());
                badgeView.setMode(badge.getDisplayMode() == BadgeNumber.BadgeMode.NUMBER);
                badgeView.showBadge(badge.getCount() > 0);
            }

            @Override
            public void onDisplay(BadgeNumber badge, boolean show) {
                badgeView.showBadge(show);
            }
        });
    }

    void click(View view){
        BadgeView badgeView = (BadgeView) view.getParent();
        badgeView.clearBadge();
        BadgeHelper.I().clear((Integer) badgeView.getTag());
    }
}
