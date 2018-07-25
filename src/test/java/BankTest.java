import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.pojo.IBank;
import com.ich.dictionary.service.IBankService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BankTest extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private IBankService bankService;



    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void findBanks( ) {
        List<IBank> list = bankService.findBanks();
        for(IBank addressCN : list){
            System.out.println(addressCN.getName());
        }
        assertTrue(true);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void addOrEdit() {
        IBank addressCN = new IBank();
        addressCN.setCode("BOCX");
        addressCN.setName("中国银行");
        addressCN.setThemecode("#da251e");
        HttpResponse response = bankService.add(addressCN);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void editStatus( ) {
        HttpResponse response = bankService.editStatus(1l,1);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }
}
