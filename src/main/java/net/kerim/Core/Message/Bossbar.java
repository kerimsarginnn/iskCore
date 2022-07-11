package net.kerim.Core.Message;

import com.sun.source.doctree.SeeTree;
import dev.perryplaysmc.dynamicjson.data.CColor;
import net.kerim.Core.iskCore;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import java.util.UUID;

import static dev.perryplaysmc.dynamicjson.data.CColor.ORANGE;
import static dev.perryplaysmc.dynamicjson.data.CColor.RED;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public class Bossbar {
    private final String message;
    private final CColor[] colors;
    private final BarColor color;
    private final BarStyle style;

    public Bossbar(String message, BarColor color, BarStyle style, @Nullable CColor... colors) {
        this.message = message;
        this.colors = colors;
        this.color = color;
        this.style = style;
    }

    public void send(Player... players) {
        BossBar bossBar;
         if (colors!=null) bossBar = Bukkit.createBossBar(CColor.translateGradient(message,colors),color,style, BarFlag.CREATE_FOG);
         else bossBar = Bukkit.createBossBar(CColor.translateGradient(message,RED,ORANGE),color,style, BarFlag.CREATE_FOG);
        for (Player player : players) {
            bossBar.addPlayer(player);
            iskCore.addBossbar(bossBar,randomUUID());
        }
        bossBar.setVisible(true);
    }

    public void send(String id, Player... players) {
        BossBar bossBar;
        if (iskCore.getBossbars().containsKey(fromString(id))) {
            bossBar = iskCore.getBossbars().get(fromString(id));
            for (Player player : players) {
                if (!bossBar.getPlayers().contains(player))
                    bossBar.addPlayer(player);
            }
        } else {
            if (colors!=null) bossBar = Bukkit.createBossBar(CColor.translateGradient(message,colors),color,style, BarFlag.CREATE_FOG);
            else bossBar = Bukkit.createBossBar(CColor.translateGradient(message,RED,ORANGE),color,style, BarFlag.CREATE_FOG);
            for (Player player : players) {
                bossBar.addPlayer(player);
                iskCore.addBossbar(bossBar,fromString(id));
            }
        }
        if (!bossBar.isVisible())
            bossBar.setVisible(true);
    }

    public void remove(String id, Player... players) {
        BossBar bossBar;
        if (iskCore.getBossbars().containsKey(fromString(id))) {
            bossBar = iskCore.getBossbars().get(fromString(id));
            for (Player player : players) {
                if (!bossBar.getPlayers().contains(player))
                    bossBar.removePlayer(player);
            }
        }
    }

    public void remove(String id, boolean fullRemove, Player... players) {
        if (fullRemove) {
            if (iskCore.getBossbars().containsKey(fromString(id))) {
                BossBar bossBar = iskCore.getBossbars().get(fromString(id));
                bossBar.removeAll();
                bossBar.hide();
            }
        } else {
            BossBar bossBar;
            if (iskCore.getBossbars().containsKey(fromString(id))) {
                bossBar = iskCore.getBossbars().get(fromString(id));
                for (Player player : players) {
                    if (!bossBar.getPlayers().contains(player))
                        bossBar.removePlayer(player);
                }
            }
        }
    }

}
