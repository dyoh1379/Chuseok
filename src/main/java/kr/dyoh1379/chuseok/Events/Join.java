package kr.dyoh1379.chuseok.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class Join implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        if (!scoreboard.getTeam("00_runner").hasPlayer(player) && !scoreboard.getTeam("01_hunter").hasPlayer(player)) {
            scoreboard.getTeam("01_hunter").addPlayer(player);
        }
    }
}
