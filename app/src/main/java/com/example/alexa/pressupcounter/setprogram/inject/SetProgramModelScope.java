package com.example.alexa.pressupcounter.setprogram.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProgramModelScope {
}
