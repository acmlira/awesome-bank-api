package acmlira.awesomebank.api.service;

import lombok.AllArgsConstructor;

import acmlira.awesomebank.api.dto.ExpenseDto;
import acmlira.awesomebank.api.dto.mapper.ExpenseDtoMapper;
import acmlira.awesomebank.api.model.Expense;
import acmlira.awesomebank.api.model.Tag;
import acmlira.awesomebank.api.repository.ExpenseRepository;
import acmlira.awesomebank.api.repository.TagRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService {

    private TagRepository tagRepository;
    private ExpenseRepository expenseRepository;

    public ExpenseDto create(String name, String description, OffsetDateTime dateTime, BigDecimal value, List<String> codes) {
        Expense expense = expenseRepository.save(Expense.builder()
                .name(name)
                .description(description)
                .dateTime(dateTime)
                .value(value)
                .build());

        List<Tag> tags = new ArrayList<>();
        for (String code : codes) {
            Tag tag = tagRepository.save(Tag.builder()
                    .code(code)
                    .expense(expense)
                    .build());
            tags.add(tag);
        }

        expense.setTags(tags);

        return ExpenseDtoMapper.writeDto(expense);
    }

    public Optional<ExpenseDto> findById(UUID expenseId) {
        return expenseRepository
                .findById(expenseId)
                .map(ExpenseDtoMapper::writeDto);
    }

    public List<ExpenseDto> findAll() {
        return expenseRepository
                .findAll()
                .stream()
                .map(ExpenseDtoMapper::writeDto)
                .collect(Collectors.toList());
    }
}
