package com.kinoko2k.hat;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hat extends JavaPlugin {


    public Hat(JavaPlugin plugin) {
        plugin.getCommand("hat").setExecutor(this);
    }

    private boolean onHatCommandRun(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        ItemStack helmetItem, mainHandItem;
        helmetItem = player.getInventory().getHelmet();
        mainHandItem = player.getInventory().getItemInMainHand();

//        if (player.getInventory().getItemInMainHand().getAmount() == 0) {
//          player.sendMessage(ChatColor.RED + "[ERROR]最高１個のアイテムをメインハンドに持ってください！");
//          return true;
//      }

        if (player.getInventory().getItemInMainHand().getAmount() != 1) {
            player.sendMessage(ChatColor.RED + "[ERROR]メインハンドのアイテムの個数は一個である必要があります！");
            return true;
        }

        player.getInventory().setHelmet(mainHandItem);
        player.getInventory().setItemInMainHand(helmetItem);
        player.sendMessage(ChatColor.GREEN + "メインハンドの" + mainHandItem + "と頭の" + helmetItem + "アイテムを入れ替えました！");
        return true;
    }
}