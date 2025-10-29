package lotto;

public class LottoGame {

    Input input = new Input();
    Output output = new Output();

    private void run() {
        output.printInputMoney();
        String moneyStr = input.InputMoney();
        int money = Parsing.parsingMoney(moneyStr);


        
    }
}
