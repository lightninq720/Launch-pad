package com._lightninq;

import com._lightninq.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import lombok.Getter;

public class LaunchPad extends JavaPlugin{

    @Getter
    private static LaunchPad instance;

    public LaunchPad(){
        instance = this;
    }

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        getLogger().info("LaunchPad has been enabled!");
    }

    @Override
    public void onDisable(){
        getLogger().info("LaunchPad has been disabled!");
    }
}
