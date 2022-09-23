package acmlira.awesomebank.api.repository;

import acmlira.awesomebank.api.BaseIT;
import acmlira.awesomebank.api.mock.TagMock;
import acmlira.awesomebank.api.model.Tag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagRepositoryIT extends BaseIT {
    @Autowired
    private TagRepository tagRepository;

    private final Tag tag = TagMock.mock();

    @Test
    @Transactional
    @Rollback
    void shouldSave() {
        Tag savedTag = tagRepository.save(tag);

        assertEquals(tag.getCode(), savedTag.getCode());
    }
}
