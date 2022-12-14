package acmlira.awesomebank.api.repository;

import acmlira.awesomebank.api.BaseIT;
import acmlira.awesomebank.api.mock.ExpenseMock;
import acmlira.awesomebank.api.model.Expense;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseRepositoryIT extends BaseIT {

    @Autowired
    private ExpenseRepository expenseRepository;

    private final Expense expense = ExpenseMock.mock();


    @Test
    @Transactional
    @Rollback
    void shouldSave() {
        Expense savedExpense = expenseRepository.save(expense);

        assertEquals(expense.getName(), savedExpense.getName());
    }
}
