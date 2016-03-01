package com.github.t1.meta3;

import com.google.common.collect.ImmutableList;
import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

public class ReflectionVisitorTest extends AbstractVisitorTest {
    @Data
    public static class PojoContainer {
        private Pojo mappingOne = new Pojo();
    }

    @Data
    public static class Pojo {
        private String one = "a", two = "b";
    }

    @Override protected Object createFlatMapping() {
        return new Pojo();
    }

    @Override protected Object createNestedMapping() {
        return new PojoContainer();
    }

    @Override protected Object createFlatSequence() {
        return new String[] { "a", "b", "c" };
    }

    @Override protected Object createNestedSequence() {
        return new String[][] { { "a1", "a2", "a3" }, {}, { "c1" } };
    }

    @Data
    public static class MappingWithSequence {
        String[] a = { "x", "y", "z" };
        List<String> b = emptyList();
        List<String> c = ImmutableList.of("x");
    }

    @Override protected Object createMappingWithSequence() {
        return new MappingWithSequence();
    }

    @Override protected Object createSequenceWithMapping() {
        Pojo c = new Pojo();
        c.one = null;
        return ImmutableList.of(new Pojo(), new Object(), c);
    }
}
