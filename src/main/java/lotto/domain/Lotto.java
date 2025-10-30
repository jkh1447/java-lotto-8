package lotto.domain;

import java.util.HashSet;
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

        boolean hasDuplicate = false;
        if (numbers.size() != new HashSet<>(numbers).size()) {
            hasDuplicate = true;
        }
        if(hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
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
