package acmlira.awesomebank.api.repository;

import acmlira.awesomebank.api.BaseIT;
import acmlira.awesomebank.api.mock.ExpenseMock;
import acmlira.awesomebank.api.model.Expense;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseRepositoryIT extends BaseIT {

    @Autowired
    private ExpenseRepository expenseRepository;

    private final Expense expense = ExpenseMock.mock();


    @Test
    @Transactional
    void shouldSave() {
        Expense savedExpense = expenseRepository.save(expense);

        assertEquals(expense.getName(), savedExpense.getName());
    }

    @Test
    @Transactional
    void shouldNotFindAll() {
        List<Expense> expenses = expenseRepository.findAll();

        assertEquals(0, expenses.size());
    }

    @Test
    @Transactional
    void shouldNotFindById() {
        Optional<Expense> foundExpense = expenseRepository.findById(UUID.randomUUID());

        assertFalse(foundExpense.isPresent());
    }
}
