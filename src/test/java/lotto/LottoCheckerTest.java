package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {

    private static Output output;

    @BeforeAll
    static void beforeAll() {
        output = new Output();
    }


    @Test
    @DisplayName("로또 번호 비교 테스트")
    void testCheckLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(10, 1, 45, 30, 4, 5)));
        lottos.add(new Lotto(Arrays.asList(15, 30, 2, 16, 27, 4)));
        int bonus1 = 9;

        // 1등
        List<Integer> winningNumbers1 = Arrays.asList(10, 1, 45, 30, 4, 5);
        List<LottoRank> result1 = Arrays.asList(LottoRank.FIRST, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers1, bonus1))
                .isEqualTo(result1);

        // 2등
        int bonus2 = 5;
        List<Integer> winningNumbers2 = Arrays.asList(10, 1, 45, 30, 4, 13);
        List<LottoRank> result2 = Arrays.asList(LottoRank.SECOND, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers2, bonus2))
                .isEqualTo(result2);

        // 4등
        List<Integer> winningNumbers3 = Arrays.asList(10, 1, 45, 30, 34, 13);
        List<LottoRank> result3 = Arrays.asList(LottoRank.FOURTH, LottoRank.MISS);
        assertThat(LottoChecker.lottoCheck(lottos, winningNumbers3, bonus1))
                .isEqualTo(result3);
    }

    @Test
    @DisplayName("로또 당첨 통계 출력 테스트")
    void testLottoResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(10, 1, 45, 30, 4, 5)));
        lottos.add(new Lotto(Arrays.asList(15, 30, 2, 16, 27, 4)));

        List<Integer> winningNumbers = Arrays.asList(10, 1, 45, 30, 4, 5);
        int bonus = 9;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(baos));

        List<LottoRank> result = LottoChecker.lottoCheck(lottos, winningNumbers, bonus);
        output.printLottoResults(LottoChecker.countLottoMatches(result));

        String expected = "당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n";
        assertThat(baos.toString()).isEqualTo(expected);

        System.setOut(originalOut);

    }
}
