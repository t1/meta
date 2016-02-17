package com.github.t1.meta2.json;

import static com.github.t1.meta2.json.JsonCast.*;

import java.util.Optional;
import java.util.function.Function;

import javax.json.*;

import com.github.t1.meta2.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class JsonSequence<B extends JsonValue> implements Sequence<B> {
    private final Function<B, B> backtrack;

    @Override
    public Scalar<B> getScalar(int i) {
        return new Scalar<B>() {
            @Override
            public <T> Optional<T> get(B object, Class<T> type) {
                return Optional.ofNullable(cast(backtrack(object, i), type));
            }
        };
    }

    @Override
    public Sequence<B> getSequence(int i) {
        return new JsonSequence<>(object -> backtrack(object, i));
    }

    @Override
    public Mapping<B> getMapping(int i) {
        return new JsonMapping<>(object -> backtrack(object, i));
    }

    private B backtrack(B object, int i) {
        JsonArray array = (JsonArray) backtrack.apply(object);
        if (array == null || i >= array.size())
            return null;
        @SuppressWarnings("unchecked")
        B backtracked = (B) array.get(i);
        return backtracked;
    }
}
