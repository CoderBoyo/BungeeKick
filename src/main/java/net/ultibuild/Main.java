package net.ultibuild;

import net.md_5.bungee.api.plugin.Plugin;
import net.ultibuild.Commands.kick;

import java.util.logging.Level;

public final class Main extends Plugin {

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO,"Successfully started bungee-kick!");
        getProxy().getPluginManager().registerCommand(this, new kick());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
