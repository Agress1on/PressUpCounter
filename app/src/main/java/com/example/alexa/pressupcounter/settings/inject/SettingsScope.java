package com.example.alexa.pressupcounter.settings.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alexandr Mikhalev on 02.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface SettingsScope {
}
