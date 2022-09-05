package uk.co.which.forensicsapi.utils;

import org.springframework.stereotype.Component;
import uk.co.which.forensicsapi.model.Direction;
import uk.co.which.forensicsapi.model.NavigationData;
import uk.co.which.forensicsapi.model.Position;
import uk.co.which.forensicsapi.model.Step;

import java.util.List;

@Component
public class NavigationDataResultHelper {

    /**
     * This function will help to find the final Location by the directions data
     * @param navigationData this will expect the Navigation data to find the final location
     * @return will send back the Final Position based on the Navigation Data
     */

    public Position findFinalLocation(NavigationData navigationData){

        List<Step> totalSteps = navigationData.getSteps();

        int finalXPosition = 0;
        int finalYPosition = 0;

        for(int i=0; i<totalSteps.size();i++){
            Step step = totalSteps.get(i);
            if(step.getDirection().equals(Direction.EAST)){
                finalXPosition = finalXPosition + step.getDistance();
            }else if(step.getDirection().equals(Direction.WEST)){
                finalXPosition = finalXPosition - step.getDistance();
            }else if(step.getDirection().equals(Direction.NORTH)){
                finalYPosition = finalYPosition + step.getDistance();
            }else if(step.getDirection().equals(Direction.SOUTH)){
                finalYPosition = finalYPosition - step.getDistance();
            }
        }
        return new Position(finalXPosition,finalYPosition);

    }
}
