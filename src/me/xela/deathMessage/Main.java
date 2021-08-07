package me.xela.deathMessage;

import me.xela.deathMessage.listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        saveDefaultConfig();

        new PlayerDeathListener(this);
    }
}
