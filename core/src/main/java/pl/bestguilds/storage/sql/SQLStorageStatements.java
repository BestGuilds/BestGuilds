package pl.bestguilds.storage.sql;

final class SQLStorageStatements {

    private static final String PREFIX = "`bestguilds_";

    private static final String INSERT = "INSERT INTO ";

    static final String USER_INSERT = INSERT + PREFIX +
            "users` (uuid, name, points, kills, deaths, assists) VALUES (?, ?, ?, ?, ?, ?)";

    private SQLStorageStatements() {
    }
}
