package org.noear.mlog;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 元信息
 *
 * @author noear
 * @since 1.0
 */
public class Metainfo {
    Map<String, String> data = new LinkedHashMap<>();

    public String get(String key) {
        return data.get(key);
    }

    public Metainfo put(String key, String value) {
        data.put(key, value);
        return this;
    }

    public Metainfo remove(String key) {
        data.remove(key);
        return this;
    }

    public Set<String> allKeys() {
        return data.keySet();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        data.forEach((k, v) -> {
            buf.append("[").append(k).append(":").append(v).append("]");
        });

        return buf.toString();
    }
}
