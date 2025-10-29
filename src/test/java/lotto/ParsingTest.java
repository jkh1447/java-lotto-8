package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParsingTest {

    @Test
    @DisplayName("올바른 구입금액 입력 테스트")
    public void testValidParsingMoney() {
        String money = "5000";

        assertThat(Parsing.parsingMoney(money)).isEqualTo(5000);
    }

    @Test
    @DisplayName("올바르지 않은 구입금액 입력 테스트")
    public void testInvalidParsingMoney() {
        String money1 = "abc";

        assertThatThrownBy(() -> {
            Parsing.parsingMoney(money1);
        })
                .hasMessageContaining("[ERROR] 구입금액은 숫자여야만 합니다.");

        String money2 = "5400";

        assertThatThrownBy(() -> {
            Parsing.parsingMoney(money2);
        })
                .hasMessageContaining("[ERROR] 구입금액은 1000원 단위여야만 합니다.");

    }

    @Test
    @DisplayName("올바른 로또 당첨 번호 테스트")
    public void testValidWinningNumbers() {
        String winningNumbersStr = "5,10,3,45,32,1";
        List<Integer> winningNumbers = Arrays.asList(5, 10, 3, 45, 32, 1);

        assertThat(Parsing.parsingWinningNumbers(winningNumbersStr)).isEqualTo(winningNumbers);
    }

    @Test
    @DisplayName("올바르지 않은 로또 당첨 번호 테스트")
    public void testInvalidWinningNumbers() {
        String winningNumbersStr1 = "5, 10, 3, 45, 32, 1";

        assertThatThrownBy(() -> {
            Parsing.parsingWinningNumbers(winningNumbersStr1);
        })
                .hasMessageContaining("[ERROR] 당첨번호는 콤마(,)로 구분되며, 6자리여야 합니다. (공백X)");

        String winningNumbersStr2 = "5,10,3,45,32,1,11";

        assertThatThrownBy(() -> {
            Parsing.parsingWinningNumbers(winningNumbersStr2);
        })
                .hasMessageContaining("[ERROR] 당첨번호는 콤마(,)로 구분되며, 6자리여야 합니다. (공백X)");

        String winningNumbersStr3 = "5";

        assertThatThrownBy(() -> {
            Parsing.parsingWinningNumbers(winningNumbersStr3);
        })
                .hasMessageContaining("[ERROR] 당첨번호는 콤마(,)로 구분되며, 6자리여야 합니다. (공백X)");

        String winningNumbersStr4 = "5.10.3.45.32.1";

        assertThatThrownBy(() -> {
            Parsing.parsingWinningNumbers(winningNumbersStr4);
        })
                .hasMessageContaining("[ERROR] 당첨번호는 콤마(,)로 구분되며, 6자리여야 합니다. (공백X)");
    }

    @Test
    @DisplayName("올바른 보너스 번호 테스트")
    public void testValidBounsNumber() {
        String bonusNumberStr = "5";

        assertThat(Parsing.parsingBonusNumber(bonusNumberStr)).isEqualTo(5);
    }

    @Test
    @DisplayName("올바르지 않은 보너스 번호 테스트")
    public void testinValidBounsNumber() {
        String bonusNumberStr = "abc";

        assertThatThrownBy(() -> {
            Parsing.parsingBonusNumber(bonusNumberStr);
        })
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자여야만 합니다.");
    }
}
