package net.kerim.Core.Message;

import dev.perryplaysmc.dynamicjson.data.CColor;
import net.kerim.Core.iskCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Message {

    private final String message;
    private final CColor[] colors;

    public Message(String message) {
        this.message = iskCore.getPrefix()+message;
       this.colors = null;
    }

    public Message(String message, CColor... colors) {
        this.message = iskCore.getPrefix()+message;
        this.colors = colors;
    }

    public final void send() {
        if (colors != null) Bukkit.getConsoleSender().sendMessage(CColor.translateGradient(message,colors));
        else Bukkit.getConsoleSender().sendMessage(CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
    }

    public final void send(Player... players) {
        if (colors != null) {
            if (players.length == 1) players[0].sendMessage(CColor.translateGradient(message,colors));
            else for (Player player : players) {
                player.sendMessage(CColor.translateGradient(message,colors));
            }
        } else {
            if (players.length == 1) players[0].sendMessage(CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
            else for (Player player : players) {
                player.sendMessage(CColor.translateGradient(message,CColor.RED,CColor.ORANGE));
            }
        }
    }

}
