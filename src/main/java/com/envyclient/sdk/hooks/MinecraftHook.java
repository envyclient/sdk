package com.envyclient.sdk.hooks;

import com.envyclient.fusion.injection.hook.manifest.At;
import com.envyclient.fusion.injection.hook.manifest.Definition;
import com.envyclient.fusion.injection.hook.manifest.Hook;
import com.envyclient.fusion.injection.hook.manifest.HookAt;
import com.envyclient.sdk.SDK;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.lwjgl.glfw.GLFWErrorCallbackI;

@Hook(Minecraft.class)
public abstract class MinecraftHook extends Minecraft {

    public MinecraftHook(GameConfig var1) {
        super(var1);
    }

    /*
        Hooks
     */

    @HookAt(method = "<init>", at = At.TAIL, definition = "callback")
    private void hookInit() {
        System.out.println("---------------------------");
        System.out.println("> Version Type: " + versionType);
        System.out.println("> Launched Version: " + launchedVersion);
        System.out.println("> Allows Chat" + allowsChat);
        System.out.println("---------------------------");
        SDK.init();
    }

    /*
        Definitions
     */

    @Definition(type = RenderSystem.class, line = 545, name = "callback")
    public abstract void setErrorCallback(GLFWErrorCallbackI var0);

}
