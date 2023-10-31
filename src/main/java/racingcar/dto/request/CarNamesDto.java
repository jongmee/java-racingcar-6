package racingcar.dto.request;

import static racingcar.constants.Condition.NAME_SIZE;
import static racingcar.constants.ErrorMessage.LENGTH_LIMIT;
import static racingcar.constants.Format.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class CarNamesDto {

    private final List<String> names;

    public CarNamesDto(String carNames) {
        this.names = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        validateNameLength(names);
    }

    private void validateNameLength(final List<String> names) {
        for(String name: names) {
            if(name.length() > NAME_SIZE || name.length() == 0) {
                throw new IllegalArgumentException(LENGTH_LIMIT + NAME_SIZE);
            }
        }
    }

    public List<String> getNames() {
        return names;
    }
}
