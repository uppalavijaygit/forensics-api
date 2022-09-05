package uk.co.which.forensicsapi.utils;

import org.junit.jupiter.api.Test;
import uk.co.which.forensicsapi.model.Direction;
import uk.co.which.forensicsapi.model.NavigationData;
import uk.co.which.forensicsapi.model.Position;
import uk.co.which.forensicsapi.model.Step;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NavigationDataResultHelperTest {

    NavigationDataResultHelper helper = new NavigationDataResultHelper();

    @Test
    void findFinalLocation_when_5_steps() {
        //given
        NavigationData navigationData = NavigationData.builder().steps(getSteps()).build();

        //when
        Position finalLocation = helper.findFinalLocation(navigationData);

        //then
        assertNotNull(finalLocation);
        assertEquals(-2,finalLocation.getX());
        assertEquals(2,finalLocation.getY());
    }

    private List<Step> getSteps() {
        Step step1 = Step.builder().stepNumber(1).direction(Direction.EAST).distance(2).build();
        Step step2 = Step.builder().stepNumber(2).direction(Direction.NORTH).distance(5).build();
        Step step3 = Step.builder().stepNumber(3).direction(Direction.WEST).distance(4).build();
        Step step4 = Step.builder().stepNumber(4).direction(Direction.SOUTH).distance(3).build();
        return List.of(step1,step2,step3,step4);
    }
}