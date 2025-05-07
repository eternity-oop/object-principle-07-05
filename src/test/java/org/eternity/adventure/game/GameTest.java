package org.eternity.adventure.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    public void contains_welcome() {
        FakeInputOutput io = new FakeInputOutput("quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "환영합니다!",
                "당신은 [언덕]에 있습니다.",
                "저 멀리 성이 보이고 언덕 아래로 좁은 길이 나 있습니다.",
                "다음 명령어를 사용할 수 있습니다.",
                "go {north|east|south|west} - 이동, look - 보기, help - 도움말, quit - 게임 종료");
    }

    @Test
    public void move_north_passed() {
        FakeInputOutput io = new FakeInputOutput("go north", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [다리]에 있습니다.",
                "큰 강 위에 돌로 만든 커다란 다리가 있습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_north_blocked() {
        FakeInputOutput io = new FakeInputOutput("go north", "go north", "go north", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [다리]에 있습니다.",
                "큰 강 위에 돌로 만든 커다란 다리가 있습니다.",
                "> 당신은 [샘]에 있습니다.",
                "아름다운 샘물이 흐르는 곳입니다. 이곳에서 휴식을 취할 수 있습니다.",
                "> 이동할 수 없습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_east_passed() {
        FakeInputOutput io = new FakeInputOutput("go east", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [동굴]에 있습니다.",
                "어둠에 잠긴 동굴 안에 작은 화톳불이 피어 있습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_east_blocked() {
        FakeInputOutput io = new FakeInputOutput("go east", "go east", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [동굴]에 있습니다.",
                "어둠에 잠긴 동굴 안에 작은 화톳불이 피어 있습니다.",
                "> 이동할 수 없습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_south_passed() {
        FakeInputOutput io = new FakeInputOutput("go north", "go south", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [다리]에 있습니다.",
                "큰 강 위에 돌로 만든 커다란 다리가 있습니다.",
                "> 당신은 [언덕]에 있습니다.",
                "저 멀리 성이 보이고 언덕 아래로 좁은 길이 나 있습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_south_blocked() {
        FakeInputOutput io = new FakeInputOutput("go south", "quit");

        Game game = createGame(io);
        game.run();


        assertThat(io.outputs()).containsSequence(
                "> 이동할 수 없습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_west_passed() {
        FakeInputOutput io = new FakeInputOutput("go east", "go west", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [동굴]에 있습니다.",
                "어둠에 잠긴 동굴 안에 작은 화톳불이 피어 있습니다.",
                "> 당신은 [언덕]에 있습니다.",
                "저 멀리 성이 보이고 언덕 아래로 좁은 길이 나 있습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_west_blocked() {
        FakeInputOutput io = new FakeInputOutput("go west", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 이동할 수 없습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    @Test
    public void move_empty() {
        FakeInputOutput io = new FakeInputOutput("go north", "go north", "go east", "quit");

        Game game = createGame(io);
        game.run();

        assertThat(io.outputs()).containsSequence(
                "> 당신은 [다리]에 있습니다.",
                "큰 강 위에 돌로 만든 커다란 다리가 있습니다.",
                "> 당신은 [샘]에 있습니다.",
                "아름다운 샘물이 흐르는 곳입니다. 이곳에서 휴식을 취할 수 있습니다.",
                "> 이동할 수 없습니다.",
                "> ",
                "게임을 종료합니다.");
    }

    private Game createGame(FakeInputOutput io) {
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

        return new Game(player, commandParser, io);
    }
}
