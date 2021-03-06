package com.lj.test.demo;

import com.lj.test.demo.model.ConfigBean;
import com.lj.test.demo.model.User;
import com.lj.test.demo.service.IProfileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class DemoApplication extends SpringBootServletInitializer {
    @Autowired
    ConfigBean configBean;
    @Autowired
    IProfileConfig profileConfig;

    @RequestMapping("/index")
    public String index(){
        profileConfig.configure();
        return configBean.getName()+":"+configBean.getWant();
    }

    @RequestMapping("/template")
    public ModelAndView template(){
        List<User> userList = new ArrayList<User>();
        User user = new User("张三","123456","HR",29,"深圳宝安区232号");
        userList.add(user);
        user = new User("李四","666666","Core engginer",32,"广州天河区22号");
        userList.add(user);
        ModelAndView modelAndView = new ModelAndView("/template");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    /**
     * 外部容器部署的话，就不能依赖于Application的main函数了，
     * 而是要以类似于web.xml文件配置的方式来启动Spring应用上下文，
     * 此时我们需要在启动类中继承SpringBootServletInitializer并实现configure方法
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

}