package pl.gfoxi.ItemUpgrade;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.gfoxi.ItemUpgrade.commands.UpgradeCommand;

public class ItemUpgradePlugin extends JavaPlugin {

    public void onEnable() {
        this.getCommand("Ulepsz").setExecutor(new UpgradeCommand());

        System.out.println("Dziala ");
    }

    public void onDisable() {
        System.out.println("Nie wywalilo sie :oooo ");
    }

}
