package me.xela.deathMessage.listeners;

import jdk.jshell.execution.Util;

import java.io.StringReader;
import java.lang.String;
import me.xela.deathMessage.Main;
import me.xela.deathMessage.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener{

    private static Main plugin;

    public PlayerDeathListener (Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if (e.getEntity().getKiller() instanceof Player){
            Player killer = e.getEntity().getKiller();
            Player p = e.getEntity();

            killer.sendMessage(Utils.chat(plugin.getConfig().getString("messageOnKillKiller").replace("<player2>",p.getName()).replace("<player1>",killer.getName())));
            p.sendMessage(Utils.chat(plugin.getConfig().getString("messageOnKillKilled").replace("<player1>",killer.getName()).replace("<player2>",p.getName())));

            if (plugin.getConfig().getBoolean("announceKill")){
                Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("messageOnKillAnnounce").replace("<player1>",p.getName()).replace("<player2>",killer.getName())));
            }
            return;


        }

    }
}
