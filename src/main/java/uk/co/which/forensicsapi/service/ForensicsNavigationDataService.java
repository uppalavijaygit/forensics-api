package uk.co.which.forensicsapi.service;

import org.springframework.stereotype.Service;
import uk.co.which.forensicsapi.exception.IncorrectAPICallException;
import uk.co.which.forensicsapi.model.NavigationData;
import uk.co.which.forensicsapi.model.Position;
import uk.co.which.forensicsapi.model.Step;
import uk.co.which.forensicsapi.utils.NavigationDataGeneratorHelper;
import uk.co.which.forensicsapi.utils.NavigationDataResultHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForensicsNavigationDataService {

    List<Step> stepList = new ArrayList<>();

    NavigationDataGeneratorHelper dataGeneratorHelper = new NavigationDataGeneratorHelper();
    NavigationDataResultHelper navigationDataResultHelper = new NavigationDataResultHelper();

    /**
     * This Service call get the data from Data Generate
     * and Map to Navigation date along with the Starting Position
     * @return This function will Return the Navigation Data with
     * Steps and Stating Position
     */
    public NavigationData fetchNavigationData(){
        if(stepList.isEmpty()){
            stepList = dataGeneratorHelper.generateRandomNavigationData();
        }
        return NavigationData.builder().steps(stepList).startingPosition(Position.builder().build()).build();
    }

    /**
     * This Function is useful to find the Final Position of the Directions given by the Directions Api
     * @param givenPosition  This function will consume the User Guessing position
     * @return True or False based on the result
     */
    public boolean findFinalPosition(Position givenPosition){
        if(stepList.isEmpty()){
            throw new IncorrectAPICallException("Please call directions api before calling the location api");
        }
        Position finalPosition = navigationDataResultHelper.findFinalLocation(NavigationData.builder().steps(stepList).startingPosition(Position.builder().build()).build());
        return givenPosition.equals(finalPosition);
    }
}
