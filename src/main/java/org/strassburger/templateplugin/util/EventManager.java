package org.strassburger.templateplugin.util;

import org.bukkit.event.Listener;
import org.strassburger.templateplugin.TemplatePlugin;
import org.strassburger.templateplugin.listeners.InventoryCloseListener;

public class EventManager {
    private static final TemplatePlugin plugin = TemplatePlugin.getInstance();

    private EventManager() {}

    public static void registerListeners() {
        registerListener(new InventoryCloseListener());
    }

    private static void registerListener(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
