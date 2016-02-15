package com.github.t1.meta2;

import java.util.Optional;

/**
 * An atomic object, i.e. one that has no sub-structure.
 */
public interface Scalar<B> {
    <T> Optional<T> get(B object, Class<T> type);
}
