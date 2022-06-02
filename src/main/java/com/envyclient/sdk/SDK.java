package com.envyclient.sdk;

import net.minecraft.client.Minecraft;

public class SDK {

    public static void init() {
        System.out.println("<=== SDK ===>");
        System.out.println("> Demo: " + Minecraft.getInstance().demo);
        System.out.println("<===========>");
    }

}
