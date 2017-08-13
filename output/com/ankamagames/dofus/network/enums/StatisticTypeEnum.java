package com.ankamagames.dofus.network.enums;

public enum StatisticTypeEnum {

    STEP0000_CHOSE_NICKNAME(78),
    STEP0100_CHOSE_SERVER(79),
    STEP0200_CREATE_FIRST_CHARACTER(80),
    STEP0300_LOADING_SCREEN(81),
    STEP0400_DOFUS_TRAILER(82),
    STEP0500_ARRIVES_ON_TUTORIAL(83),
    STEP0550_QUITS_TUTORIAL(84),
    STEP0600_TUTO1_MOVE_MAP(85),
    STEP0700_TUTO2_TALK_TO_YAKASI(86),
    STEP0800_TUTO3_EQUIP_RING(87),
    STEP0820_CLIC_BAG(88),
    STEP0840_CLIC_RING(89),
    STEP0860_EQUIP_RING(90),
    STEP0860_EXIT_BAG(91),
    STEP0900_TUTO4_CHANGE_MAP(92),
    STEP1000_TUTO5_START_FIRST_FIGHT(93),
    STEP1100_TUTO6_CHOSE_START_POSITION(94),
    STEP1130_CHOSE_POSITION(95),
    STEP1160_CLIC_READY(96),
    STEP1200_TUTO7_MOVE_IN_FIGHT(97),
    STEP1900_TUTO8_USE_SPELL(98),
    STEP1930_CHOSE_SPELL(99),
    STEP1960_USE_SPELL(100),
    STEP2000_TUTO9_END_TURN(101),
    STEP2100_TUTO10_WIN_FIGHT(102),
    STEP2050_TUTO10_LOSE_FIGHT(103),
    STEP2200_TUTO11_START_FIRST_QUEST(104),
    STEP2220_CLIC_YAKASI(105),
    STEP2240_TALK_YAKASI(106),
    STEP2260_ACCEPT_MISSION(107),
    STEP2300_TUTO12_EQUIP_SET(108),
    STEP2350_EXIT_BAG(109),
    STEP2400_TUTO13_LETS_KILL_MONSTER(110),
    STEP2430_GO_TO_NEXT_MAP(111),
    STEP2460_CLIC_MONSTER(112),
    STEP2500_TUTO14_END_SECOND_FIGHT(113),
    STEP2600_TUTO15_END_TUTO(114),
    STEP2620_CLIC_YAKASI(115),
    STEP2640_END_DIALOG(116),
    CLICK_ON_BUTTON(151),
    DISPLAY_MENU(152),
    CATEGORY_MAP_OPENED(544),
    CATEGORY_MAP_PERSONALIZED_LANDMARK_PLACED(546),
    CATEGORY_MAP_QUEST_LANDMARK_ACTIVATED(547),
    CATEGORY_MAP_MOVED(549),
    CATEGORY_MAP_ZOOM(550),
    CATEGORY_MINIMAP_MOVED(545),
    CATEGORY_MINIMAP_ZOOM(548);

    private final int value;
    public StatisticTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public StatisticTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}