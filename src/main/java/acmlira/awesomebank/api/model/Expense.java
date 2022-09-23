package acmlira.awesomebank.api.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id", nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private OffsetDateTime dateTime;

    @Column
    private BigDecimal value;

    @OneToMany(mappedBy = "expense", fetch = FetchType.LAZY, targetEntity=Tag.class, cascade = CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "dateTime = " + dateTime + ", " +
                "value = " + value + "," +
                "tags = " + tags.toString() + ")";
    }
}
