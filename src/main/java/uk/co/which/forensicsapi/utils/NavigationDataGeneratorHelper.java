package uk.co.which.forensicsapi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uk.co.which.forensicsapi.model.Direction;
import uk.co.which.forensicsapi.model.Step;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class NavigationDataGeneratorHelper {

    private final static int MIN_STEPS = 6;
    private final static int MAX_STEPS = 12;
    private final static int MIN_DISTANCE_TRAVEL_ = 1;
    private final static int MAX_DISTANCE_TRAVEL_ = 9;

    Random random = new Random();

    /**
     * This function will generate the random steps with the help of
     * getDirection and Get Random private functions
     * @return List of Step
     */
    public List<Step> generateRandomNavigationData(){
        log.info("Start of random generateRandomNavigationData");
        AtomicInteger count=new AtomicInteger(1);
        return IntStream.range(1, getRandomNumber(MIN_STEPS,MAX_STEPS)).mapToObj(i -> {
            return Step.builder()
                    .stepNumber(count.getAndIncrement())
                    .direction(getDirection())
                    .distance(getRandomNumber(MIN_DISTANCE_TRAVEL_,MAX_DISTANCE_TRAVEL_))
                    .build();
        }).collect(Collectors.toList());

    }

    /**
     * This function will return the Random Direction from Direction ENUM
     * @return
     */
    private Direction getDirection() {
        log.debug("Start of random direction ");
        int pick = new Random().nextInt(Direction.values().length);
        Direction direction = Direction.values()[pick];
        log.debug("direction found is {}", direction);
        return direction;
    }

    /**
     * This function will generate the random number using the given min and max range
     * @param min
     * @param max
     * @return
     */
    private int getRandomNumber(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }
}
