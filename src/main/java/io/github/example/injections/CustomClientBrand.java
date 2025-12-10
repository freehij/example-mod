package io.github.example.injections;

import io.github.freehij.loader.annotation.EditClass;
import io.github.freehij.loader.annotation.Inject;
import io.github.freehij.loader.util.InjectionHelper;

@EditClass("net/minecraft/client/ClientBrandRetriever")
public class CustomClientBrand {
    @Inject(method = "getClientModName", descriptor = "()Ljava/lang/String;")
    public static void getClientModName(InjectionHelper helper) {
        helper.setCancelled(true);
        helper.setReturnValue("terrible");
    }
}