package com.anadeainc.exampledagger.dagger.subcomponent;

import dagger.MapKey;

@MapKey
public @interface SubComponentKey {
    Class<?> value();
}
