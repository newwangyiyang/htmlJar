package cn.yiyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("cn.yiyang.*.dao")
@EnableTransactionManagement // 开启注解事务管理
@EnableScheduling
@SpringBootApplication
public class BookApplication {
	//extends SpringBootServletInitializer
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
        System.out.println("/**\n" +
				" *                             _ooOoo_\n" +
				" *                            o8888888o\n" +
				" *                            88\" . \"88\n" +
				" *                            (| -_- |)\n" +
				" *                            O\\  =  /O\n" +
				" *                         ____/`---'\\____\n" +
				" *                       .'  \\\\|     |//  `.\n" +
				" *                      /  \\\\|||  :  |||//  \\\n" +
				" *                     /  _||||| -:- |||||-  \\\n" +
				" *                     |   | \\\\\\  -  /// |   |\n" +
				" *                     | \\_|  ''\\---/''  |   |\n" +
				" *                     \\  .-\\__  `-`  ___/-. /\n" +
				" *                   ___`. .'  /--.--\\  `. . __\n" +
				" *                .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
				" *               | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
				" *               \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
				" *          ======`-.____`-.___\\_____/___.-`____.-'======\n" +
				" *                             `=---='\n" +
				" *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
				" *                     佛祖保佑        永无BUG\n" +
				"*/\n  ");
	}

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	// 	// 注意的Application是启动类，就是main方法所属的类
	// 	return builder.sources(ModelApplication.class);
	// }
}