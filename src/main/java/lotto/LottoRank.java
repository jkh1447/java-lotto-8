package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank of(int match, boolean bonus) {
        if (match == 6 && bonus) return SECOND;
        if (match == 6) return FIRST;
        if (match == 5) return THIRD;
        if (match == 4) return FOURTH;
        if (match == 3) return FIFTH;
        return MISS;
    }
}
