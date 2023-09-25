package kr.dyoh1379.chuseok.Commands;

import kr.dyoh1379.chuseok.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static kr.dyoh1379.chuseok.Main.*;

public class Game implements CommandExecutor, TabCompleter {

    Main plugin = Main.getInstance();
    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "당신은 권한이 없습니다!");
            return true;
        }

        if (args.length == 1) {

            if (args[0].equals("start")) {

                if (scoreboard.getTeam("00_runner").getSize() == 0) {
                    sender.sendMessage(ChatColor.RED + "러너 팀에 최소 한명 이상의 플레이어가 필요합니다!");
                    return true;
                }

                gameProcess = true;
                Bukkit.setWhitelist(false);

                sender.sendMessage("게임 시작!");

                new BukkitRunnable() {
                    @Override
                    public void run() {

                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.GRAY + "[러너의 위치]");

                            for (Player runner : Bukkit.getOnlinePlayers()) {
                                if (runner.getScoreboard().getTeam("00_runner").hasPlayer(runner)) {
                                    runner.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, glowingTimings * 20, 0, false, false, false));

                                    String location = runner.getWorld().getName() + " (" + (int) runner.getLocation().getX() + ", " + (int) runner.getLocation().getY() + ", " + (int) runner.getLocation().getZ() + ")";
                                    player.sendMessage("- " + scoreboard.getTeam("00_runner").getPrefix() + runner.getDisplayName() + ChatColor.RESET + "의 위치: " + ChatColor.YELLOW + location);
                                }
                            }
                        }
                    }
                }.runTaskTimer(plugin, scheduleDelay * 20L, scheduleTimings * 20L);

                return true;
            }

            if (args[0].equals("stop")) {
                gameProcess = false;

                sender.sendMessage("게임을 종료했습니다.");
                return true;
            }

        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> list = Arrays.asList("start", "stop");

        List<String> completions = null;

        if (args.length == 1) {
            for (String s : list) {
                if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                    if (completions == null) {
                        completions = new ArrayList<>();
                    }
                    completions.add(s);
                }
            }

            if (completions != null) {
                Collections.sort((completions));
            }
        }
        return completions;
    }
}
