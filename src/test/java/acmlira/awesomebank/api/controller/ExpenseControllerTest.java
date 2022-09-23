package acmlira.awesomebank.api.controller;

import acmlira.awesomebank.api.dto.ExpenseDto;
import acmlira.awesomebank.api.mock.CreateExpenseRequestMock;
import acmlira.awesomebank.api.mock.ExpenseDtoMock;
import acmlira.awesomebank.api.service.ExpenseService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExpenseControllerTest {

    @InjectMocks
    private ExpenseController expenseController;

    @Mock
    private ExpenseService expenseService;

    private final ExpenseDto expenseDto = ExpenseDtoMock.mock();

    @Test
    public void shouldCreate() {
        when(expenseService.create(any(), any(), any(), any(), any())).thenReturn(expenseDto);

        assertEquals(expenseDto.name(), expenseController.create(CreateExpenseRequestMock.mock()).name());
    }

    @Test
    public void shouldFindById() {
        when(expenseService.findById(any())).thenReturn(Optional.of(expenseDto));

        Optional<ExpenseDto> optionalExpenseDto = expenseController.findById(UUID.randomUUID());

        assertTrue(optionalExpenseDto.isPresent());
        assertEquals(expenseDto.name(), optionalExpenseDto.get().name());
    }

    @Test
    public void shouldNotFindById() {
        when(expenseService.findById(any())).thenReturn(Optional.empty());

        Optional<ExpenseDto> optionalExpenseDto = expenseController.findById(UUID.randomUUID());

        assertFalse(optionalExpenseDto.isPresent());
    }

    @Test
    public void shouldFindAll() {
        List<ExpenseDto> expenseDtos = List.of(expenseDto);

        when(expenseService.findAll()).thenReturn(expenseDtos);

        List<ExpenseDto> optionalExpenseDtos = expenseController.findAll();

        assertEquals(expenseDtos.size(), optionalExpenseDtos.size());
    }
}
