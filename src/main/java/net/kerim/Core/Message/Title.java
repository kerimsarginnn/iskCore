package net.kerim.Core.Message;

import dev.perryplaysmc.dynamicjson.data.CColor;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class Title {
    private final String title;
    private final String subTitle;
    private final CColor[] colors;

    public Title(String title, String subTitle, @Nullable CColor... colors) {
        this.title = title;
        this.subTitle = subTitle;
        this.colors = colors;
    }

    public Title(String title, @Nullable CColor... colors) {
        this.title = title;
        this.subTitle = "";
        this.colors = colors;
    }

    public final void send(Player... players) {
        if (colors != null) {
            if (players.length == 1) players[0].sendTitle(CColor.translateGradient(title,colors),CColor.translateGradient(subTitle,colors));
            else for (Player player : players) {
                player.sendTitle(CColor.translateGradient(title,colors),CColor.translateGradient(subTitle,colors));
            }
        } else {
            if (players.length == 1) players[0].sendTitle(CColor.translateGradient(title,CColor.RED,CColor.ORANGE),CColor.translateGradient(subTitle,CColor.RED,CColor.ORANGE));
            else for (Player player : players) {
                player.sendTitle(CColor.translateGradient(title,CColor.RED,CColor.ORANGE),CColor.translateGradient(subTitle,CColor.RED,CColor.ORANGE));
            }
        }
    }
}
