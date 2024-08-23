package javaprogramming.commonmistakes.nosqluse.redisvsmysql;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
@RequestMapping("redisvsmysql")
public class PerformanceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("redis")
    public void redis() {
        Assert.assertEquals(stringRedisTemplate.opsForValue().get("item" + (ThreadLocalRandom.current().nextInt(CommonMistakesApplication.ROWS) + 1)), CommonMistakesApplication.PAYLOAD);
    }

    @GetMapping("redis2")
    public void redis2() {
        Assert.assertEquals(1111, stringRedisTemplate.keys("item71*").size());
    }

    @GetMapping("mysql")
    public void mysql() {
        Assert.assertEquals(jdbcTemplate.queryForObject("SELECT data FROM `r` WHERE name=?", new Object[]{("item" + (ThreadLocalRandom.current().nextInt(CommonMistakesApplication.ROWS) + 1))}, String.class), CommonMistakesApplication.PAYLOAD);
    }

    @GetMapping("mysql2")
    public void mysql2() {
        Assert.assertEquals(1111, jdbcTemplate.queryForList("SELECT name FROM `r` WHERE name LIKE 'item71%'", String.class).size());
    }
}
