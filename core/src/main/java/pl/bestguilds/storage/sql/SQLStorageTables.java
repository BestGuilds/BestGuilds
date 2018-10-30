package pl.bestguilds.storage.sql;

public final class SQLStorageTables {

    private static final String PREFIX = "bestguilds_";

    private static final String USERS = PREFIX + "users";

    private static final String GUILDS = PREFIX + "guilds";

    private static final String GUILDS_MEMBERS = GUILDS + "_" + "members";
    private static final String GUILDS_ALLIES = GUILDS + "_" + "allies";
    private static final String GUILDS_AREAS = GUILDS + "_" + "areas";

    private SQLStorageTables() {
    }
}
