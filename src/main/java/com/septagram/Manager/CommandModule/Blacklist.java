package com.septagram.Manager.CommandModule;

import java.util.ArrayList;
import java.util.List;

import com.septagram.Theomachy.DB.AbilityData;
import com.septagram.Utility.PermissionChecker;
import com.septagram.Utility.ReturnAbilityName;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Blacklist {

    public static List<Integer> GodCanlist=new ArrayList<>();
    public static List<Integer> HumanCanlist=new ArrayList<>();
    public static List<Integer> Blacklist=new ArrayList<>();
    public static int Canlist;

    public static void Module(CommandSender sender) {
        if(PermissionChecker.Sender(sender)) {
            Player p=(Player)sender;
            p.openInventory(blackgui());
        }
    }

    //추가라벨
    private static Inventory blackgui() {
        Inventory gui=Bukkit.createInventory(null, 63, ChatColor.BLACK+":: 블랙리스트 ::");


        int[] god=new int[AbilityData.GOD_ABILITY_NUMBER];
        for(int i=0; i<AbilityData.GOD_ABILITY_NUMBER; i++)
            god[i]=i+1;
        int a=101;
        int[] man=new int[AbilityData.HUMAN_ABILITY_NUMBER];
        for(int i=0; i<AbilityData.HUMAN_ABILITY_NUMBER; i++) {
            man[i]=a++;
        }

        ItemStack[] wool=new ItemStack[god.length+man.length+2];
        ItemMeta[] meta=new ItemMeta[god.length+man.length+2];

        for(int i=1;i<=god.length;i++) {
            wool[i-1]=new ItemStack(Material.WHITE_WOOL);
            meta[i]=wool[i-1].getItemMeta();
            meta[i].setDisplayName(ChatColor.WHITE+ReturnAbilityName.name(i) + " : "+i);
            if(!Blacklist.contains(i)) {wool[i-1].setType(Material.LIME_WOOL);}
            else {wool[i-1].setType(Material.RED_WOOL);}
            wool[i-1].setItemMeta(meta[i]);
        }

        int b=101;
        for(int i=god.length;i<(god.length+man.length);i++) {
            wool[i]=new ItemStack(Material.WHITE_WOOL);
            meta[i]=wool[i].getItemMeta();
            meta[i].setDisplayName(ChatColor.WHITE+ReturnAbilityName.name(b) + " : "+b);
            if(!Blacklist.contains(b)) {wool[i].setType(Material.LIME_WOOL);}
            else {wool[i].setType(Material.RED_WOOL);}
            wool[i].setItemMeta(meta[i]);
            b++;
        }

        for(int i=0;i<god.length+man.length;i++) {
            gui.setItem(i, wool[i]);
        }

        return gui;
    }

}
