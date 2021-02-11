package ryvador.peachesisdum.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import ryvador.peachesisdum.Peachesisdum;

public class maincommand implements CommandExecutor {

    Plugin plugin = Peachesisdum.getPlugin(Peachesisdum.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;
            if(args.length <= 0){
                player.sendMessage(ChatColor.RED + "DO /ischecker help for a full list of commands!");
            } else if(args[0].equalsIgnoreCase("help")){
                player.sendMessage(ChatColor.GREEN + "Commands:");
                player.sendMessage(ChatColor.GREEN + "/ischecker reload: reloads the config if the user has the ischecker.reload permission!");
            } else if(args[0].equalsIgnoreCase("reload")){
                if(player.hasPermission("ischecker.reload")){
                    plugin.reloadConfig();
                    player.sendMessage(ChatColor.GREEN + "");
                }
            }

        }


        return false;
    }
}
