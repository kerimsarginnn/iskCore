package net.kerim.Core.Storage.SQL;

import net.kerim.Core.Message.Message;
import net.kerim.Core.iskCore;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public record SetupSQL(String DBName) {
    public SetupSQL {
        File dataFolder = iskCore.getPlugin().getDataFolder();
        File dataFile = new File(dataFolder.getPath()+"/%N.sqlite3".replace("%N",DBName()));
        if (!dataFolder.exists()) {
            try {
                dataFolder.createNewFile();
                if (!dataFile.exists()) dataFile.createNewFile();
                new Message("Veritabanı dosyası oluşturuldu.").send();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        iskCore.setDataPath(dataFolder.getPath());
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+dataFile.getPath());
            iskCore.setConnection(connection);
            new Message("Veritabanı bağlantısı başarılı.").send();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
