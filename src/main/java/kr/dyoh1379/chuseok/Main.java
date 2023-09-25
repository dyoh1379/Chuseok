package kr.dyoh1379.chuseok;

import kr.dyoh1379.chuseok.Commands.Game;
import kr.dyoh1379.chuseok.Events.Join;
import kr.dyoh1379.chuseok.ItemStacks.SongPyeons;
import org.bukkit.*;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static kr.dyoh1379.chuseok.ItemStacks.SongPyeons.*;

public final class Chuseok extends JavaPlugin {

    private static Chuseok instance;
    public static boolean gameProcess;
    public static int scheduleDelay = 3;
    public static int scheduleTimings = 30;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        gameProcess = false;
        Bukkit.getWorld("world").setGameRule(GameRule.SPAWN_RADIUS, 1000);
        Bukkit.setWhitelist(true);

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

        addRecipeWhite();
        addRecipeRed();

        Bukkit.getPluginCommand("game").setExecutor(new Game());
        Bukkit.getPluginCommand("game").setTabCompleter(new Game());
        Bukkit.getPluginManager().registerEvents(new Join(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        gameProcess = false;

        scoreboard.getTeam("00_runner").unregister();
        scoreboard.getTeam("01_hunter").unregister();

        removeRecipeWhite();
        removeRecipeRed();
    }

    public static Chuseok getInstance() {
        return instance;
    }



}
