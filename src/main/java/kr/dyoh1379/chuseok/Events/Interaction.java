package kr.dyoh1379.chuseok.Events;

import kr.dyoh1379.chuseok.ItemStacks.SongPyeons;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class Interaction implements Listener {

    List<ItemStack> songpyeons = Arrays.asList(SongPyeons.WHITE(), SongPyeons.RED(), SongPyeons.GREEN(), SongPyeons.YELLOW());

    @EventHandler
    public void interaction(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }

        if (player.getInventory().getItemInOffHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInOffHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void interaction(PlayerInteractAtEntityEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }

        if (player.getInventory().getItemInOffHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInOffHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void interaction(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }

        if (player.getInventory().getItemInOffHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInOffHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
