package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Random;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> generateLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = money / LOTTO_PRICE;

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(Random.generateLottoNumbers()));
        }

        return lottos;
    }
}
