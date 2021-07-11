package pl.gfoxi.ItemUpgrade.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;
import java.util.Random;

public class UpgradeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;
        ItemStack item = p.getItemInHand();
        Map<Enchantment, Integer> enchantments = item.getEnchantments();

        if (p.getItemInHand().getType()== Material.DIAMOND_PICKAXE){
            if (enchantments.containsKey(Enchantment.DIG_SPEED)) {

                int lv = enchantments.get(Enchantment.DIG_SPEED);

                if (lv > 6) {

                    if (p.getInventory().contains(Material.DIAMOND /*TU BEDZIE NORMALNY ITEM*/, 3)) {
                        Random random = new Random();
                        if (random.nextInt(100) <= 30) {
                            ItemMeta im = p.getItemInHand().getItemMeta();
                            im.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
                            p.getItemInHand().setItemMeta(im);
                            p.sendMessage("Pomyslnie ulepszono przedmiot");
                        } else {
                            p.sendMessage("Nie udalo sie :(");
                        }
                        p.getInventory().removeItem(new ItemStack(Material.DIAMOND /*TU BEDZIE NORMALNY ITEM*/, 3));
                        p.updateInventory();
                    }
                }

                if (lv < 6)  {
                    p.sendMessage("Musisz miec kilof efficiency 6 aby go ulepszyc.");
                }

            }
            if (!enchantments.containsKey(Enchantment.DIG_SPEED)) {
                p.sendMessage("Musisz miec kilof efficiency 6 aby go ulepszyc.");
            }

        } else {
            p.sendMessage("Nie masz kilofa w dloni");
        }

        return false;
    }
}
