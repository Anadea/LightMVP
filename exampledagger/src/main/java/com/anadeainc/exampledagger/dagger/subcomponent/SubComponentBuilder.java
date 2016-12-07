package com.anadeainc.exampledagger.dagger.subcomponent;

public interface SubComponentBuilder<C extends SubComponent> {
    C build();
}
