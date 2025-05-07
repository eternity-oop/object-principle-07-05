package org.eternity.adventure;

import org.eternity.adventure.console.Console;
import org.eternity.adventure.game.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(
                new WorldMap(
                        Size.with(2, 3),
                        new Room(Position.of(0, 0), "샘", "아름다운 샘물이 흐르는 곳입니다. 이곳에서 휴식을 취할 수 있습니다."),
                        new Room(Position.of(0, 1), "다리", "큰 강 위에 돌로 만든 커다란 다리가 있습니다."),
                        new Room(Position.of(1, 1), "성", "용왕이 살고 있는 성에 도착했습니다."),
                        new Room(Position.of(0, 2), "언덕", "저 멀리 성이 보이고 언덕 아래로 좁은 길이 나 있습니다."),
                        new Room(Position.of(1, 2), "동굴", "어둠에 잠긴 동굴 안에 작은 화톳불이 피어 있습니다.")),
                Position.of(0, 2));
        CommandParser commandParser = new CommandParser();
        InputOutput io = new Console();

        Game game = new Game(player, commandParser, io);
        game.run();
    }
}