package org.graviton.network.protocol.enums;

public enum DareCriteriaTypeEnum {

    MONSTER_ID(0),
    CHALLENGE_ID(1),
    IDOLS(2),
    IDOLS_SCORE(3),
    MAX_CHAR_LVL(4),
    MAX_FIGHT_TURNS(5),
    MAX_COUNT_CHAR(6),
    MIN_COUNT_CHAR(7),
    FORBIDDEN_BREEDS(8),
    MANDATORY_BREEDS(9),
    MIN_COUNT_MONSTERS(10);

    private final int value;
    public DareCriteriaTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}