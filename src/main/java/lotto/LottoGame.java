package lotto;

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
            try{
                String moneyStr = input.InputMoney();
                int money = Parsing.parsingMoney(moneyStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while(true) {
            try{
                String winningStr = input.InputWinningNumbers();
                return Parsing.parsingWinningNumbers(winningStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        while(true) {
            try{
                String bonusStr = input.InputBonusNumbers();
                return Parsing.parsingBonusNumber(bonusStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
