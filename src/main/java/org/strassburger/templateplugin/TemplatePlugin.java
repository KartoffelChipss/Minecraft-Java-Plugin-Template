package org.strassburger.templateplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.strassburger.templateplugin.util.CommandManager;
import org.strassburger.templateplugin.util.EventManager;

public final class TemplatePlugin extends JavaPlugin {

    static TemplatePlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        CommandManager.registerCommands();

        EventManager.registerListeners();

        getLogger().info("TemplatePlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TemplatePlugin disabled!");
    }

    public static TemplatePlugin getInstance() {
        return instance;
    }
}
