import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.pojo.AddressCN;
import com.ich.dictionary.pojo.Bank;
import com.ich.dictionary.service.AddressCNService;
import com.ich.dictionary.service.BankService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BankTest extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private BankService bankService;



    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void findBanks( ) {
        List<Bank> list = bankService.findBanks();
        for(Bank addressCN : list){
            System.out.println(addressCN.getName());
        }
        assertTrue(true);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void addOrEdit() {
        Bank addressCN = new Bank();
        addressCN.setCode("BOC");
        addressCN.setName("中国银行");
        addressCN.setThemecode("#da251e");
        HttpResponse response = bankService.addOrEdit(addressCN);
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
