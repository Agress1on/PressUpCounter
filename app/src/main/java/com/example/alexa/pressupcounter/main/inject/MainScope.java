package com.example.alexa.pressupcounter.main.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MainScope {
}
