package de.lobby.lobbynavigator.LpNavigator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Navigator implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();

        if (world.getName().equalsIgnoreCase("lobby")) {
            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemMeta meta = compass.getItemMeta();
            meta.setDisplayName("§8★  §6Game Modes §8★  §7(Rechtsklick)");
            compass.setItemMeta(meta);
            player.getInventory().setItem(4, compass);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null && item.getType() == Material.COMPASS && item.getItemMeta().getDisplayName().equalsIgnoreCase("§8★  §6Game Modes §8★  §7(Rechtsklick)")) {
            Inventory menu = Bukkit.createInventory(null, 9, "§8★  §6Game Modes §8★");

            menu.setItem(0, createMenuItem(Material.GRASS_BLOCK, "§a§l\uD83C\uDF10 SMP §a§l\uD83C\uDF10"));
            menu.setItem(2, createMenuItem(Material.STONE, "§6§l\uD83D\uDEA7 §d§lBuilding Server §9§l#1 §6§l\uD83D\uDEA7"));
            menu.setItem(4, createMenuItem(Material.STONE, "§6§l\uD83D\uDEA7 §d§lBuilding Server §9§l#2 §6§l\uD83D\uDEA7"));
            menu.setItem(6, createMenuItem(Material.DIAMOND_SWORD, "§6§l⚔ §a§lVaro §3§l2024 §6§l⚔"));
            menu.setItem(8,createMenuItem(Material.BARRIER,"§4§l\uD83D\uDED1 §c§lComming Soon!! §4§l\uD83D\uDED1"));
            player.openInventory(menu);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        String inventoryTitle = event.getView().getTitle();
        if (item != null && item.getType() == Material.COMPASS && item.getItemMeta().getDisplayName().equals("§8★  §6Game Modes §8★  §7(Rechtsklick)")) {
            event.setCancelled(true);
        }
        if (inventoryTitle.equals("§8★  §6Game Modes §8★")) {
            event.setCancelled(true);
        }
        if (inventoryTitle.equals("§8★  §6Game Modes §8★")) {
            event.setCancelled(true);
            if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                Player player = (Player) event.getWhoClicked();
                String itemName = item.getItemMeta().getDisplayName();
                if (itemName.equals("§a§l\uD83C\uDF10 SMP §a§l\uD83C\uDF10")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " world");

                } else if (itemName.equals("§6§l\uD83D\uDEA7 §d§lBuilding Server §9§l#1 §6§l\uD83D\uDEA7")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " building_server1");

                } else if (itemName.equals("§6§l\uD83D\uDEA7 §d§lBuilding Server §9§l#2 §6§l\uD83D\uDEA7")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " building_server2");

                } else if (itemName.equals("§6§l⚔ §a§lVaro §3§l2024 §6§l⚔") || itemName.equals("§4§l\uD83D\uDED1 §c§lComming Soon!! §4§l\uD83D\uDED1")) {

                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw " +  player.getName() + " {\"text\":\"Comming Soon!!\",\"bold\":true,\"color\":\"dark_red\"}");

                }
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        ItemStack item = event.getOldCursor();
        String inventoryTitle = event.getView().getTitle();
        if (item != null && item.getType() == Material.COMPASS && item.getItemMeta().getDisplayName().equals("§8★  §6Game Modes §8★  §7(Rechtsklick)")) {
            event.setCancelled(true);
        }
        if (inventoryTitle.equals("§8★  §6Game Modes §8★")) {
            event.setCancelled(true);
        }
    }

    private ItemStack createMenuItem(Material material, String pName) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(pName);
        item.setItemMeta(meta);
        return item;
    }
}
