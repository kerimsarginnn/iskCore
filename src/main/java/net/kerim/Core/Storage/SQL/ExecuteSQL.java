package net.kerim.Core.Storage.SQL;

import net.kerim.Core.iskCore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public record ExecuteSQL(String sql, boolean update) {
    public int execute() {
        Connection connection = iskCore.getConnection();
        try {
            Statement statement = iskCore.getStatement();
            if (update) statement.executeUpdate(sql);
            else statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public ResultSet getResult() {
        Connection connection = iskCore.getConnection();
        try {
            Statement statement = iskCore.getStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
