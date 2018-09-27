package pl.bestguilds.api.storage;

public class StorageException extends RuntimeException {

  private static final long serialVersionUID = 1;

  public StorageException() {
    super();
  }

  public StorageException(String message) {
    super(message);
  }

  public StorageException(String message, Throwable cause) {
    super(message, cause);
  }

  public StorageException(Throwable cause) {
    super(cause);
  }
}
