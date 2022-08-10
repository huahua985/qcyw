package qcyw.xchqcyws;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * @author LUW
 * @date 2022/07/27
 * @MapperScan 扫描dao接口路径
 * @EnableAsync 开启异步调用
 */
@SpringBootApplication
@MapperScan("qcyw.xchqcyws.mapper")
@EnableAsync
public class XchQcywApplication{
    public static void main(String[] args) {
        SpringApplication.run(XchQcywApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ 棋茶一味启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

}
