package org.eternity.adventure.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeTest {
    @Test
    public void index_at() {
        Size area = Size.with(2, 2);
        assertThat(area.indexOf(Position.of(0, 0))).isEqualTo(0);
        assertThat(area.indexOf(Position.of(1, 0))).isEqualTo(1);
        assertThat(area.indexOf(Position.of(0, 1))).isEqualTo(2);
        assertThat(area.indexOf(Position.of(1, 1))).isEqualTo(3);
    }

    @Test
    public void contains_true() {
        Size area = Size.with(2, 2);
        assertThat(area.contains(Position.of(0, 0))).isTrue();
        assertThat(area.contains(Position.of(1, 0))).isTrue();
        assertThat(area.contains(Position.of(0, 1))).isTrue();
        assertThat(area.contains(Position.of(1, 1))).isTrue();
    }

    @Test
    public void contains_false() {
        Size area = Size.with(1, 1);
        assertThat(area.contains(Position.of(-1, 0))).isFalse();
        assertThat(area.contains(Position.of(0, -1))).isFalse();
        assertThat(area.contains(Position.of(0, 2))).isFalse();
        assertThat(area.contains(Position.of(2, 0))).isFalse();
    }
}
