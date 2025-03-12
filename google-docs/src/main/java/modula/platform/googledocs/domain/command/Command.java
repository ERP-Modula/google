package modula.platform.googledocs.domain.command;

public interface Command<T> {
    void execute(T param);
}
