package acmlira.awesomebank.api.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public record CreateExpenseRequest(@NotBlank String name, @NotBlank String description, @NotBlank OffsetDateTime dateTime, @NotNull BigDecimal value, List<String> tags) {}
