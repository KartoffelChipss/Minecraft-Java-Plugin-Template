package org.strassburger.templateplugin.util;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.strassburger.templateplugin.TemplatePlugin;
import org.strassburger.templateplugin.commands.TemplateCommand;

public class CommandManager {
    private static final TemplatePlugin plugin = TemplatePlugin.getInstance();

    private CommandManager() {}

    public static void registerCommands() {
        registerCommand("template", new TemplateCommand(), new TemplateCommand());
    }

    private static void registerCommand(String name, CommandExecutor executor, TabCompleter tabCompleter) {
        PluginCommand command = plugin.getCommand(name);

        if (command != null) {
            command.setExecutor(executor);
            command.setTabCompleter(tabCompleter);
            command.permissionMessage(MessageUtils.formatMsg("<red>You do not have permission to execute this command."));
        }
    }
}
