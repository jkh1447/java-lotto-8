package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parsing {

    private final static String WINNING_NUMBERS_PATTERN = "^(([1-9]|[1-3][0-9]|4[0-5]),){5}([1-9]|[1-3][0-9]|4[0-5])$";

    public static int parsingMoney(String money) {
        validateMoney(money);
        return Integer.parseInt(money);

    }

    public static int parsingBonusNumber(String num) {
        validateBonusNumbers(num);
        return Integer.parseInt(num);
    }

    public static List<Integer> parsingWinningNumbers(String winningNumbersStr) {
        validateWinningNumbers(winningNumbersStr);
        List<Integer> winningNumbers = Arrays.stream(winningNumbersStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    private static void validateWinningNumbers(String winningNumbersStr) {
        if (!winningNumbersStr.matches(WINNING_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException("당첨번호는 콤마(,)로 구분되며, 6자리여야 합니다.");
        }
    }

    private static void validateBonusNumbers(String bonusNumbersStr) {
        try {
            Integer.parseInt(bonusNumbersStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야만 합니다.");
        }
    }

    private static void validateMoney(String moneyStr) {
        int money;
        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야만 합니다.");
        }

        if (money < 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위여야만 합니다.");
        }
    }

}
