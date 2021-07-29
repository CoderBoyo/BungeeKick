package net.ultibuild;

import net.md_5.bungee.api.plugin.Plugin;
import net.ultibuild.Commands.kick;

import java.util.logging.Level;

public final class Main extends Plugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().log(Level.INFO,"Successfully started Bungee-Kick!");
        UpdateChecker.checkForUpdates();
        getProxy().getPluginManager().registerCommand(this, new kick());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
