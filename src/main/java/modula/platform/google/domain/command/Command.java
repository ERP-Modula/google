package modula.platform.google.domain.command;

public interface Command<T> {
    void execute(T param);
}
