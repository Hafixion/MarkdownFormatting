package com.github.Jena;

import org.apache.commons.lang.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MarkdownMain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onChatMessage(AsyncPlayerChatEvent event) {
        String newmessage = event.getMessage();

        if (event.getPlayer().hasPermission("markdown")) {

            // markdown formatting

            // bold
            if (event.getMessage().contains("**")) {
                if (StringUtils.substringBetween(event.getMessage(), "**", "**") != null) {
                    String s = StringUtils.substringBetween(event.getMessage(), "**", "**");
                    newmessage = newmessage.replace("**" + s + "**", "§l" + s);
                }
            }

            // italics
            if (event.getMessage().contains("*")) {
                if (StringUtils.substringBetween(event.getMessage(), "*", "*") != null) {
                    String s = StringUtils.substringBetween(event.getMessage(), "*", "*");
                    newmessage = newmessage.replace("*" + s + "*", "§o" + s);
                }
            }

            // underline
            if (event.getMessage().contains("_")) {
                if (StringUtils.substringBetween(event.getMessage(), "_", "_") != null) {
                    String s = StringUtils.substringBetween(event.getMessage(), "*", "*");
                    newmessage = newmessage.replace("*" + s + "*", "§o" + s);
                }
            }

            event.setMessage(newmessage);
        }
    }
}
