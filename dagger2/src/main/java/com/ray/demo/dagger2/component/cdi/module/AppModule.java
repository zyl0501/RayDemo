package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.present.AnalyticsManager;
import com.ray.demo.dagger2.component.cdi.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ray on 16/3/8.
 */
@Module
public class AppModule {

    @Provides
    @PerFragment
    AnalyticsManager provideAnalyticsManager() {
        return new AnalyticsManager();
    }
}
