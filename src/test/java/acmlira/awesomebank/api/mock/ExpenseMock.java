package acmlira.awesomebank.api.mock;

import acmlira.awesomebank.api.model.Expense;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class ExpenseMock {
    public static Expense mock() {
        Expense expense = new Expense();
        expense.setName("Habbibs");
        expense.setDescription("Jantar no Habbibs");
        expense.setDateTime(OffsetDateTime.MAX);
        expense.setValue(BigDecimal.TEN);
        expense.setTags(List.of(TagMock.mock()));

        return expense;
    }
}
