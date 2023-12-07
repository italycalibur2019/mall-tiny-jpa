package com.italycalibur.mall.tiny.jpa.entity.generator;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * 雪花算法id生成器
 * @author italycalibur
 * @since 2023/12/7
 */
@Slf4j
public class SnowflakeGenerator implements IdentifierGenerator {

    /**
     * 终端ID
     */
    @Value("${snowflake.worker-id}")
    public static long WORKER_ID;

    /**
     * 数据中心id
     */
    @Value("${snowflake.datacenter-id}")
    public static long DATACENTER_ID;

    private final Snowflake snowflake = IdUtil.getSnowflake(WORKER_ID, DATACENTER_ID);

    @PostConstruct
    public void init() {
        WORKER_ID = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()) >> 16 & 31;
        log.info("当前机器的workId:{}", WORKER_ID);
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        return snowflakeId(WORKER_ID, DATACENTER_ID);
    }
}
