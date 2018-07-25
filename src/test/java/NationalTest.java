import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.pojo.INational;
import com.ich.dictionary.service.INationalService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NationalTest extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private INationalService nationalService;



    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void findBanks( ) {
        List<INational> list = nationalService.findNationals();
        for(INational addressCN : list){
            System.out.println(addressCN.getName());
        }
        assertTrue(true);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void addOrEdit() {
        INational addressCN = new INational();
        addressCN.setCode("CNX");
        addressCN.setName("中国");
        HttpResponse response = nationalService.add(addressCN);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void editStatus( ) {
        HttpResponse response = nationalService.editStatus(1l,1);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }
}
