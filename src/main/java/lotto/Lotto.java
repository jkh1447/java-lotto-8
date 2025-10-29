package lotto;

import java.util.List;

public class Lotto {
    private final int LOTTO_NUMBER = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public LottoRank checkLotto(List<Integer> winningNumbers, int bonus) {
        int matchCount = 0;
        boolean isBonus = false;

        for (int num : numbers) {
            if (winningNumbers.contains(num)) {
                matchCount++;
            }
        }

        if (numbers.contains(bonus)) {
            isBonus = true;
        }

        return LottoRank.of(matchCount, isBonus);
    }
}
