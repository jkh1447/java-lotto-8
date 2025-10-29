package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGenerator {

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = money / LOTTO_PRICE;

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(Random.generateLottoNumbers()));
        }

        return lottos;
    }
}
