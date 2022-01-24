package net.azisaba.lunerclientblocker;

import com.lunarclient.bukkitapi.LunarClientAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LunerClientBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {
                if(com.lunarclient.bukkitapi.LunarClientAPI.getInstance().isRunningLunarClient(e.getPlayer())){
                    e.getPlayer().kickPlayer(ChatColor.RED + "ルナークライアントはこのサーバーでは許可されていません！");
                }
            }
        },40L);

    }

}
