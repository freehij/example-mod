package io.github.example.injections;

import io.github.example.ExampleMod;
import io.github.freehij.loader.annotation.EditClass;
import io.github.freehij.loader.annotation.Inject;
import io.github.freehij.loader.util.InjectionHelper;

/*
        In order for loader to find all class edits you MUST specify class names (by full path) in mod.properties:injections.
        In mod.properties all class names MUST be divided with ','.
        In annotations and mod.properties all class paths MUST be specified with '/', not '\' or '.'.
 */
@EditClass("net/minecraft/client/main/Main")
public class ExampleInjection {
    /*
        Handler method MUST be public static void.
        Handler method MUST take InjectionHelper as one and only argument.
     */
    @Inject(method = "main", descriptor = "([Ljava/lang/String;)V")
    public static void mainInjection(InjectionHelper helper) {
        ExampleMod.init();
    }
}
