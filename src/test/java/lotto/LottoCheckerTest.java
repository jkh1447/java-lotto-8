package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {

    @Test
    @DisplayName("로또 번호 비교 테스트")
    void testCheckLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(10, 1, 45, 30, 4, 5)));
        lottos.add(new Lotto(Arrays.asList(15, 30, 2, 16, 27, 4)));
        int bonus = 5;

        List<Integer> winningNumbers1 = Arrays.asList(10, 1, 45, 30, 4, 5);
        List<LottoRank> result1 = Arrays.asList(LottoRank.FIRST, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers1, bonus))
                .isEqualTo(result1);

        List<Integer> winningNumbers2 = Arrays.asList(10, 1, 45, 30, 4, 13);
        List<LottoRank> result2 = Arrays.asList(LottoRank.SECOND, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers2, bonus))
                .isEqualTo(result2);

        List<Integer> winningNumbers3 = Arrays.asList(10, 1, 45, 30, 34, 13);
        List<LottoRank> result3 = Arrays.asList(LottoRank.FOURTH, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers3, bonus))
                .isEqualTo(result3);
    }
}
