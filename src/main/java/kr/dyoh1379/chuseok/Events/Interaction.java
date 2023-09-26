package kr.dyoh1379.chuseok.Events;

import kr.dyoh1379.chuseok.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import static kr.dyoh1379.chuseok.Main.*;

public class Interaction implements Listener {

    Main plugin = Main.getInstance();

    @EventHandler
    public void interaction(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(songpyeon.getItemMeta())) {

                    if (player.getInventory().getItemInMainHand().getType() == Material.BOWL) {

                        if (gameProcess) {

                            if (player.getScoreboard().getTeam("00_runner").hasPlayer(player)) {

                                if (player.getCooldown(Material.BOWL) == 0) {
                                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                                    player.setCooldown(Material.BOWL, cooldownSet * 20);

                                    prayLocation = e.getClickedBlock().getLocation().add(0, 1, 0);
                                    gameProcess = false;

                                    Firework firework = (Firework) player.getWorld().spawnEntity(prayLocation, EntityType.FIREWORK);
                                    FireworkMeta fireworkMeta = firework.getFireworkMeta();

                                    FireworkEffect effect = FireworkEffect.builder()
                                            .flicker(true)
                                            .trail(true)
                                            .withColor(Color.RED)
                                            .withFade(Color.ORANGE)
                                            .with(FireworkEffect.Type.BURST)
                                            .build();

                                    fireworkMeta.addEffect(effect);
                                    fireworkMeta.setPower(1);
                                    firework.setFireworkMeta(fireworkMeta);

                                    Bukkit.getScheduler().runTaskLater(plugin, firework::detonate, 60);

                                    for (Player players : Bukkit.getOnlinePlayers()) {

                                        players.sendMessage(player.getScoreboard().getTeam("00_runner").getPrefix() + player.getDisplayName() + "§r§l 님이 기도를 쏘아올렸습니다!");
                                        players.sendTitle(" ", "§e기도를 쏘아올렸습니다...", delayEndTitle * 20, timingEndTitle * 20, delayEndTitle * 20);

                                        if (players.getScoreboard().getTeam("01_hunter").hasPlayer(players)) {
                                            players.teleport(prayLocation);
                                            players.setGameMode(GameMode.SPECTATOR);
                                        }
                                    }

                                    return;
                                }
                            }
                        }
                    }

                    e.setCancelled(true);
                }
            }
        }

        if (player.getInventory().getItemInOffHand().getItemMeta() != null) {

            for (ItemStack songpyeon : songpyeons) {
                if (player.getInventory().getItemInOffHand().getItemMeta().equals(songpyeon.getItemMeta())) {
                    if (player.getInventory().getItemInOffHand().getType() == Material.BOWL) {

                        if (gameProcess) {

                            if (player.getScoreboard().getTeam("00_runner").hasPlayer(player)) {

                                if (player.getCooldown(Material.BOWL) == 0) {
                                    player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
                                    player.setCooldown(Material.BOWL, cooldownSet * 20);

                                    prayLocation = e.getClickedBlock().getLocation();
                                    gameProcess = false;

                                    Firework firework = (Firework) player.getWorld().spawnEntity(prayLocation, EntityType.FIREWORK);
                                    FireworkMeta fireworkMeta = firework.getFireworkMeta();

                                    FireworkEffect effect = FireworkEffect.builder()
                                            .flicker(true)
                                            .trail(true)
                                            .withColor(Color.RED)
                                            .withFade(Color.ORANGE)
                                            .with(FireworkEffect.Type.BURST)
                                            .build();

                                    fireworkMeta.addEffect(effect);
                                    fireworkMeta.setPower(1);
                                    firework.setFireworkMeta(fireworkMeta);

                                    Bukkit.getScheduler().runTaskLater(plugin, firework::detonate, 60);

                                    for (Player players : Bukkit.getOnlinePlayers()) {

                                        players.sendMessage(player.getScoreboard().getTeam("00_runner").getPrefix() + player.getDisplayName() + "§r§l 님이 기도를 쏘아올렸습니다!");
                                        players.sendTitle(" ", "§e기도를 쏘아올렸습니다...", delayEndTitle * 20, timingEndTitle * 20, delayEndTitle * 20);

                                        if (players.getScoreboard().getTeam("01_hunter").hasPlayer(players)) {
                                            players.teleport(prayLocation);
                                            players.setGameMode(GameMode.SPECTATOR);
                                        }
                                    }

                                    return;
                                }
                            }
                        }
                    }

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
