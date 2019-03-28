package com.example.alexa.pressupcounter.firstlaunch.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstLaunchScope {
}
