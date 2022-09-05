package uk.co.which.forensicsapi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.which.forensicsapi.model.Direction;
import uk.co.which.forensicsapi.model.Step;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NavigationDataGeneratorHelperTest {

    NavigationDataGeneratorHelper helper = new NavigationDataGeneratorHelper();

    @Test
    void generateRandomNavigationData() {
        //given

        //when
        List<Step> actual = helper.generateRandomNavigationData();

        //then
        assertNotNull(actual);
        assertTrue(actual.size()<=12);
        assertTrue(actual.get(0).getDirection() instanceof Direction);
        assertTrue(actual.get(0).getDistance()<=9);
    }

}