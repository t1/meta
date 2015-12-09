package com.github.t1.meta2.test;

import java.util.*;

import com.github.t1.meta2.Mapping;
import com.github.t1.meta2.reflection.CollectionsMapping;

public class CollectionsMappingTest extends AbstractMappingTest<Map<String, Object>> {
    @Override
    protected Map<String, Object> createObject() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("stringProperty", STRING_VALUE);
        map.put("booleanProperty", BOOLEAN_VALUE);
        map.put("charProperty", CHARACTER_VALUE);
        map.put("byteProperty", BYTE_VALUE);
        map.put("shortProperty", SHORT_VALUE);
        map.put("intProperty", INT_VALUE);
        map.put("integerProperty", INTEGER_VALUE);
        map.put("longProperty", LONG_VALUE);
        map.put("floatProperty", FLOAT_VALUE);
        map.put("doubleProperty", DOUBLE_VALUE);

        map.put("intArrayProperty", INT_ARRAY_VALUE);
        map.put("intListProperty", INT_LIST_VALUE);
        map.put("stringListProperty", STRING_LIST_VALUE);

        Map<String, Object> nestedMap = new LinkedHashMap<>();
        nestedMap.put("nestedStringProperty", "nestedString");
        map.put("nestedProperty", nestedMap);

        Map<String, Object> nestingMap = new LinkedHashMap<>();
        nestingMap.put("nestedProperty", nestedMap);
        map.put("nestingProperty", nestingMap);

        return map;
    }

    @Override
    protected Mapping<Map<String, Object>> createMapping() {
        return CollectionsMapping.of(object);
    }

}