package io.github.example.injections;

import io.github.example.ExampleMod;
import io.github.freehij.loader.annotation.EditClass;
import io.github.freehij.loader.annotation.Inject;
import io.github.freehij.loader.util.InjectionHelper;

/*
        In order for loader to find all class edits you MUST specify class names (by full path) in mod.properties:injections.
        In mod.properties all class names MUST be divided with ','.
        Note that all paths MUST be specified with '/', not '\' or '.'.
 */
@EditClass("net/minecraft/client/main/Main")
public class ExampleInjection {
    /*
        Handler method MUST be public static void.
        Handler method MUST take InjectionHelper as one and only argument.

        NOTE: As of now I would highly recommend to use Reflector to play with classes, if you'll do it the normal way it might break injection.
        That happens because if you import class in your handler it will be initialized before all injections were proceeded.
        I'm working on a fix for that, be patient.
     */
    @Inject(method = "main", descriptor = "([Ljava/lang/String;)V")
    public static void mainInjection(InjectionHelper helper) {
        ExampleMod.init();
    }
}
