package uk.co.which.forensicsapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class Position {
    private int x = 0;
    private int y = 0;
}
