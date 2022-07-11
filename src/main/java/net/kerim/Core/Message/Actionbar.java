package net.kerim.Core.Message;

import dev.perryplaysmc.dynamicjson.data.CColor;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class Actionbar {
    private final String message;
    private final CColor[] colors;

    public Actionbar(String message, @Nullable CColor... colors) {
        this.message = message;
        this.colors = colors;
    }

    public void send(Player... players) {
        if (colors != null) {
            if (players.length == 1) players[0].sendActionBar(CColor.translateGradient(message,colors));
            else for (Player player : players) {
                player.sendActionBar(CColor.translateGradient(message,colors));
            }
        } else {
            if (players.length == 1) players[0].sendActionBar(CColor.translateGradient(message, CColor.RED, CColor.ORANGE));
            else for (Player player : players) {
                player.sendActionBar(CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
            }
        }
    }

    public void change(char old,Player... players) {
        if (colors != null) {
            if (players.length == 1) players[0].sendActionBar(old,CColor.translateGradient(message,colors));
            else for (Player player : players) {
                player.sendActionBar(old,CColor.translateGradient(message,colors));
            }
        } else {
            if (players.length == 1) players[0].sendActionBar(old,CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
            else for (Player player : players) {
                player.sendActionBar(old,CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
            }
        }
    }

}
