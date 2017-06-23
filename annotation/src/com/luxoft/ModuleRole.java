package com.luxoft;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ModuleRole
{
    Role value();

    enum Role
    {
        CORE, ADMIN, STANDARD_PLUGIN, CUSTOM_PLUGIN
    }
}
