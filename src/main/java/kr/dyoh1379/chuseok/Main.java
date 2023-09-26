package kr.dyoh1379.chuseok;

import kr.dyoh1379.chuseok.Commands.Game;
import kr.dyoh1379.chuseok.Commands.SongPyeon;
import kr.dyoh1379.chuseok.Events.Crafting;
import kr.dyoh1379.chuseok.Events.Interaction;
import kr.dyoh1379.chuseok.Events.Join;
import kr.dyoh1379.chuseok.ItemStacks.SongPyeons;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kr.dyoh1379.chuseok.ItemStacks.SongPyeons.*;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static boolean gameProcess;
    public static long scheduleDelay = 3;
    public static long scheduleTimings = 30;
    public static int glowingTimings = 3;

    public static int delayEndTitle = 2;
    public static int timingEndTitle = 5;
    public static int cooldownSet = 10;

    public static List<ItemStack> songpyeons = new ArrayList<>();

    // TODO: 과거의 당신이 남겨둔 힌트이다. 기도 장소를 정할 때 사용할 수 있도록.
    public static Location prayLocation;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        gameProcess = false;
        Bukkit.getWorld("world").setGameRule(GameRule.SPAWN_RADIUS, 1000);
        Bukkit.setWhitelist(true);

        addRecipeWhite();
        addRecipeRed();
        addRecipeGreen();
        addRecipeYellow();
        addRecipeSet();

        songpyeons.add(SongPyeons.WHITE());
        songpyeons.add(SongPyeons.RED());
        songpyeons.add(SongPyeons.GREEN());
        songpyeons.add(SongPyeons.YELLOW());
        songpyeons.add(SongPyeons.SET());

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        if (scoreboard.getTeam("00_runner") == null) {
            Team runner = scoreboard.registerNewTeam("00_runner");
            runner.setColor(ChatColor.AQUA);
            runner.setCanSeeFriendlyInvisibles(true);
            runner.setAllowFriendlyFire(false);
            runner.setPrefix(ChatColor.AQUA + "[러너] ");

        }

        if (scoreboard.getTeam("01_hunter") == null) {
            Team hunter = scoreboard.registerNewTeam("01_hunter");
            hunter.setColor(ChatColor.RED);
            hunter.setCanSeeFriendlyInvisibles(true);
            hunter.setAllowFriendlyFire(false);
            hunter.setPrefix(ChatColor.RED + "[헌터] ");
        }

        Bukkit.getPluginCommand("game").setExecutor(new Game());
        Bukkit.getPluginCommand("game").setTabCompleter(new Game());

        Bukkit.getPluginCommand("songpyeon").setExecutor(new SongPyeon());
        Bukkit.getPluginCommand("songpyeon").setTabCompleter(new SongPyeon());

        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new Crafting(), this);
        Bukkit.getPluginManager().registerEvents(new Interaction(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        gameProcess = false;

        if (scoreboard.getTeam("00_runner") != null) {
            scoreboard.getTeam("00_runner").unregister();
            scoreboard.getTeam("01_hunter").unregister();
        }

        removeRecipeWhite();
        removeRecipeRed();
        removeRecipeGreen();
        removeRecipeYellow();
        removeRecipeSet();

    }

    public static Main getInstance() {
        return instance;
    }

    public static boolean isNum(String str) {
        try {
            int num = Integer.parseInt(str);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
