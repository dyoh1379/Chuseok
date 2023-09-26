package kr.dyoh1379.chuseok.Events;

import kr.dyoh1379.chuseok.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import static kr.dyoh1379.chuseok.Main.*;

public class Join implements Listener {

    Main plugin = Main.getInstance();

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        if (!scoreboard.getTeam("00_runner").hasPlayer(player) && !scoreboard.getTeam("01_hunter").hasPlayer(player)) {
            scoreboard.getTeam("01_hunter").addPlayer(player);

        }

        if (!gameProcess) {
            if (scoreboard.getTeam("01_hunter").hasPlayer(player)) {

                if (prayLocation != null) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.teleport(prayLocation);
                }
            }
        }
    }
}
