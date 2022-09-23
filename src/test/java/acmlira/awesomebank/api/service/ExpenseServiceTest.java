package acmlira.awesomebank.api.service;

import acmlira.awesomebank.api.dto.ExpenseDto;
import acmlira.awesomebank.api.mock.ExpenseMock;
import acmlira.awesomebank.api.model.Expense;
import acmlira.awesomebank.api.model.Tag;
import acmlira.awesomebank.api.repository.ExpenseRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @InjectMocks
    private ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    private final Expense expense = ExpenseMock.mock();

    @Test
    public void shouldCreate() {
        when(expenseRepository.save(any())).thenReturn(expense);

        ExpenseDto expenseDto = expenseService.create(
                expense.getName(),
                expense.getDescription(),
                expense.getDateTime(), expense.getValue(),
                expense.getTags().stream().map(Tag::getCode).collect(Collectors.toList()));

        assertEquals("Habbibs", expenseDto.name());
    }

    @Test
    public void shouldFindById() {
        Optional<Expense> expenseOptional = Optional.of(expense);
        when(expenseRepository.findById(any())).thenReturn(expenseOptional);

        Optional<ExpenseDto> expenseDtoOptional = expenseService.findById(UUID.randomUUID());

        assertTrue(expenseDtoOptional.isPresent());
        assertEquals("Habbibs", expenseDtoOptional.get().name());
    }

    @Test
    public void shouldNotFindById() {
        when(expenseRepository.findById(any())).thenReturn(Optional.empty());

        Optional<ExpenseDto> expenseDtoOptional = expenseService.findById(UUID.randomUUID());

        assertFalse(expenseDtoOptional.isPresent());
    }

    @Test
    public void shouldFindAll() {
        List<Expense> expenses = List.of(expense);

        when(expenseRepository.findAll()).thenReturn(expenses);

        List<ExpenseDto> expenseDtos = expenseService.findAll();

        assertEquals(expenses.size(), expenseDtos.size());
    }
}
