package uk.co.which.forensicsapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Step {
    private int stepNumber;
    private Direction direction;
    private int distance;
}
