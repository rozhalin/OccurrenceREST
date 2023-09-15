package interview.task.tone.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OccurrenceRequestDto extends GenericDto {
    @NotBlank(message = "Поле не должно быть пустым")
    private String string;
    @NotBlank(message = "Поле не должно быть пустым")
    private CalculationType calculationType;
    @NotBlank(message = "Поле не должно быть пустым")
    private CalculationOrder calculationOrder;
}
