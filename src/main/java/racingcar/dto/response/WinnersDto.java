package racingcar.dto.response;

import static racingcar.constants.Format.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnersDto {

    private final List<String> names;

    public WinnersDto(final List<Car> cars) {
        this.names = cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public String createMessage() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for(; i < names.size()-1; i++) {
            builder.append(names.get(i)).append(WINNER_DELIMITER);
        }
        builder.append(names.get(i));
        return builder.toString();
    }

    public List<String> getNames() {
        return names;
    }
}
