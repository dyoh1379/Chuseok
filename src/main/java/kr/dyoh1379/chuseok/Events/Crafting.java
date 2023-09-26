package kr.dyoh1379.chuseok.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import static kr.dyoh1379.chuseok.Main.songpyeons;

public class Crafting implements Listener {

    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();

            if (scoreboard.getTeam("01_hunter").hasPlayer(player)) {

                for (ItemStack songpyeon : songpyeons) {

                    if (e.getRecipe().getResult().equals(songpyeon)) {
                        e.setCancelled(true);
                        player.sendMessage(ChatColor.RED + "해당 레시피는 조합할 수 없습니다.");
                    }

                }
            }
        }
    }
}
