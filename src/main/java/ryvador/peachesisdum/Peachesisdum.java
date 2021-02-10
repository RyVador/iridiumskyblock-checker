package ryvador.peachesisdum;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.managers.IslandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import java.security.DomainLoadStoreParameter;
import java.util.List;

public final class Peachesisdum extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("[IridiumSkyblock-Checker] Enabled, trying to make sure peaches isn't dum!");
        getServer().getPluginManager().registerEvents(this, this);
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();




    }

    @Override
    public void onDisable() {
        System.out.println("[IridiumSkyblock-Checker] Disabled, hopefully peaches isn't dum!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void worldChecker(PlayerJoinEvent e){
        Player player = e.getPlayer();
        World world = Bukkit.getWorld(this.getConfig().getString("world-name"));


        if (!getServer().getPluginManager().isPluginEnabled("IridiumSkyblock")) {


            try {
                if (player.getWorld().getName().equals(this.getConfig().getString("iridiumskyblock-overworld")) || player.getWorld().getName().equals(this.getConfig().getString("iridiumskyblock-nether"))) {
                    if (world.equals(null)) world = Bukkit.getWorlds().get(0);
                    player.teleport(world.getSpawnLocation());
                    System.out.println(e.getPlayer().getWorld().getName());
                }
            }
            finally {
                System.out.println("Prevented peaches's dumbness!");
            }




        }
    }

    @EventHandler
    public void teleportEvent(PlayerTeleportEvent e){
        Player player = e.getPlayer();
        World world = e.getTo().getWorld();
        World configworld = Bukkit.getWorld(this.getConfig().getString("world-name"));

        if (!getServer().getPluginManager().isPluginEnabled("IridiumSkyblock")){

            if (world.getName().equalsIgnoreCase(this.getConfig().getString("iridiumskyblock-overworld")) || world.getName().equalsIgnoreCase(this.getConfig().getString("iridiumskyblock-nether"))){
                if (configworld.equals(null)) world = Bukkit.getWorlds().get(0);
                player.teleport(configworld.getSpawnLocation());


            }

        }

    }

    @EventHandler
    public void moveEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        World world = player.getWorld();
        World configworld = Bukkit.getWorld(this.getConfig().getString("world-name"));

        if (!getServer().getPluginManager().isPluginEnabled("IridiumSkyblock")){
            if (world.getName().equalsIgnoreCase(this.getConfig().getString("iridiumskyblock-overworld")) || world.getName().equalsIgnoreCase(this.getConfig().getString("iridiumskyblock-nether"))){
                if (configworld.equals(null)) world = Bukkit.getWorlds().get(0);
                player.teleport(configworld.getSpawnLocation());
            }
        }


    }




}
