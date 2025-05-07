package org.eternity.adventure.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class PlayerTest {
    @Test
    public void move_east() {
        WorldMap worldMap = new WorldMap(
                Size.with(2, 2),
                new Room(Position.of(0, 0), "", ""),
                new Room(Position.of(1, 0), "", ""),
                new Room(Position.of(1, 1), "", ""));
        Player player = new Player(worldMap, Position.of(0, 0));

        assertThat(player.canMove(Direction.EAST)).isTrue();

        player.move(Direction.EAST);
        assertThat(player.position()).isEqualTo(Position.of(1, 0));
    }

    @Test
    public void can_not_move_west() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            WorldMap worldMap = new WorldMap(
                    Size.with(2, 2),
                    new Room(Position.of(0, 0), "", ""),
                    new Room(Position.of(1, 0), "", ""),
                    new Room(Position.of(1, 1), "", ""));
            Player player = new Player(worldMap, Position.of(1, 1));

            player.move(Direction.WEST);
        });
    }

    @Test
    public void can_not_move_outside() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            WorldMap worldMap = new WorldMap(
                    Size.with(2, 2),
                    new Room(Position.of(0, 0), "", ""),
                    new Room(Position.of(1, 0), "", ""),
                    new Room(Position.of(1, 1), "", ""));
            Player player = new Player(worldMap, Position.of(1, 1));

            player.move(Direction.WEST);
        });
    }
}
