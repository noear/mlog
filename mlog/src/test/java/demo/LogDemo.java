package demo;

import org.noear.mlog.Logger;
import org.noear.mlog.LoggerFactory;
import org.noear.mlog.Metainfo;

/**
 * @author noear 2021/2/4 created
 */
public class LogDemo {
    static Logger logger = LoggerFactory.get(LogDemo.class);

    public static void main(String[] args) {
        //传统风格
        logger.info("{}:\n{}", "mlog", "hello world!");

        logger.info(Metainfo.m().put("order_id", "12").put("user_id", "1"),
                "{}:\n{}", "mlog", "hello world!");
    }
}
