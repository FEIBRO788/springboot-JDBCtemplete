package cn.tedu.jdbctemplatedemo;

import cn.tedu.jdbctemplatedemo.entity.classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class JdbcTemplateDemoApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testQueryForList() {
        String sql = "select id,name,floor,teacher_id from class";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps.get(2).get("id"));//测试输出list一个元素中一//        for (Map<String,Object>map:maps){
//            System.out.println(map);
//        }

    }
    //查询class表中指定内容
    @Test
    public void testqueryformap(){
        String sql="select id, name, floor, teacher_id FROM class where name=?;";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, "3年级2班");

        System.out.println(stringObjectMap);
    }
    //查询class表中多条记录，并将结果封装到对象
    @Test
    public void testquery(){
        String sql="select id,name,floor,teacher_id from class where name like?";
        List<classes> query = jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(classes.class), "3%");
        //可以完成数据到JavaBean的自动封装 new BeanPropertyRowMapper<类型>(类型.class)
        for (classes classes:query){
            System.out.println(classes);
        }
    }
    //查询class表中总记录数（聚合函数查询用queryForObject)
    @Test
    public void testQueryForObject(){
        String sql="select count(id) from class;";
        Long l = jdbcTemplate.queryForObject(sql, long.class);
        //Long.class：指定返回结果的类型为Long
        System.out.println(l);



    }

}
