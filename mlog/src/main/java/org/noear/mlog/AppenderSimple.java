package org.noear.mlog;

import java.util.Date;

/**
 * @author noear 2021/2/21 created
 */
public class AppenderSimple implements Appender {
    private String name = "simple";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void append(String name, Level level, Metainfo metainfo, Object content) {
        if (LoggerFactory.getLevel().code > level.code) {
            return;
        }

        appendDo(name, level, metainfo, content);
    }

    protected void appendDo(String name, Level level, Metainfo metainfo, Object content) {
        String text = null;

        if (metainfo == null) {
            text = String.format("%s [%s] %s:: %s",
                    new Date().toInstant().toString(),
                    level.name(),
                    name,
                    content);
        } else {
            text = String.format("%s [%s] %s %s:: %s",
                    new Date().toInstant().toString(),
                    level.name(),
                    metainfo.toString(),
                    name,
                    content);
        }

        System.out.println(text);
    }
}
