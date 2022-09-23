package acmlira.awesomebank.api.mock;

import acmlira.awesomebank.api.model.Expense;
import acmlira.awesomebank.api.model.Tag;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class ExpenseMock {
    public static Expense mock() {
        Tag tag = new Tag();
        tag.setCode("COMIDA");

        Expense expense = new Expense();
        expense.setName("Habbibs");
        expense.setDescription("Jantar no Habbibs");
        expense.setDateTime(OffsetDateTime.MAX);
        expense.setValue(BigDecimal.TEN);
        expense.setTags(List.of(tag));

        return expense;
    }
}
