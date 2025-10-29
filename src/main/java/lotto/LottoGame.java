package lotto;

import java.util.List;

public class LottoGame {

    Input input = new Input();
    Output output = new Output();
    LottoGenerator lottoGenerator = new LottoGenerator();

    private void run() {
        output.printInputMoney();
        String moneyStr = input.InputMoney();
        int money = Parsing.parsingMoney(moneyStr);

        List<Lotto> lottos = lottoGenerator.generateLotto(money);
        output.printBuyMessage(lottos.size());
        output.printLottos(lottos);
    }
}
