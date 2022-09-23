package acmlira.awesomebank.api.mock;

import acmlira.awesomebank.api.dto.ExpenseDto;
import acmlira.awesomebank.api.dto.TagDto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class ExpenseDtoMock {
    public static ExpenseDto mock() {
        TagDto tagDto = new TagDto(UUID.fromString("97da36eb-0e6d-4cc7-b452-9b48c646dd0c"), "COMIDA");

        return new ExpenseDto(UUID.fromString("97da36eb-0e6d-4cc7-b452-9b48c646dd0b"), "Habbibs", "Jantar no Habbibs", OffsetDateTime.MAX, BigDecimal.TEN, List.of(tagDto));
    }
}
