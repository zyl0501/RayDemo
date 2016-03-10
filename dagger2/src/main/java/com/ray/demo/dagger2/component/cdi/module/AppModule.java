package com.ray.demo.dagger2.component.cdi.module;

import com.ray.demo.dagger2.app.present.AnalyticsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ray on 16/3/8.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    AnalyticsManager provideAnalyticsManager() {
        return new AnalyticsManager();
    }
}
