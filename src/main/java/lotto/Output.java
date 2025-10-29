package lotto;

import java.util.List;

public class Output {

    public static final String INPUT_AMOUNT_OF_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_BUY_MESSAGE = "%d개를 구매했습니다.";
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
            System.out.println(lotto);
        }
    }
}
