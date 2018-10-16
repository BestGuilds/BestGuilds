package pl.bestguilds.api.storage;

import java.util.Arrays;
import java.util.Optional;

public enum StorageType {

    JSON("JSON"),
    MONGODB("MongoDB"),
    MARIADB("MariaDB"),
    MYSQL("MySQL"),
    POSTGRESQL("PostgreSQL"),
    ;

    private final String name;

    StorageType(String name) {
        this.name = name;
    }

    public static Optional<StorageType> of(String name) {
        return Arrays.stream(values())
                .filter(type -> type.name.equalsIgnoreCase(name))
                .findFirst();
    }
}
