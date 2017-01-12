package com.quran.labs.odoj.component.application;

import com.quran.labs.odoj.module.application.ApplicationModule;
import com.quran.labs.odoj.module.application.DatabaseModule;
import com.quran.labs.odoj.module.application.DebugNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DatabaseModule.class, DebugNetworkModule.class } )
interface DebugApplicationComponent extends ApplicationComponent {
}
