package acmlira.awesomebank.api.mock;

import acmlira.awesomebank.api.model.Tag;

public class TagMock {
    public static Tag mock() {
        Tag tag = new Tag();
        tag.setCode("COMIDA");
        return tag;
    }
}
