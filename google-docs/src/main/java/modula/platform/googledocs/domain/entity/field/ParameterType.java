package modula.platform.googledocs.domain.entity.field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ParameterType {
    ANY("any"),
    ARRAY("array"),
    BOOLEAN("boolean"),
    BUFFER("buffer"),
    STRING("string"),
    DATE("date"),
    NUMBER("number"),
    TEXT("text"),
    SELECT("select"),
    CONNECTION("account:google");

    private final String name;
}
