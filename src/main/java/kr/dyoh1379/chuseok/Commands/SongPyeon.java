package kr.dyoh1379.chuseok.Commands;

import kr.dyoh1379.chuseok.ItemStacks.SongPyeons;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static kr.dyoh1379.chuseok.Main.isNum;

public class SongPyeon implements CommandExecutor, TabCompleter {

    List<String> list = Arrays.asList("WHITE", "RED", "GREEN", "YELLOW", "SET");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "당신은 권한이 없습니다!");
            return true;
        }

        if (args.length != 2 && args.length != 3) {
            sender.sendMessage(command.getUsage());
            return true;
        }

        if (!list.contains(args[0].toUpperCase())) {
            sender.sendMessage(ChatColor.RED + "존재하지 않는 송편입니다!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "해당 플레이어가 존재하지 않습니다!");
            return true;
        }

        ItemStack songpyeon = null;

        if (args[0].toUpperCase().equals("WHITE")) songpyeon = SongPyeons.WHITE();
        if (args[0].toUpperCase().equals("RED")) songpyeon = SongPyeons.RED();
        if (args[0].toUpperCase().equals("GREEN")) songpyeon = SongPyeons.GREEN();
        if (args[0].toUpperCase().equals("YELLOW")) songpyeon = SongPyeons.YELLOW();
        if (args[0].toUpperCase().equals("SET")) songpyeon = SongPyeons.SET();

        if (args.length == 2) target.getInventory().addItem(songpyeon);
        else {

            if (isNum(args[2])) {
                int amount = Integer.parseInt(args[2]);

                songpyeon.setAmount(amount);

                target.getInventory().addItem(songpyeon);
                return true;
            }

            sender.sendMessage(ChatColor.RED + "개수를 0보다 큰 정수로 설정해 주세요!");
            return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

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
