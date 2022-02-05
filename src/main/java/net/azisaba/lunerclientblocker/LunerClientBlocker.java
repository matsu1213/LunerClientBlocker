package net.azisaba.lunerclientblocker;

import com.lunarclient.bukkitapi.LunarClientAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LunerClientBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
        saveDefaultConfig();
    }

    public FileConfiguration config = getConfig();

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        String kickMessage = config.getString("blockMessage");

        Bukkit.getScheduler().runTaskLater(this, () -> {
            if(LunarClientAPI.getInstance().isRunningLunarClient(e.getPlayer())){
                e.getPlayer().kickPlayer(ChatColor.RED + kickMessage);
            }
        },40L);

    }

}
