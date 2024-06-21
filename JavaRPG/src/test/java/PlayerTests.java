import Entities.Player;
import Entities.Rogue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class PlayerTests {
    @ParameterizedTest
    @MethodSource
    @DisplayName("Given a player has enough experience, they should level up and retain any experience past what the level up requirements are")

    void givenExperiencePlayerShouldLevelUpAndRetainAnyExtraExperience(int experienceGained, int startLevel, int expectedExperience){
        //Arrange givenExperiencePlayerShouldLevelUpAndRetainAnyExtraExperience()
        //Arranged in MethodSource

        //Act
        Player rogueTest = new Rogue();
        int actualExperience = rogueTest.isExperienceEnoughToLevelUp(experienceGained,startLevel);

        //Assert
        Assertions.assertEquals(expectedExperience,actualExperience);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("If the player gets more than enough experience to level multiple times then they should do so")
    void givenExperiencePlayerShouldLevelUpAndGainAdditionalLevelsIfRequired(int experienceGained, int startLevel, int expectedLevel){
        //Arrange
        //Done with method source
        //Act
        Player rogueTest = new Rogue();
        rogueTest.isExperienceEnoughToLevelUp(experienceGained,startLevel);
        int actualLevel = rogueTest.getLevel();

        //Assert
        Assertions.assertEquals(expectedLevel,actualLevel);
    }
    public static Stream<Arguments> givenExperiencePlayerShouldLevelUpAndRetainAnyExtraExperience(){
        return Stream.of(
                Arguments.of(1600,1,600),
                Arguments.of(3205,1,205),
                Arguments.of(12034,1,2034),
                Arguments.of(12034,3,34)
        );
    }
    public static Stream<Arguments> givenExperiencePlayerShouldLevelUpAndGainAdditionalLevelsIfRequired(){
        return Stream.of(
                Arguments.of(1600,1,2),
                Arguments.of(3205,2,3),
                Arguments.of(12034,1,5),
                Arguments.of(26753,6,9)
        );
    }
}
