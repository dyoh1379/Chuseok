package kr.dyoh1379.chuseok;

import kr.dyoh1379.chuseok.Commands.Game;
import kr.dyoh1379.chuseok.Events.Crafting;
import kr.dyoh1379.chuseok.Events.Interaction;
import kr.dyoh1379.chuseok.Events.Join;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static kr.dyoh1379.chuseok.ItemStacks.SongPyeons.*;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static boolean gameProcess;
    public static long scheduleDelay = 3;
    public static long scheduleTimings = 30;
    public static int glowingTimings = 3;

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
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new Crafting(), this);
        Bukkit.getPluginManager().registerEvents(new Interaction(), this);

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
        removeRecipeGreen();
        removeRecipeYellow();

    }

    public static Main getInstance() {
        return instance;
    }

}
