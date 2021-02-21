package demo;

import org.noear.mlog.Level;
import org.noear.mlog.Logger;
import org.noear.mlog.LoggerFactory;
import org.noear.mlog.Metainfo;
import org.noear.mlog.utils.Tags;

/**
 * @author noear 2021/2/4 created
 */
public class LogDemo {

    public static void main(String[] args) {
        LoggerFactory.setLevel(Level.TRACE);

        Logger logger = LoggerFactory.get(LogDemo.class);

        //传统风格
        logger.trace("{}: {}", "mlog", "hello world!");
        logger.debug("{}: {}", "mlog", "hello world!");
        logger.warn("{}: {}", "mlog", "hello world!");
        logger.error("{}: {}", "mlog", "hello world!");

        logger.info("{}: {}", "mlog", "hello world!");

        //元信息风格
        logger.info(Metainfo.m().put("order_id", "12").put("user_id", "1"),
                "{}: {}", "mlog", "hello world!");

        //标签元信息风格
        logger.info(Tags.tag0("order_" + 12).tag3("user_" + 1),
                "{}: {}", "mlog", "hello world!");


    }
}
