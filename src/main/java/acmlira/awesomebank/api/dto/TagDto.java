package acmlira.awesomebank.api.dto;

import acmlira.awesomebank.api.model.Tag;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Tag} entity
 */
public record TagDto(UUID id, String code) implements Serializable {
}