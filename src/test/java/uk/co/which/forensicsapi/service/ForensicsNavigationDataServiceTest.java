package uk.co.which.forensicsapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.which.forensicsapi.model.NavigationData;
import uk.co.which.forensicsapi.model.Position;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForensicsNavigationDataServiceTest {

    ForensicsNavigationDataService service = new ForensicsNavigationDataService();

    @Test
    void test_fetchNavigationData() {

        //when
        NavigationData actual = service.fetchNavigationData();

        //then
        assertNotNull(actual);
        assertNotNull(actual.getSteps());
        assertFalse(actual.getSteps().isEmpty());
        assertTrue(actual.getSteps().size()<=12);
    }
}