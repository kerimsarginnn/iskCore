package net.kerim.Core;

import net.kerim.Core.Message.Message;
import net.kerim.Core.Storage.SQL.SetupSQL;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.UUID;

public final class iskCore extends JavaPlugin {

    private static Plugin plugin;
    private static Plugin core;
    private static String dataPath;
    private static String prefix;
    private static Map<UUID, BossBar> bossbars;
    private static Connection connection;
    private static Statement statement;

    @Override
    public void onEnable() {

        prefix = "Çekirdek » ";

        new Message("Çekirdek aktif ediliyor...").send();

        core = iskCore.getPlugin(iskCore.class);

        new Message("Çekirdek başarıyla aktif edildi.");

    }

    public static String getDataPath() {
        return dataPath;
    }

    public static void setDataPath(String dataPath) {
        iskCore.dataPath = dataPath;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        iskCore.connection = connection;
        try {
            iskCore.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement() {
        return statement;
    }


    public static Map<UUID, BossBar> getBossbars() {
        return bossbars;
    }

    public void Initialize(Plugin plugin, String prefix) {
        iskCore.plugin = plugin;
        iskCore.prefix = prefix;
    }
    public static void addBossbar(BossBar bossBar, UUID id) {
        iskCore.bossbars.put(id,bossBar);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static Plugin getCore() {
        return core;
    }

    public static String getPrefix() {
        return prefix;
    }
}
