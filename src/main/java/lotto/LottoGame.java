package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoGame {

    Input input = new Input();
    Output output = new Output();

    private void run() {
        output.printInputMoney();
        int money = readMoney();

        List<Lotto> lottos = LottoGenerator.generateLotto(money);
        output.printBuyMessage(lottos.size());
        output.printLottos(lottos);

        output.printInputWinningNumbers();
        List<Integer> winningNumbers = readWinningNumbers();

        output.printInputBonusNumbers();
        int bonus = readBonusNumber();


        
    }

    public int readMoney() {
        while(true) {
            String moneyStr = input.InputMoney();
            int money = parseMoney(moneyStr);
            if(money != -1) { return money; }
        }
    }

    private int parseMoney(String moneyStr) {
        try {
            return Parsing.parsingMoney(moneyStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Integer> readWinningNumbers() {
        while(true) {
            String winningNumberStr = input.InputWinningNumbers();
            List<Integer> winningNumbers = parseWinningNumbers(winningNumberStr);
            if (winningNumbers != null) {
                return winningNumbers;
            }
        }
    }

    public List<Integer> parseWinningNumbers(String winningStr) {
        try {
            return Parsing.parsingWinningNumbers(winningStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int readBonusNumber() {
        while(true) {
            String bonusNumberStr =  input.InputBonusNumbers();
            int bonusNumber = parseBonusNumber(bonusNumberStr);
            if(bonusNumber != -1) { return bonusNumber; }
        }
    }

    public int parseBonusNumber(String bonusStr) {
        try {
            return Parsing.parsingBonusNumber(bonusStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
