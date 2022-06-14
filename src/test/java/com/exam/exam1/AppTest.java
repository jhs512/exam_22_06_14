// src/test/java/com/exam/exam1/AppTest.java
package com.exam.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void _1_더하기_1() {
        assertEquals(2, new Calc().run("1 + 1"));
    }

    @Test
    public void _1_더하기_2() {
        assertEquals(3, new Calc().run("1 + 2"));
    }

    @Test
    public void _1_빼기_1() {
        assertEquals(0, new Calc().run("1 - 1"));
    }

    @Test
    public void _2_빼기_1() {
        assertEquals(1, new Calc().run("2 - 1"));
    }

    @Test
    public void _1_곱하기_1() {
        assertEquals(1, new Calc().run("1 * 1"));
    }

    @Test
    public void _2_곱하기_1() {
        assertEquals(2, new Calc().run("2 * 1"));
    }

    @Test
    public void _1_나누기_1() {
        assertEquals(1, new Calc().run("1 / 1"));
    }

    @Test
    public void _2_나누기_1() {
        assertEquals(2, new Calc().run("2 / 1"));
    }

    @Test
    public void 괄호_2_더하기_1() {
        assertEquals(3, new Calc().run("(2 + 1)"));
    }

    @Test
    public void 괄호_2_빼기_1() {
        assertEquals(1, new Calc().run("(2 - 1)"));
    }

    @Test
    public void 괄호_2_곱하기_1() {
        assertEquals(2, new Calc().run("(2 * 1)"));
    }

    @Test
    public void 괄호_2_나누기_1() {
        assertEquals(2, new Calc().run("(2 / 1)"));
    }

    @Test
    public void 괄호두겹_2_더하기_1() {
        assertEquals(3, new Calc().run("((2 + 1))"));
    }

    @Test
    public void 괄호세겹_2_더하기_1() {
        assertEquals(3, new Calc().run("(((2 + 1)))"));
    }

    @Test
    public void 복합연산__괄호열기_1_더하기_4_괄호닫기_곱하기_2() {
        assertEquals(10, new Calc().run("(1 + 4) * 2"));
    }
}