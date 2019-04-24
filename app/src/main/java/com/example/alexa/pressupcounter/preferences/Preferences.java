package com.example.alexa.pressupcounter.preferences;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 24.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface Preferences {

    Completable setIsVisited(boolean isVisited);

    Single<Boolean> isVisited();
}
