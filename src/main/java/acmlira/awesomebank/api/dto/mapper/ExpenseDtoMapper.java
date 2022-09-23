package acmlira.awesomebank.api.dto.mapper;

import acmlira.awesomebank.api.dto.ExpenseDto;
import acmlira.awesomebank.api.model.Expense;

import java.util.stream.Collectors;

public class ExpenseDtoMapper {
    public static ExpenseDto writeDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getName(),
                expense.getDescription(),
                expense.getDateTime(),
                expense.getValue(),
                expense.getTags().stream().map(TagDtoMapper::writeDto).collect(Collectors.toList()));
    }
}
