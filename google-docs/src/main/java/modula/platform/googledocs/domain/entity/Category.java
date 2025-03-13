package modula.platform.googledocs.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    DOCUMENT("Document"),
    OTHER("Other");

    private final String name;
}
