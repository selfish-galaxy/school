package com.yyn.phone.consumer;

import com.yyn.phone.consumer.service.ColorService;
import com.yyn.phone.provider.dao.UserRepository;
import com.yyn.phone.provider.pojo.Color;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {
    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @Resource
    private ColorService colorService;

    @Test
    public void ddd(){
        PageBean forObject = restTemplate.getForObject("http://service-provider/page?page={1}&size={2}", PageBean.class, 1, 3);
        System.out.println(forObject.toString());
    }

    @Test
    public void ff(){
        List<Color> allColors = colorService.findAllColors();
        System.out.println(allColors);
    }

}
