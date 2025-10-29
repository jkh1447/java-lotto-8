package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    public static List<LottoRank> lottoCheck(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        List<LottoRank> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(lotto.checkLotto(winningNumbers, bonus));
        }
        return lottoResults;
    }

    public Map<String, Integer> countLottoMatches(List<LottoRank> lottoResults) {
        Map<String, Integer> rankCounts = new HashMap<>();

        for (LottoRank lottoRank : lottoResults) {
            rankCounts.put(lottoRank.name(), rankCounts.get(lottoRank.name()) + 1);
        }

        return rankCounts;
    }
}
