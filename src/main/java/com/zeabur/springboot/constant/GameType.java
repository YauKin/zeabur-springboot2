package com.zeabur.springboot.constant;

public enum GameType {
    ALL_CATEGORIES(1, "All Categories"),
    ROLE_PLAYING(7, "角色扮演"),
    COMPETITIVE(8, "競技遊戲"),
    ACTION(9, "動作遊戲"),
    STRATEGY(10, "策略遊戲"),
    RACING(11, "賽車遊戲"),
    PARTY(12, "聚會遊戲"),
    ADVENTURE(13, "冒險遊戲"),
    FIGHTING(14, "格鬥遊戲"),
    SHOOTING(15, "射擊遊戲"),
    PUZZLE(16, "解謎遊戲"),
    SIMULATION(17, "養成遊戲"),
    MUSIC(18, "音樂遊戲"),
    CASUAL_PUZZLE(19, "休閒益智");

    private final int id;
    private final String categoryName;

    GameType(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static GameType getById(int id) {
        for (GameType gameType : values()) {
            if (gameType.getId() == id) {
                return gameType;
            }
        }
        throw new IllegalArgumentException("Invalid id: " + id);
    }
}
