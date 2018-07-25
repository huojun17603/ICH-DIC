import com.ich.core.base.JsonUtils;
import com.ich.core.http.entity.HttpResponse;
import com.ich.dictionary.pojo.IAddresscn;
import com.ich.dictionary.service.IAddresscnService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AddressCNTest extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private IAddresscnService addressCNService;


    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void findAddressCNofType( ) {
        List<IAddresscn> list = addressCNService.findAddressCNofType(1);
        List<Map<String,Object>> map = new ArrayList<>();
        for(IAddresscn addressCN : list){
            Map<String,Object> linkedHashMap2 = new LinkedHashMap();
            List<IAddresscn> list2 = addressCNService.findAddressCNofPid(addressCN.getId());
            List<Map<String,Object>> map2 = new ArrayList<>();
            linkedHashMap2.put("area_id",addressCN.getId());
            linkedHashMap2.put("area_name",addressCN.getName());
            linkedHashMap2.put("city",map2);
            map.add(linkedHashMap2);
            for(IAddresscn addressCN2 : list2){
                Map<String,Object> linkedHashMap3 = new LinkedHashMap();
                List<IAddresscn> list3 = addressCNService.findAddressCNofPid(addressCN2.getId());
                List<Map<String,Object>> map3 = new ArrayList<>();
                linkedHashMap3.put("area_id",addressCN2.getId());
                linkedHashMap3.put("area_name",addressCN2.getName());
                linkedHashMap3.put("area",map3);
                map2.add(linkedHashMap3);
                for(IAddresscn addressCN3 : list3){
                    Map<String,Object> linkedHashMap4 = new LinkedHashMap();
                    linkedHashMap4.put("area_id",addressCN3.getId());
                    linkedHashMap4.put("area_name",addressCN3.getName());
                    map3.add(linkedHashMap4);
                }
            }
        }
        System.out.println(JsonUtils.objectToJson(map));
        assertTrue(true);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void findAddressCNofPid( ) {
        List<IAddresscn> list = addressCNService.findAddressCNofPid(500000l);
        assertTrue(true);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void addOrEdit() {
        IAddresscn addressCN = new IAddresscn();
        addressCN.setId(1l);
        addressCN.setName("中国");
        addressCN.setLetter("Z");
        addressCN.setType(1);
        HttpResponse response = addressCNService.add(addressCN);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void editStatus( ) {
        HttpResponse response = addressCNService.editStatus(500000l,1);
        assertTrue(response.getStatus()==HttpResponse.HTTP_OK);
    }
}
