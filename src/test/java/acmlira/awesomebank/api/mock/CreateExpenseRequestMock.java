package acmlira.awesomebank.api.mock;

import acmlira.awesomebank.api.controller.request.CreateExpenseRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class CreateExpenseRequestMock {
    public static CreateExpenseRequest mock() {
        return new CreateExpenseRequest("Habbibs", "Jantar no Habbibs", OffsetDateTime.MAX, BigDecimal.TEN, List.of("COMIDA"));
    }
}
