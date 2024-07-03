package de.lobby.lobbynavigator;

import de.lobby.lobbynavigator.LpNavigator.Navigator;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyNavigator extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new Navigator(), this);
    }

    @Override
    public void onDisable() {}
}
