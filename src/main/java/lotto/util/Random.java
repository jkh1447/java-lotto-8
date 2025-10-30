package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_NUMBER_COUNT);
    }
}
