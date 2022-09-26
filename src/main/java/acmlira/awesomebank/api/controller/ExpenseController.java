package acmlira.awesomebank.api.controller;

import acmlira.awesomebank.api.service.ExpenseService;
import acmlira.awesomebank.api.controller.request.CreateExpenseRequest;
import acmlira.awesomebank.api.dto.ExpenseDto;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/awesome-bank-api/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ExpenseDto create(@RequestBody CreateExpenseRequest request) {
        return expenseService.create(request.name(), request.description(), request.dateTime(), request.value(), request.tags());
    }

    @GetMapping("/{expenseId}")
    public Optional<ExpenseDto> findById(@PathVariable UUID expenseId) {
        return expenseService.findById(expenseId);
    }

    @GetMapping
    public List<ExpenseDto> findAll() {
        return expenseService.findAll();
    }
}
