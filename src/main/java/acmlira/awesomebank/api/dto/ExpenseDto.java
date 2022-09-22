package acmlira.awesomebank.api.dto;

import acmlira.awesomebank.api.model.Expense;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link Expense} entity
 */
public record ExpenseDto(UUID id, String name, String description, OffsetDateTime dateTime, BigDecimal value,
                         List<TagDto> tags) implements Serializable {
}