package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    public static List<LottoRank> lottoCheck(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        List<LottoRank> lottoResults = new ArrayList<>();
        for(Lotto lotto : lottos) {
            lottoResults.add(lotto.checkLotto(winningNumbers, bonus));
        }
        return lottoResults;
    }
}
