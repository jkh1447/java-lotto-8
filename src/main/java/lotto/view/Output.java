package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class Output {

    public static final String INPUT_AMOUNT_OF_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_BUY_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";


    public void printInputMoney() {
        System.out.println(INPUT_AMOUNT_OF_MONEY_MESSAGE);
    }

    public void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printInputBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
    }

    public void printBuyMessage(int n) {
        System.out.printf(LOTTO_BUY_MESSAGE, n);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n";
    public static final String LINE_MESSAGE = "---\n";
    public static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    public static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    public static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    public static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";

    public void printLottoResults(Map<String, Integer> lottoResults) {
        System.out.print(LOTTO_RESULT_MESSAGE);
        System.out.print(LINE_MESSAGE);
        System.out.printf(FIFTH_MESSAGE, lottoResults.get("FIFTH"));
        System.out.printf(FOURTH_MESSAGE, lottoResults.get("FOURTH"));
        System.out.printf(THIRD_MESSAGE, lottoResults.get("THIRD"));
        System.out.printf(SECOND_MESSAGE, lottoResults.get("SECOND"));
        System.out.printf(FIRST_MESSAGE, lottoResults.get("FIRST"));
    }

    public static final String LOTTO_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottoYield(double yield) {
        System.out.printf(LOTTO_YIELD_MESSAGE, yield);
    }
}
