package com.yomahub.liteflow.test.execute2Future;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.entity.data.DefaultSlot;
import com.yomahub.liteflow.entity.data.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * springboot环境执行返回future的例子
 * @author Bryan.Zhang
 * @since 2.6.13
 */
@RunWith(SpringRunner.class)
@TestPropertySource(value = "classpath:/execute2Future/application.properties")
@SpringBootTest(classes = Executor2FutureSpringbootTest.class)
@EnableAutoConfiguration
@ComponentScan({"com.yomahub.liteflow.test.execute2Future.cmp"})
public class Executor2FutureSpringbootTest extends BaseTest {

    @Resource
    private FlowExecutor flowExecutor;

    @Test
    public void testFuture() throws Exception{
        Future<LiteflowResponse<DefaultSlot>> future = flowExecutor.execute2Future("chain1", "arg", DefaultSlot.class);
        LiteflowResponse<DefaultSlot> response = future.get();
        Assert.assertTrue(response.isSuccess());
    }

}
